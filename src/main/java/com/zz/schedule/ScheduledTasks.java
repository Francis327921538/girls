package com.zz.schedule;

import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Resource
    private JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        jmsTemplate.convertAndSend("mailbox1","hello jms&schedule");
    }

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTimeOne() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        jmsTemplate.convertAndSend("mailbox2","hello jms&schedule");
    }
}
