package org.team.likeservice.service;

import org.team.likeservice.model.Like;

import java.util.List;

public interface LikeService {
    Like setLikeToPost(int postId, int userId);

    void removeLikeFromPost(int postId, int userId);

    List<Like> getLikesByPostId(int postId);

    List<Like> getLikesByUserId(int userId);
}
