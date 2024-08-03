package org.team.postservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.team.postservice.dto.CreatePostRequest;
import org.team.postservice.dto.PostDto;
import org.team.postservice.model.PostEntity;
import org.team.postservice.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final FileService fileService;

    @Override
    @Transactional
    public PostDto createPost(CreatePostRequest createPostRequest, MultipartFile image) {
        boolean hasImage = !image.isEmpty();
        PostEntity postEntity = PostMapper.toEntity(createPostRequest, hasImage);
        postEntity = postRepository.save(postEntity);
        if (hasImage) fileService.save(filenameByPostId(postEntity.getId()), image);
        return PostMapper.toDto(postEntity);
    }

    @Override
    public List<PostDto> getPostsByOwnerId(int id) {
        return postRepository.findByOwnerId(id).stream().map(PostMapper::toDto).toList();
    }

    @Override
    public PostDto getPostById(int id) {
        return PostMapper.toDto(postRepository.findById(id).orElseThrow());
    }

    @Override
    public ByteArrayResource getPostImageByPostId(int id) {
        if (!doesPostHaveImage(id)) throw new RuntimeException();
        return fileService.get(filenameByPostId(id));
    }

    @Override
    @Transactional
    public void deletePostById(int id) {
        postRepository.deleteById(id);
        if (doesPostHaveImage(id)) fileService.delete(filenameByPostId(id));
    }

    private boolean doesPostHaveImage(int postId) {
        return getPostById(postId).hasImage();
    }

    private String filenameByPostId(int postId) {
        return Integer.toString(postId);
    }

    private static class PostMapper {
        public static PostEntity toEntity(CreatePostRequest createPostRequest, boolean hasImage) {
            return PostEntity.builder()
                    .ownerId(createPostRequest.getOwnerId())
                    .textContent(createPostRequest.getTextContent())
                    .hasImage(hasImage)
                    .build();
        }

        public static PostDto toDto(PostEntity postEntity) {
            return PostDto.builder()
                    .id(postEntity.getId())
                    .ownerId(postEntity.getOwnerId())
                    .textContent(postEntity.getTextContent())
                    .hasImage(postEntity.hasImage())
                    .build();
        }
    }
}
