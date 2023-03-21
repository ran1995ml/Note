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
//        props.put("bootstrap.servers", "rccp202-11f.iad5.prod.conviva.com:32511,rccp202-11g.iad5.prod.conviva.com:32511,rccp203-11e.iad5.prod.conviva.com:32511,rccp203-11f.iad5.prod.conviva.com:32511,rccp203-11g.iad5.prod.conviva.com:32511,rccp204-11a.iad5.prod.conviva.com:32511,rccp204-11b.iad5.prod.conviva.com:32511,rccp204-11c.iad5.prod.conviva.com:32511");
        props.put("group.id", "test");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Collections.singleton("tlb-rt-ad-sess-summary"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.of(2, ChronoUnit.SECONDS));
            for(ConsumerRecord<String, String> record: records) {
                System.out.println(record.value());
            }
        }

    }
}
