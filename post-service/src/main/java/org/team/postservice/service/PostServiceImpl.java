package org.team.postservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team.postservice.model.PostEntity;
import org.team.postservice.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    @Transactional
    public PostEntity createPost(PostEntity postEntity) {
        return postRepository.save(postEntity);
    }

    @Override
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<PostEntity> getPostsByOwnerId(int ownerId) {
        return postRepository.findByOwnerId(ownerId);
    }

    @Override
    public PostEntity getPostById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deletePostById(int id) {
        postRepository.deleteById(id);
    }
}
