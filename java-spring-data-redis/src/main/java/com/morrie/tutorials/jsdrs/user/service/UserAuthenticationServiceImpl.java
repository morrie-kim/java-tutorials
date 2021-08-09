package com.morrie.tutorials.jsdrs.user.service;

import com.morrie.tutorials.jsdrs.user.domain.UserAuthentication;
import com.morrie.tutorials.jsdrs.user.repository.UserAuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by morrie kim on 2021/07/09.
 */
@Service
@RequiredArgsConstructor
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    private final UserAuthenticationRepository userAuthenticationRepository;

    @Override
    public Optional<UserAuthentication> findById(String id) {
        return userAuthenticationRepository.findById(id);
    }

    @Override
    public List<UserAuthentication> findAll() {
        return (List<UserAuthentication>) userAuthenticationRepository.findAll();
    }

    @Override
    public UserAuthentication save(UserAuthentication userAuthentication) {
        return userAuthenticationRepository.save(userAuthentication);
    }
}
