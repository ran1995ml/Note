package com.ran.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Collections;
import java.util.Properties;

/**
 * KafkaConsumerClient
 *
 * @author rwei
 * @since 2023/2/27 14:12
 */
public class KafkaConsumerClient {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers",  "rccp109-5d.iad4.prod.conviva.com:30201,rccp110-5c.iad4.prod.conviva.com:30202,rccp111-5b.iad4.prod.conviva.com:30203,rccp111-5d.iad4.prod.conviva.com:30204");
        props.put("group.id", "test");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Collections.singleton("tlb-rt-sess-summary-hulu"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.of(2, ChronoUnit.SECONDS));
            for(ConsumerRecord<String, String> record: records) {
                System.out.println(record.value());
            }
        }

    }
}
