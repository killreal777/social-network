package org.team.followservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.team.followservice.model.Like;
import org.team.followservice.service.LikeService;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeServiceRestController {
    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<Like> setLikeToPost(@RequestParam int postId, @RequestParam int userId) {
        return ResponseEntity.ok(likeService.setLikeToPost(postId, userId));
    }

    @DeleteMapping
    public ResponseEntity<Void> removeLikeFromPost(@RequestParam int postId, @RequestParam int userId) {
        likeService.removeLikeFromPost(postId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Like>> getLikesByPostId(@PathVariable int postId) {
        return ResponseEntity.ok(likeService.getLikesByPostId(postId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Like>> getLikesByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(likeService.getLikesByUserId(userId));
    }
}
