package org.team.postservice.service;

import org.team.postservice.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);

    List<Post> getAllPosts();

    Post getPost(int id);

    void deletePost(int id);
}
