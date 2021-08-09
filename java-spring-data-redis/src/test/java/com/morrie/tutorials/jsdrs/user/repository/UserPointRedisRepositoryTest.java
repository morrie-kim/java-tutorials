package com.morrie.tutorials.jsdrs.user.repository;

import com.morrie.tutorials.jsdrs.user.domain.UserPoint;
import com.morrie.tutorials.jsdrs.user.repository.UserPointRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by morrie kim on 2020/03/09.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPointRedisRepositoryTest {
    @Autowired
    private UserPointRedisRepository userPointRedisRepository;

    @After
    public void tearDown() throws Exception {
        userPointRedisRepository.deleteAll();
    }

    @Test
    public void test_save_and_find_userPoint() {
        //given
        String id = "testUser1";
        LocalDateTime refreshTime = LocalDateTime.of(2020, 3, 9, 0, 0);
        UserPoint point = UserPoint.builder()
                .id(id)
                .amount(1000L)
                .refreshTime(refreshTime)
                .build();

        //when
        userPointRedisRepository.save(point);

        //then
        UserPoint savedUserPoint = userPointRedisRepository.findById(id).get();
        log.debug("[register_and_search_userPoint] savedUserPoint id : {}, amount : {}, refreshTime : {}", savedUserPoint.getId(), savedUserPoint.getAmount(), savedUserPoint.getRefreshTime());

        assertThat(savedUserPoint.getAmount()).isEqualTo(1000L);
        assertThat(savedUserPoint.getRefreshTime()).isEqualTo(refreshTime);
    }

    @Test
    public void test_update_userPoint() {
        //given
        String id = "testUser2";
        LocalDateTime refreshTime = LocalDateTime.of(2020, 3, 9, 0, 0);
        userPointRedisRepository.save(UserPoint.builder()
                .id(id)
                .amount(1000L)
                .refreshTime(refreshTime)
                .build());

        //when
        UserPoint savedUserPoint = userPointRedisRepository.findById(id).get();
        log.debug("[modify_userPoint] savedUserPoint id : {}, amount : {}, refreshTime : {}", savedUserPoint.getId(), savedUserPoint.getAmount(), savedUserPoint.getRefreshTime());

        savedUserPoint.refresh(2000L, LocalDateTime.of(2020, 9, 1, 0, 0));
        userPointRedisRepository.save(savedUserPoint);

        //then
        UserPoint refreshPoint = userPointRedisRepository.findById(id).get();
        log.debug("[modify_userPoint] refreshPoint id : {}, amount : {}, refreshTime : {}", refreshPoint.getId(), refreshPoint.getAmount(), refreshPoint.getRefreshTime());

        assertThat(refreshPoint.getAmount()).isEqualTo(2000L);
    }

    @Test
    public void test_delete_userPoint() {
        //given
        String id = "testUser3";
        LocalDateTime refreshTime = LocalDateTime.of(2020, 3, 9, 0, 0);
        UserPoint savedUserPoint = userPointRedisRepository.save(UserPoint.builder()
                .id(id)
                .amount(1000L)
                .refreshTime(refreshTime)
                .build());

        log.debug("[delete_userPoint] savedUserPoint id : {}, amount : {}, refreshTime : {}", savedUserPoint.getId(), savedUserPoint.getAmount(), savedUserPoint.getRefreshTime());

        //when
        userPointRedisRepository.deleteById(id);

        //then
        boolean isValue = userPointRedisRepository.findById(id).isPresent();
        log.debug("[delete_userPoint] isValue : {}", isValue);

        assertThat(isValue).isEqualTo(false);
    }
}
