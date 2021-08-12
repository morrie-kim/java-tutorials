package com.morrie.tutorials.jsds.user.service;

import com.morrie.tutorials.jsds.user.domain.UserPoint;
import com.morrie.tutorials.jsds.user.repository.UserPointRepository;
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

    private final UserPointRepository userPointRepository;

    @Override
    public Optional<UserPoint> findById(String id) {
        return userPointRepository.findById(id);
    }

    @Override
    public List<UserPoint> findAll() {
        return (List<UserPoint>) userPointRepository.findAll();
    }

    public UserPoint save(UserPoint userPoint) {
        return userPointRepository.save(userPoint);
    }
}
