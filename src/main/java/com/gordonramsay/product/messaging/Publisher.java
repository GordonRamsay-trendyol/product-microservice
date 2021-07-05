package com.gordonramsay.product.messaging;

public interface Publisher<T> {
    void publish(String topic, T message);
}
