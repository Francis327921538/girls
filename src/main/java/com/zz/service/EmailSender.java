package com.zz.service;

import com.zz.utils.mail.MailTemplateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class EmailSender {

    private static final Logger logger = LoggerFactory.getLogger(EmailSender.class);

    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private MailTemplateHandler mailTemplateHandler;

    @Autowired
    public EmailSender(JavaMailSender javaMailSender, MailTemplateHandler mailTemplateHandler) {
        this.javaMailSender = javaMailSender;
        this.mailTemplateHandler = mailTemplateHandler;
    }

    @Async
    public void prepareAndSend(String from, String[] recipients, String subject, Map<String,Object> ctx) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(from);
            messageHelper.setTo(recipients);
            messageHelper.setSubject(subject);
            String content = mailTemplateHandler.generateContent(ctx);
            messageHelper.setText(content, true);
        };
        try {
            javaMailSender.send(messagePreparator);
            logger.info("发送成功");
        } catch (MailException e) {
            logger.error("Error occured while attempting to send an email",e);
        }
    }

}