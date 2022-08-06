package com.gwnu.admin.Gangneungwalk.dto;

import org.junit.Test;


import static org.assertj.core.api.Assertions.*;

public class GnResponseDtoTest {

    @Test
    public void lombokTest(){
        //given
        String userName = "Spring";
        String userEmail = "admin.test.com";
        int amount = 1000;

        //when
        GnResponseDto dto = new GnResponseDto(userName,userEmail,amount);

        //then
        assertThat(dto.getUserName()).isEqualTo(userName);
        assertThat(dto.getUserEmail()).isEqualTo(userEmail);
        assertThat(dto.getAmount()).isEqualTo(amount);
        /** assertThat 은 assertj 라는 테스트 검증 라이브러리의 검증 메소드
         * 검증하고 싶은 대상을 메소드 인자로 받고
         * 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드 이용해서 assertThat에 있는 값과 같은 값이면 성공
         * 여기서 junit의 assertThat이 아니라 assertj의 assert That을 사용했다.
         * assertj 역시 Junit에서 자동으로 라이브러리를 등록해준다.
         */
    }
}
