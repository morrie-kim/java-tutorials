package com.morrie.tutorials.jsdrs.user.controller;

import com.morrie.tutorials.jsdrs.user.domain.UserAuthentication;
import com.morrie.tutorials.jsdrs.user.dto.UserAuthenticationDto;
import com.morrie.tutorials.jsdrs.user.service.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by morrie kim on 2021/07/26.
 * Redis API
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/${application.api-info.version.major:v1}/users")
public class UserAuthenticationController {

    private final UserAuthenticationService userAuthenticationService;

    @GetMapping("/authentication")
    public ResponseEntity<List<UserAuthentication>> findUserAuthenticationList() {
        List<UserAuthentication> response = userAuthenticationService.findAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/authentication/{id}")
    public ResponseEntity<Optional<UserAuthentication>> findUserAuthentication(@PathVariable("id") String userId) {
        Optional<UserAuthentication> response = userAuthenticationService.findById(userId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/authentication")
    public ResponseEntity<UserAuthentication> saveUserAuthentication(@RequestBody UserAuthenticationDto request) {
        UserAuthentication userAuthentication = UserAuthentication.builder()
                .id(request.getUserId())
                .status(request.getStatus())
                .build();

        UserAuthentication response = userAuthenticationService.save(userAuthentication);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}