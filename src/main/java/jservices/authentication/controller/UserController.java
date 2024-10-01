package jservices.authentication.controller;

import jservices.authentication.messages.amqp.queues.notification.NotificationPublisher;
import jservices.authentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
//    private final UserRepository repository;
    private final NotificationPublisher publisher;

    @GetMapping("/test")
    public String test(){
        publisher.publish("hello 2");
        return "teste";
    }
}