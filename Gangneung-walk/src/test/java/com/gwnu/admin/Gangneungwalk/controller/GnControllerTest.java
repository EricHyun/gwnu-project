package com.gwnu.admin.Gangneungwalk.controller;


import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = GnController.class)
@RunWith(SpringRunner.class)
/**
 * @ExtendWith(MyExtension.class) 라는 대체옵션도 있지만 @SpringBootTest가
 * 이미 @ExtendWith(MyExtension.class) 를 가지고 있기 때문에 생략하기로 결정.
 * @RunWith//생략 해도됨 Junit5부터는 대신 >> 테스트 진행할 때 JUnit에 내장된 실행자 외 다른 실행자를 실행
 *
 */
public class GnControllerTest {

    @Autowired // Bean 주입
    private MockMvc mvc;

    /**
     * 웹 API 테스트 할 때 사용 spring MVC 테스트의 시작점
     * 이 class를 통해서 HTTP GET,POST 등의 대한 API 테스트 할 수 있다.
     */

    @Test
    public void joinTest() throws Exception {
        String join = "join";

        mvc.perform(get("/user/join")) //MockMVC를 통해 /user/join주소로 GET요청
                .andExpect(status().isOk()) //mvc.perform의 결과 status()검증 몇번대 오류인지여기 ok는 200번대인지 확인
                .andExpect(content().string(join)); //MVC.perform결과를 검증하고 응답 본문의 내용을 검증 , controller return 값이 join 이 맞는지 검증
    }

    @Test
    public void loginTest() throws Exception {
        String login = "login";

        mvc.perform(get("/user/login"))
                .andExpect(status().isOk())
                .andExpect(content().string(login));
    }

    @Test
    public void gnResponseDtd() throws Exception {
        String userName = "spring";
        String userEmail = "admin.test.com";
        int amount = 1000;

        mvc.perform(
                get("/user/dto")
                        .param("userName", userName)//param값은 String만 허용된다.
                        .param("userEmail", userEmail)//숫자 날짜등 데이터터도 등록은 String만
                        .param("amount", String.valueOf(amount))) //string > value로
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName", is(userName)))
              //  Matchers.is(userName) >> import static org.hamcrest.Matchers.is;

                .andExpect(jsonPath("$.userEmail", is(userEmail)))
                .andExpect(jsonPath("$.amount", is(amount)));
        /**
         * JSON 응답값을 필드별로 검증할 수 있는 메소드
         * $를 기준으로 필드명을 명시한다.
         * jsonPath("$.userEmail" << 이런식
         */

    }
}
