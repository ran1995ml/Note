package com.ran.kafka.admin;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * KafkaAdmin
 *
 * @author rwei
 * @since 2023/6/5 22:22
 */
public class KafkaAdmin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
                "rccp109-5d.iad4.prod.conviva.com:30201,rccp110-5c.iad4.prod.conviva.com:30202,rccp111-5b.iad4.prod.conviva.com:30203,rccp111-5d.iad4.prod.conviva.com:30204");
        AdminClient adminClient = AdminClient.create(properties);
        ListTopicsResult listTopicsResult = adminClient.listTopics();
        Set<String> topics = listTopicsResult.names().get();
        System.out.println(topics);
    }
}
