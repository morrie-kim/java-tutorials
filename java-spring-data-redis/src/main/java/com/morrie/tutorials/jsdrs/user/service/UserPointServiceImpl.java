package com.morrie.tutorials.jsdrs.user.service;

import com.morrie.tutorials.jsdrs.user.domain.UserPoint;
import com.morrie.tutorials.jsdrs.user.repository.UserPointRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by morrie kim on 2020/03/12.
 */
@Service
@RequiredArgsConstructor
public class UserPointServiceImpl implements UserPointService{

    private final UserPointRedisRepository userPointRedisRepository;

    @Override
    public Optional<UserPoint> findById(String id) {
        return userPointRedisRepository.findById(id);
    }

    @Override
    public List<UserPoint> findAll() {
        return (List<UserPoint>) userPointRedisRepository.findAll();
    }

    public UserPoint save(UserPoint userPoint) {
        return userPointRedisRepository.save(userPoint);
    }
}
