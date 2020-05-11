package com.morrie.tutorials.jsds.user.controller;

import com.morrie.tutorials.jsds.user.domain.UserPoint;
import com.morrie.tutorials.jsds.user.dto.UserPointDto;
import com.morrie.tutorials.jsds.user.service.UserPointService;
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
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserPointController {

    private final UserPointService userPointService;

    @GetMapping("/v1/point")
    public ResponseEntity<List<UserPoint>> findUserListPoint() {
        List<UserPoint> response = userPointService.findAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/v1/point/{id}")
    public ResponseEntity<Optional<UserPoint>> findUserPoint(@PathVariable("id") String userId) {
        Optional<UserPoint> response = userPointService.findById(userId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/v1/point")
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
