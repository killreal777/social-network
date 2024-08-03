package org.team.postservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.team.postservice.dto.CreatePostRequest;
import org.team.postservice.dto.PostDto;
import org.team.postservice.service.PostService;
import org.team.postservice.validator.ValidImage;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostServiceRestController {
    private final PostService postService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<PostDto> createPost(
            @Valid @RequestPart CreatePostRequest post,
            @ValidImage @RequestPart MultipartFile image) {
        System.out.println(post);
        System.out.println(image.isEmpty());
        return ResponseEntity.ok(postService.createPost(post, image));
    }

    @GetMapping("/users/{ownerId}")
    public ResponseEntity<List<PostDto>> getPostsByOwnerId(@PathVariable int ownerId) {
        return ResponseEntity.ok(postService.getPostsByOwnerId(ownerId));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable int postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @GetMapping("/images/{postId}")
    public ResponseEntity<ByteArrayResource> getImageByPostId(@PathVariable int postId) {
        ByteArrayResource file = postService.getPostImageByPostId(postId);
        HttpHeaders headers = createHttpHeadersForImageResponse(file);
        return ResponseEntity.ok()
                .headers(headers)
                .body(file);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePostById(@PathVariable int postId) {
        postService.deletePostById(postId);
        return ResponseEntity.ok().build();
    }

    private HttpHeaders createHttpHeadersForImageResponse(ByteArrayResource file) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(file.contentLength());
        return headers;
    }
}
