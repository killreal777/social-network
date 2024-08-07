package org.team.followservice.service;

import org.team.followservice.model.Like;

import java.util.List;

public interface LikeService {
    Like setLikeToPost(int postId, int userId);

    void removeLikeFromPost(int postId, int userId);

    void removeAllLikesFromPost(int postId);

    List<Like> getLikesByPostId(int postId);

    List<Like> getLikesByUserId(int userId);
}
