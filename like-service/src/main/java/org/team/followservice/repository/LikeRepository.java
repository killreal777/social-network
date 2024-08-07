package org.team.followservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team.followservice.model.Like;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {
    void deleteAllByPostId(int postId);

    List<Like> findAllByPostId(int postId);

    List<Like> findAllByUserId(int postId);
}
