package org.team.likeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team.likeservice.model.Like;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {
    List<Like> findAllByPostId(int postId);

    List<Like> findAllByUserId(int postId);
}
