package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {

    private final String TOPIC = "students_topic";
    private Properties setting = new Properties();
    private String location = "http://localhost:9092";

    public Producer() {

        System.out.println("starting Producer.");

        setting.put("client.id", "basic-producer");
        setting.put("bootstrap.servers", location);
        setting.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        setting.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    }
    public void produce(String key, String value) {
        try(KafkaProducer<String, String> producer = new KafkaProducer<>(setting)) {

            producer.send(new ProducerRecord<>(TOPIC, key, value));
            System.out.println("record sent.");
        } catch (Exception e) {
            throw e;
        }
    }
}
