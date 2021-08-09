package com.morrie.tutorials.jsdms.user.service;

import com.morrie.tutorials.jsdms.user.domain.UserPoint;
import com.morrie.tutorials.jsdms.user.repository.UserPointMongoRepository;
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

    private final UserPointMongoRepository userPointMongoRepository;

    @Override
    public Optional<UserPoint> findById(String id) {
        return userPointMongoRepository.findById(id);
    }

    @Override
    public List<UserPoint> findAll() {
        return (List<UserPoint>) userPointMongoRepository.findAll();
    }

    public UserPoint save(UserPoint userPoint) {
        return userPointMongoRepository.save(userPoint);
    }
}
