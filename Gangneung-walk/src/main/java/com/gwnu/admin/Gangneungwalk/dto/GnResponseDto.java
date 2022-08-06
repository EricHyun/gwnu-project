package com.gwnu.admin.Gangneungwalk.dto;
// DTO(Data Transfer Object)


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드를 생성
@RequiredArgsConstructor //선언된 모든 final 필드가 포함된 생성자를 생성해준다.
//final 이 없는 필드는 생성자에 포함되지 않음
/**
 * Controller는 View와 도메인 Model의 데이터를 주고 받을 때 별도의 DTO를 주로 사용한다.
 * 도메인 객체를 View에 직접 전달할 수 있지만,
 * 도메인의 비즈니스 기능이 노출될 수 있으며 Model과 View 사이에 의존성이 생기기 때문이다.
 */
public class GnResponseDto {

    private final String userName;
    private final String userEmail;
    private final int amount;

}
