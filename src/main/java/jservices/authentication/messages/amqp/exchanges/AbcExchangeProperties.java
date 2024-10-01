package jservices.authentication.messages.amqp.exchanges;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("broker.exchanges.abc")
public class AbcExchangeProperties {
    private String name;
    private String routingKeyWelcome;
    private String routingKeyNotification;

}
