package org.team.likeservice.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.team.likeservice.service.LikeService;

@Service
@RequiredArgsConstructor
public class Consumer {
    private final LikeService likeService;

    @KafkaListener(topics = "${application.kafka.topics.delete-post}")
    public void listenDeletePostEvent(String postId) {
        int id = Integer.parseInt(postId);
        likeService.removeAllLikesFromPost(id);
    }
}
