package org.sebprojects.expensetracker_user.kafka;

import org.sebprojects.expensetracker_user.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.sebprojects.expensetracker.dtos.UserInfoDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class UserDtoInfoConsumer {

    @Autowired
    UserDetailsService userDetailsService;


    @KafkaListener(topics = "user_info_topic", groupId = "user-info-group-2", containerFactory = "kafkaListenerContainerFactoryUserInfoDto")
    public void consumeUserInfoDto(UserInfoDto userInfoDto) {
        System.out.println("Received UserInfoDto: " + userInfoDto);
        // Convert this UserInfoDto to our UserInfoDto if you want

        userDetailsService.saveUserDetails(userInfoDto);


    }
}
