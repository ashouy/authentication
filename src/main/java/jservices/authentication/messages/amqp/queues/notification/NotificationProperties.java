package jservices.authentication.messages.amqp.queues.notification;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("broker.queues.notification")
public class NotificationProperties {
    private String name;
    private boolean durable;
    private boolean autoDelete;
    private boolean exclusive;
}
