package org.team.likeservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "post-service", path = "/api/posts")
public interface PostServiceClient {
    @GetMapping("/exists/{postId}")
    boolean isPostExists(@PathVariable int postId);
}
