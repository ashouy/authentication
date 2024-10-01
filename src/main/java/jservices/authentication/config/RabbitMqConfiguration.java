package jservices.authentication.config;

import jservices.authentication.messages.amqp.exchanges.AbcExchangeProperties;
import jservices.authentication.messages.amqp.queues.notification.NotificationProperties;
import jservices.authentication.messages.amqp.queues.welcome.WelcomeProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//@slf4j
@RequiredArgsConstructor
public class RabbitMqConfiguration {
    private final WelcomeProperties ticketQueueProperties;
    private final NotificationProperties notificationProperties;
    private final AbcExchangeProperties abcExchangeProperties;
    @Bean
    public Queue welcomeQueue(){
        return new Queue(ticketQueueProperties.getName(), true);
    }
    @Bean
    public Queue notificationQueue(){
        return new Queue(notificationProperties.getName(), notificationProperties.isDurable());
    }

    @Bean
    TopicExchange abcExchange() {
        return new TopicExchange(abcExchangeProperties.getName());
    }

    @Bean
    Binding bindWelcome(TopicExchange exchange) {
        return BindingBuilder.bind(welcomeQueue()).to(exchange).with(abcExchangeProperties.getRoutingKeyWelcome());
    }
    @Bean
    Binding bindNotification(TopicExchange exchange) {
        return BindingBuilder.bind(notificationQueue()).to(exchange).with(abcExchangeProperties.getRoutingKeyNotification());
    }
}
