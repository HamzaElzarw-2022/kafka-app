package org.example;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Consumer {

    private final String TOPIC = "students_topic";
    private Properties setting = new Properties();
    private String location = "localhost:9092";

    public Consumer() {
        setting.put(ConsumerConfig.GROUP_ID_CONFIG, "basic-consumer");
        setting.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, location);
        setting.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        setting.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        setting.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        setting.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        setting.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    }

    public void consume() {

        try(KafkaConsumer<String, String> consumer = new KafkaConsumer<>(setting)) {

            consumer.subscribe(Collections.singletonList(TOPIC));

            while(true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d, key=%s, value = %s%n", record.offset(), record.key(), record.value());
                }
            }

        }

    }
}
