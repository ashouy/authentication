package jservices.authentication.messages.amqp.queues.welcome;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class WelcomePublisher {
    private final WelcomeProperties ticketQueueProperties;
    private final RabbitTemplate rabbitTemplate;

    public void publish(String message) {
        rabbitTemplate.convertAndSend(ticketQueueProperties.getName(), message);
    }
}
