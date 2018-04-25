package com.pzh.scheduling;

import com.pzh.websocket.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import org.springframework.scheduling.annotation.Scheduled;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SchedulingTask {
    private  static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:hh:ss");
    MyHandler handler=new MyHandler();
    @Scheduled (fixedDelay = 30000)
    public void  sendMessageToIndex(){
        System.out.println("每隔两秒执行发送消息给页面"+date.format(new Date()));
     handler.sendMessageToUser(4,new TextMessage("每隔两秒执行发送消息给页面"+date.format(new Date())));
    }
}
