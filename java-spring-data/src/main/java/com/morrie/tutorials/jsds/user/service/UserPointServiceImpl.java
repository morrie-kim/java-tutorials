package com.morrie.tutorials.jsds.user.service;

import com.morrie.tutorials.jsds.user.domain.UserPoint;
import com.morrie.tutorials.jsds.user.repository.UserPointRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by morrie kim on 2020/03/12.
 */
@Service
public class UserPointServiceImpl implements UserPointService{
    @Autowired
    UserPointRedisRepository userPointRedisRepository;

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
