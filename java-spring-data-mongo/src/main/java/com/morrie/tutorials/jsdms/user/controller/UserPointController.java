package com.morrie.tutorials.jsdms.user.controller;

import com.morrie.tutorials.jsdms.user.domain.UserPoint;
import com.morrie.tutorials.jsdms.user.dto.UserPointDto;
import com.morrie.tutorials.jsdms.user.service.UserPointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by morrie kim on 2020/03/11.
 * Redis API
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/${application.api-info.version.major:v1}/users")
public class UserPointController {

    private final UserPointService userPointService;

    @GetMapping("/point")
    public ResponseEntity<List<UserPoint>> findUserListPoint() {
        List<UserPoint> response = userPointService.findAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/point/{id}")
    public ResponseEntity<Optional<UserPoint>> findUserPoint(@PathVariable("id") String userId) {
        Optional<UserPoint> response = userPointService.findById(userId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/point")
    public ResponseEntity<UserPoint> saveUserPoint(@RequestBody UserPointDto request) {
        UserPoint userPoint = UserPoint.builder()
                .id(request.getUserId())
                .amount(request.getAmount())
                .refreshTime(LocalDateTime.now())
                .build();

        UserPoint response = userPointService.save(userPoint);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
