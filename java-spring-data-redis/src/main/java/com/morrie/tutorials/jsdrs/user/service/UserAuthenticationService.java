package com.morrie.tutorials.jsdrs.user.service;

import com.morrie.tutorials.jsdrs.user.domain.UserAuthentication;

import java.util.List;
import java.util.Optional;

/**
 * Created by morrie kim on 2021/07/26.
 */
public interface UserAuthenticationService {
    Optional<UserAuthentication> findById(String id);

    List<UserAuthentication> findAll();

    UserAuthentication save(UserAuthentication userPoint);
}
