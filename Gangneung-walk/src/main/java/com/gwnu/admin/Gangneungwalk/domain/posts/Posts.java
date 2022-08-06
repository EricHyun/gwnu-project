package com.gwnu.admin.Gangneungwalk.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * posts 클래스는 실제 DB의 테이블과 매칭될 클래스이다. 보통 Entity class 라고도 한다.
 * JPA를 사용하면 DB데이터에 작업할 경우 실제 쿼리를 널리기 보다는, 이 Entity 클래스를 수정한다.(Setter사용 금지 Entity class)
 * 여기서 Setter가 없는 이유는 인스턴스 값들이 언제 어디서 변해야 하는지 명활하게 구분할 수 없어 차후에 복잡해짐
 */
@Getter //@Getter 클래스 내 모든 필드의 Getter메소드 자동 생성
@NoArgsConstructor//기본 생성자 자동추가 public Posts(){}와 같은 효과
/**
 * loombok 어노테이션(필수는 아니다.)  + Getter, Builder 등  >> 코틀린등의 새 언어로 전환할 경우 쉽게 삭제 가능
 * 서비스 초기 구축 단계에선 테이블 설계(여기서는 Entity설계)가 빈번하게 변경되는데 롬복의 어노테이션들이 코드 변경량 최소화 해준다.
 */

@Entity // JPA의 어노테이션으로 주요 어노테이션 일 수록 class에 가깝게 두기
public class Posts {

    @Id // 해당 table의 pk 필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK생성 규칙을 말한다.
    private Long id;

    @Column(length = 500, nullable = false) // table의 Column(열)을 나태내며 선언 안해도 해당 class 모두 칼럼이 된다.
                                            // 기본본 값 외 추가로 변경이 필요할 옵션이 있을 경우 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    // 문자열 VARCHAR(255)가 기본값인데 사이즈를 500으로 늘리고 싶거나 title,content등의 type을 TEXT로 변경하고 싶을 경우 사용

    private String content;

    private String author;

    //@Builder 해당 클래스의 빌더 패턴 클래스를 생성 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함한다.
    //생성자에 어떤 값을 채워야 되는지 명확하게 지정해 줄 수 있다.
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
