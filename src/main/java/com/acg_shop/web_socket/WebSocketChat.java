package com.acg_shop.web_socket;

import com.acg_shop.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * WebSocketChat
 * Created by mac_zly on 2017/6/7.
 */

@Controller
public class WebSocketChat {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;     // 用于转发数据(sendTo)

    @RequestMapping("/ip")
    @ResponseBody
    public String getIpAddress(HttpServletRequest request) {
        return request.getRemoteAddr();
    }

    @RequestMapping("/helloSocket")
    public String socketPage() {
        return "socket";
    }

    @MessageMapping("/change-notice")
    public void greeting(String message) {
        simpMessagingTemplate.convertAndSend("/topic/notice", message);
    }

}
