package com.acg_shop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

/**
 * WebScoket配置
 * Created by mac_zly on 2017/6/7.
 */

@Configuration
@EnableWebSocketMessageBroker // 启用STOMP消息
@ComponentScan("com.acg_shop.web_socket")
public class WebScoketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    // SockJS连接我们的服务器
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //添加这个Endpoint，这样在网页中就可以通过websocket连接上服务了
        stompEndpointRegistry.addEndpoint("/socket").withSockJS();
    }

    // 大意是设置消息代理，也就是页面上用js来订阅的地址，也是我们服务器往WebSocket端接收js端发送消息的地址。
    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        System.out.println("服务器启动成功");
        //这里设置的simple broker是指可以订阅的地址，也就是服务器可以发送的地址
        /*
         * userChat 用于用户聊天
         */
        messageBrokerRegistry.enableSimpleBroker("/topic");
        messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
    }
}
