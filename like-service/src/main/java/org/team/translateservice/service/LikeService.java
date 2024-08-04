package org.team.translateservice.service;

import org.team.translateservice.model.Like;

import java.util.List;

public interface LikeService {
    Like setLikeToPost(int postId, int userId);

    void removeLikeFromPost(int postId, int userId);

    List<Like> getLikesByPostId(int postId);

    List<Like> getLikesByUserId(int userId);
}
