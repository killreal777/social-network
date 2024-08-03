package org.team.postservice.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;
import org.team.postservice.dto.CreatePostRequest;
import org.team.postservice.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(CreatePostRequest createPostRequest, MultipartFile image);

    List<PostDto> getPostsByOwnerId(int id);

    PostDto getPostById(int id);

    Boolean isPostExists(int id);

    ByteArrayResource getPostImageByPostId(int id);

    void deletePostById(int id);
}
