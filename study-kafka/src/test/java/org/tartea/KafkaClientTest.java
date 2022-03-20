package org.tartea;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Set;


@SpringBootTest
public class KafkaClientTest {

    @Autowired
    private AdminClient adminClient;

    /**
     * 创建topic
     */
    @Test
    public void testCreateTopic() {
        String topicName = "first_topic";
        Integer numPartitions = 1;
        short replicationFactor = 1;

        NewTopic newTopic = new NewTopic(topicName, numPartitions, replicationFactor);
        adminClient.createTopics(Collections.singletonList(newTopic));
    }


    @Test
    public void testQueryTopic() {
        ListTopicsResult listTopicsResult = adminClient.listTopics();
        try {
            Set<String> names = listTopicsResult.names().get();
            names.forEach((name) -> System.out.print(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteTopic() {
        String topicName = "first_topic";
        adminClient.deleteTopics(Collections.singletonList(topicName));
    }

}
