package com.gordonramsay.product.messaging;

import org.springframework.kafka.core.KafkaTemplate;

public class KafkaPublisher<T> implements Publisher<T> {
    private final KafkaTemplate<String, T> kafkaTemplate;

    public KafkaPublisher(KafkaTemplate<String, T> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(String topic, T message) {
        kafkaTemplate.send(topic, message);
    }
}
