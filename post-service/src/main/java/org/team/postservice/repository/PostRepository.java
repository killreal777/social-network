package org.team.postservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.team.postservice.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
