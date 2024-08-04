package org.team.translateservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team.translateservice.model.Like;
import org.team.translateservice.repository.LikeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;

    @Override
    public Like setLikeToPost(int postId, int userId) {
        return likeRepository.save(new Like(postId, userId));
    }

    @Override
    public void removeLikeFromPost(int postId, int userId) {
        likeRepository.delete(new Like(postId, userId));
    }

    @Override
    public List<Like> getLikesByPostId(int postId) {
        return likeRepository.findAllByPostId(postId);
    }

    @Override
    public List<Like> getLikesByUserId(int userId) {
        return likeRepository.findAllByUserId(userId);
    }
}
