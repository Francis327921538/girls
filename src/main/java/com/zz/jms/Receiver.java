package com.zz.jms;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Receiver {

    @Resource
    private SimpMessageSendingOperations sender;

    @JmsListener(destination = "mailbox1", containerFactory = "myFactory")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        sender.convertAndSend("/topic/all", "hello everyone, jms &　websocket!");
    }

    @JmsListener(destination = "mailbox2", containerFactory = "myFactory")
    public void receiveMessageToOne(String message) {
        System.out.println("=======================");
        sender.convertAndSendToUser("zz", "/topic/one", "hello" + "zz" + " jms &　websocket!");
    }

}
