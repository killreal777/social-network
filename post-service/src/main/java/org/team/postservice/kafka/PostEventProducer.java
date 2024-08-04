package org.team.postservice.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostEventProducer {
    @Value("${application.kafka.topics.delete-post}")
    private String deletePostTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void createDeletePostEvent(int postId) {
        kafkaTemplate.send(deletePostTopic, Integer.toString(postId));
    }
}
