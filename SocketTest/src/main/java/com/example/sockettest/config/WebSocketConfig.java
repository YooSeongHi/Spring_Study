package com.example.sockettest.config;

import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketMessagingAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //websocket 서버 활성화
//WebSocketMessageBrokerConfigurer - 웹 소켑 연결 구성 위한 메서드를 구현하고 제공
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    //클라이언트가 웹 소켓 서버에 연결하는데 사용할 웹 소켓 엔드포인트 등록
    //엔드 포인트 구성에 withSockJS() 사용, SockJS()는 웹 소켓 지원하지 않는 브라우저에
    //폴백 옵션을 활성화하는데 사용
    //Fallback - 어떤 기능이 약해지거나 제대로 동작하지 않을때 이에 대처하는 기능 또는 동작작
   @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ws").withSockJS();

    }

    //한 클라이언트에서 다른 클라이언트로 메시지 라우팅 하는데 사용될 메시지 브로커 구성
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
       // /app 시작되는 메시지가 message-handling methos으로 라우팅 되어야함을 명시
       registry.setApplicationDestinationPrefixes("/app");
       // /topic 시작되는 메시지가 메시지브로커로 라우팅되도록 정의
        //메시지 크로커는 특정 주제 구독한 모든 클라이언트에게 메세지 broadcast
       registry.enableSimpleBroker("/topic");
    }
}
