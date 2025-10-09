package vn.iostart.WebSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Đăng ký endpoint "/ws". Client sẽ kết nối vào địa chỉ này.
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Tin nhắn gửi từ client đến server sẽ có tiền tố "/app".
        registry.setApplicationDestinationPrefixes("/app");
        // Tin nhắn từ server đến client sẽ được phát trên các topic có tiền tố "/topic".
        registry.enableSimpleBroker("/topic");
    }
}