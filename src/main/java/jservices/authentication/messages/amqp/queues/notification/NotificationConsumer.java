package jservices.authentication.messages.amqp.queues.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NotificationConsumer {
    public final NotificationProperties notificationProperties;
    private final RabbitTemplate rabbitTemplate;
    @RabbitListener(queues = "default.notification")
    public void consume(String message){
        System.out.println("received" + message);
    }
}
