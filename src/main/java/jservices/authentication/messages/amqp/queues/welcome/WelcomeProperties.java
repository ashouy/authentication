package jservices.authentication.messages.amqp.queues.welcome;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("broker.queues.welcome")
public class WelcomeProperties {
    private String name;
    private boolean durable;
    private boolean autoDelete;
    private boolean exclusive;

}
