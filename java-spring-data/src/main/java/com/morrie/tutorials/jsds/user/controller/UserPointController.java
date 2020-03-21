package com.morrie.tutorials.jsds.user.controller;

import com.morrie.tutorials.jsds.user.domain.UserPoint;
import com.morrie.tutorials.jsds.user.service.UserPointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by morrie kim on 2020/03/11.
 */
@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserPointController {
    @Autowired
    private UserPointService userPointService;

    @GetMapping("/v1.0/points")
    public ResponseEntity<List<UserPoint>> findUserListPoints() {
        List<UserPoint> response = userPointService.findAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/v1.0/points")
    public ResponseEntity<Optional<UserPoint>> findUserPoints(@Valid @RequestParam("user_id") String userId) {
        Optional<UserPoint> response = userPointService.findById(userId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/v1.0/points")
    public ResponseEntity<UserPoint> saveUserPoints(UserPoint request) {
        UserPoint response = userPointService.save(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
