package com.jhonatapers.balance.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.jhonatapers.balance.event.AccountBalanceUpdatedEvent;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    // @Bean
    // public Map<String, Object> consumerConfigs() {
    // Map<String, Object> props = new HashMap<>();
    // props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    // props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    // props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
    // StringDeserializer.class);
    // props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
    // JsonDeserializer.class);
    // props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_DOC,
    // AccountBalanceUpdatedEvent.class);
    // return props;
    // }

    // @Bean
    // public ConsumerFactory<String, AccountBalanceUpdatedEvent> consumerFactory()
    // {

    // Map<String, Object> props = new HashMap<>();
    // props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    // props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    // props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
    // StringDeserializer.class);
    // props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
    // JsonDeserializer.class);
    // props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_DOC,
    // AccountBalanceUpdatedEvent.class);

    // return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    // }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, AccountBalanceUpdatedEvent> kafkaListenerContainerFactory() {

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

        var consumerFactory = new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(AccountBalanceUpdatedEvent.class, false));

        ConcurrentKafkaListenerContainerFactory<String, AccountBalanceUpdatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    // @Bean
    // public
    // KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,
    // AccountBalanceUpdatedEvent>>
    // accountBalanceUpdatedEventKafkaListenerContainerFactory() {

    // Map<String, Object> props = new HashMap<>();
    // props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    // props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    // props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
    // StringDeserializer.class);
    // props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
    // JsonDeserializer.class);
    // props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_DOC,
    // AccountBalanceUpdatedEvent.class);

    // var consumerFactory = new DefaultKafkaConsumerFactory<>(props);

    // ConcurrentKafkaListenerContainerFactory<String, AccountBalanceUpdatedEvent>
    // factory = new ConcurrentKafkaListenerContainerFactory<>();
    // factory.setConsumerFactory(consumerFactory);
    // return factory;
    // }

}
