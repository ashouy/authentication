package jservices.authentication.messages.amqp.queues.notification;


import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NotificationPublisher {
    private final NotificationProperties notificationProperties;
    private final RabbitTemplate rabbitTemplate;

    public void publish(String message)  {
        rabbitTemplate.convertAndSend(notificationProperties.getName(), message);
    }
}
