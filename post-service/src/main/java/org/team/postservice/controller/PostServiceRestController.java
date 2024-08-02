package org.team.postservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.team.postservice.dto.PostDto;
import org.team.postservice.model.PostEntity;
import org.team.postservice.service.FileStorageService;
import org.team.postservice.service.PostService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostServiceRestController {
    private final PostService postService;
    private final FileStorageService fileStorageService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @RequestParam int ownerId,
            @RequestParam String textContent,
            @RequestParam MultipartFile file
    ) {
        PostEntity postEntity = PostEntity.builder()
                .ownerId(ownerId)
                .textContent(textContent)
                .build();

        postEntity = postService.createPost(postEntity);

        int postId = postEntity.getId();
        String postFileName = Integer.toString(postId);

        fileStorageService.upload(postFileName, file);

        return ResponseEntity.ok(PostMapper.toDto(postEntity));
    }

    @GetMapping("/echoFile")
    // Debug
    public ResponseEntity<Resource> echoFile(@RequestParam MultipartFile file) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(file.getResource().contentLength());

        return ResponseEntity.ok()
                .headers(headers)
                .body(file.getResource());
    }

    @GetMapping
    // Debug
    public ResponseEntity<List<PostEntity>> getAllPost() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/users/{ownerId}")
    public ResponseEntity<List<PostDto>> getPostsByOwnerId(@PathVariable int ownerId) {
        List<PostDto> responseList = postService.getPostsByOwnerId(ownerId).stream()
                .map(PostMapper::toDto).toList();

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable int id) {
        return ResponseEntity.ok(PostMapper.toDto(postService.getPostById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Integer id) {
        postService.deletePostById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/files/{postId}")
    public ResponseEntity<ByteArrayResource> getFileByPostId(@PathVariable int postId) {
        return ResponseEntity.ok(fileStorageService.download(Integer.toString(postId)));
    }

    private static class PostMapper {
        public static PostEntity toEntity(PostDto postDto) {
            return PostEntity.builder()
                    .id(postDto.getId())
                    .ownerId(postDto.getOwnerId())
                    .textContent(postDto.getTextContent())
                    .build();
        }

        public static PostDto toDto(PostEntity postEntity) {
            return PostDto.builder()
                    .id(postEntity.getId())
                    .ownerId(postEntity.getOwnerId())
                    .textContent(postEntity.getTextContent())
                    .build();
        }
    }
}
