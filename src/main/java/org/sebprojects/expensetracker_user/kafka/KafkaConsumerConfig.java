package org.sebprojects.expensetracker_user.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.sebprojects.expensetracker.dtos.UserInfoDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, String> consumerFactoryTest() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group-id-2");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configProps);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryTest());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, UserInfoDto> consumerFactoryUserInfoDto() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "user-info-group-2");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        // SO it was sending the header "org.sebprojects.expensetracker.dtos.UserInfoDto" that was from the producer, so I have to make the same path in this Consumer Microservice, this is not a good practice, but it is a test
        configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "UserInfoDto:org.sebprojects.expensetracker.dtos.UserInfoDto");
        configProps.put(JsonDeserializer.TYPE_MAPPINGS,
                "UserInfoDto:org.sebprojects.expensetracker.dtos.UserInfoDto");
        return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), new JsonDeserializer<>(UserInfoDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserInfoDto> kafkaListenerContainerFactoryUserInfoDto() {
        ConcurrentKafkaListenerContainerFactory<String, UserInfoDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryUserInfoDto());
        return factory;
    }

}
