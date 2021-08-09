package com.morrie.tutorials.jsdrs.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrie.tutorials.jsdrs.user.controller.UserPointController;
import com.morrie.tutorials.jsdrs.user.domain.UserPoint;
import com.morrie.tutorials.jsdrs.user.service.UserPointService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by morrie kim on 2020/03/25.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserPointController.class)
public class UserPointControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private UserPointService userPointService;

    @Test
    public void test_find_all_userPoint() throws Exception {
        // given
        List<UserPoint> userPointList = new ArrayList<>();

        for(int i = 0;i < 9;i++) {
            UserPoint userPoint = UserPoint.builder()
                    .id("testController" + String.valueOf(i + 1))
                    .amount((long) (i + 1))
                    .refreshTime(LocalDateTime.now())
                    .build();

            userPointList.add(userPoint);
        }

        given(this.userPointService.findAll())
                .willReturn(userPointList);

        // when
        ObjectMapper mapper = new ObjectMapper();

        ResultActions result = this.mvc.perform(get("/api/users/v1/point")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                //.content(mapper.writeValueAsString(userPointList))
                .accept(MediaType.APPLICATION_JSON_VALUE)
        );


        // then
        String responseContent = result.andExpect(status().is2xxSuccessful())
              .andDo(print())
              .andReturn().getResponse().getContentAsString()
        ;

        assertThat(mapper.writeValueAsString(userPointList)).isEqualTo(responseContent);

    }


}
