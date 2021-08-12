package com.morrie.tutorials.jsds.user.repository;

import com.morrie.tutorials.jsds.user.domain.UserPoint;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by morrie kim on 2020/03/09.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPointRepositoryTest {
    @Autowired
    private UserPointRepository userPointRepository;

    @After
    public void tearDown() throws Exception {
        userPointRepository.deleteAll();
    }

    @Test
    public void test_save_and_find_userPoint() {
        //given
        String id = "testUser1";
        UserPoint point = UserPoint.builder()
                .id(id)
                .amount(1000L)
                .build();

        //when
        userPointRepository.save(point);

        //then
        UserPoint savedUserPoint = userPointRepository.findById(id).get();
        log.debug("[register_and_search_userPoint] savedUserPoint id : {}, amount : {}", savedUserPoint.getId(), savedUserPoint.getAmount());

        assertThat(savedUserPoint.getAmount()).isEqualTo(1000L);
    }

    @Test
    public void test_update_userPoint() {
        //given
        String id = "testUser2";
        userPointRepository.save(UserPoint.builder()
                .id(id)
                .amount(1000L)
                .build());

        //when
        UserPoint savedUserPoint = userPointRepository.findById(id).get();
        log.debug("[modify_userPoint] savedUserPoint id : {}, amount : {}", savedUserPoint.getId(), savedUserPoint.getAmount());

        userPointRepository.save(savedUserPoint);

        //then
        UserPoint refreshPoint = userPointRepository.findById(id).get();
        log.debug("[modify_userPoint] refreshPoint id : {}, amount : {}", refreshPoint.getId(), refreshPoint.getAmount());

        assertThat(refreshPoint.getAmount()).isEqualTo(1000L);
    }

    @Test
    public void test_delete_userPoint() {
        //given
        String id = "testUser3";
        UserPoint savedUserPoint = userPointRepository.save(UserPoint.builder()
                .id(id)
                .amount(1000L)
                .build());

        log.debug("[delete_userPoint] savedUserPoint id : {}, amount : {}", savedUserPoint.getId(), savedUserPoint.getAmount());

        //when
        userPointRepository.deleteById(id);

        //then
        boolean isValue = userPointRepository.findById(id).isPresent();
        log.debug("[delete_userPoint] isValue : {}", isValue);

        assertThat(isValue).isEqualTo(false);
    }
}
