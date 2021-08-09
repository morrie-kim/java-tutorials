package com.morrie.tutorials.jsdrs.user.service;

import com.morrie.tutorials.jsdrs.user.domain.UserPoint;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by morrie kim on 2020/03/12.
 */
public interface UserPointService {
    Optional<UserPoint> findById(String id);

    List<UserPoint> findAll();

    UserPoint save(UserPoint userPoint);

}
