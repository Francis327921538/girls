package com.zz.websocket.controller;

import com.zz.websocket.message.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
public class GreetingController {

    @MessageMapping("/everyone")
    @SendTo("/topic/all")
    public String greeting(HelloMessage message, Principal principal) throws Exception {
        Thread.sleep(1000); // simulated delay
        return "Hello, " + principal.getName() + message.getName() + "!";
    }

    @MessageMapping("/one")
    @SendToUser("/topic/one")
    public String greetingToOne(HelloMessage message, Principal principal, @PathVariable String username) throws Exception {
        System.err.println(username);
        Thread.sleep(1000); // simulated delay
        return "Hello aaaaaa, " + principal.getName() + message.getName() + "!";
    }

}
