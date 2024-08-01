package org.team.postservice.service;

import org.team.postservice.model.PostEntity;

import java.util.List;

public interface PostService {
    PostEntity createPost(PostEntity postEntity);

    List<PostEntity> getAllPosts();

    List<PostEntity> getPostsByOwnerId(int ownerId);

    PostEntity getPostById(int id);

    void deletePostById(int id);
}
