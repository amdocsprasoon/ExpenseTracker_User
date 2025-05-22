package org.sebprojects.expensetracker_user.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageTestConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group-id-2")
    public void listen(String message) {
        System.out.println("Seb Received message: " + message);

    }
}
