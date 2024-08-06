package org.team.likeservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team.likeservice.client.PostServiceClient;
import org.team.likeservice.exception.NoSuchPostException;
import org.team.likeservice.model.Like;
import org.team.likeservice.repository.LikeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private final PostServiceClient postServiceClient;

    @Override
    @Transactional
    public Like setLikeToPost(int postId, int userId) {
        checkPostExistence(postId);
        return likeRepository.save(new Like(postId, userId));
    }

    @Override
    @Transactional
    public void removeLikeFromPost(int postId, int userId) {
        likeRepository.delete(new Like(postId, userId));
    }

    @Override
    @Transactional
    public void removeAllLikesFromPost(int postId) {
        likeRepository.deleteAllByPostId(postId);
    }

    @Override
    public List<Like> getLikesByPostId(int postId) {
        return likeRepository.findAllByPostId(postId);
    }

    @Override
    public List<Like> getLikesByUserId(int userId) {
        return likeRepository.findAllByUserId(userId);
    }

    private void checkPostExistence(int postId) {
        if (!postServiceClient.isPostExists(postId))
            throw new NoSuchPostException();
    }
}
