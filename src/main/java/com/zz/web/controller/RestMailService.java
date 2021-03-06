package com.zz.web.controller;

import com.zz.service.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestMailService {

    private static final Logger logger = LoggerFactory.getLogger(RestMailService.class);

    @Resource
    private EmailSender emailSender;

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody  Payload payload) throws Exception {
        logger.info("About to send and email");
        Map<String,Object> ctx = new HashMap<>();
        ctx.put("message",payload.message);
        emailSender.prepareAndSend(payload.from,payload.to.split(","),payload.subject,ctx);
        logger.info("Email request sent...");
    }

    static class Payload {
        public String from;
        public String to;
        public String subject;
        public String message;
    }
}