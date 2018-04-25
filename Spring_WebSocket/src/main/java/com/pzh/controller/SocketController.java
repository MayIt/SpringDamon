package com.pzh.controller;

import com.pzh.scheduling.SchedulingTaskConfig;
import com.pzh.websocket.MyHandler;
import com.pzh.websocket.WebSocketConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpSession;

@Controller
public class SocketController {
    @Autowired
    MyHandler handler;
    @RequestMapping("/webSocket")
    @ResponseBody
    public ModelAndView  webSocket(){
        return new ModelAndView("system/webSocketIndex");
    }
    @RequestMapping("/login/{userId}")
    public @ResponseBody
    String login(HttpSession session, @PathVariable("userId") Integer userId) {
        System.out.println("登录接口,userId="+userId);
        session.setAttribute("userId", userId);
        System.out.println(session.getAttribute("userId"));
        new AnnotationConfigApplicationContext(WebSocketConfig.class);
        new AnnotationConfigApplicationContext(SchedulingTaskConfig.class);
        return "success";
    }

    @RequestMapping("/message")
    public @ResponseBody String sendMessage() {
        boolean hasSend = handler.sendMessageToUser(4, new TextMessage("发送一条消息"));
        System.out.println(hasSend);
        return "message";
    }
}
