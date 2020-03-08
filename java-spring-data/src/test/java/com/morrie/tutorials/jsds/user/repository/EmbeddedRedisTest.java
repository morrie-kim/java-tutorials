package com.morrie.tutorials.jsds.user.repository;

import com.morrie.tutorials.jsds.user.domain.UserPoint;
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
public class EmbeddedRedisTest {
    @Autowired
    private UserPointRedisRepository userPointRedisRepository;

    @After
    public void tearDown() throws Exception {
        userPointRedisRepository.deleteAll();
    }

    @Test
    public void 기본_등록_조회기능() {
        //given
        String id = "testUser";
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
        log.debug(savedUserPoint.getId());
        assertThat(savedUserPoint.getAmount()).isEqualTo(1000L);
        assertThat(savedUserPoint.getRefreshTime()).isEqualTo(refreshTime);
    }
}
