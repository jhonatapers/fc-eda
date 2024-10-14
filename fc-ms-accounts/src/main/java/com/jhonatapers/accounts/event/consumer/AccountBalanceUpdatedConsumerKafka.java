package com.jhonatapers.accounts.event.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.jhonatapers.accounts.event.AccountBalanceUpdatedEvent;
import com.jhonatapers.accounts.event.handler.AccountBalanceUpdatedEventHandlerKafka;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AccountBalanceUpdatedConsumerKafka {

    private final AccountBalanceUpdatedEventHandlerKafka accountBalanceUpdatedEventHandlerKafka;

    @KafkaListener(topics = "balances", containerFactory = "kafkaListenerContainerFactory")
    public void consumirMensagem(ConsumerRecord<Integer, AccountBalanceUpdatedEvent> record) {
        accountBalanceUpdatedEventHandlerKafka.handle(record.value());
    }

}
