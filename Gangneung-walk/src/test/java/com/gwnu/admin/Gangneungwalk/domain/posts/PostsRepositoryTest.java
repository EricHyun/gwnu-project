package com.gwnu.admin.Gangneungwalk.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


/**
 * save, findAll 기능 테스트
 * application.properties 에서 spring.jpa.show_sql = true 작성해주면
 * 실제로 실행된 쿼리 로그를 볼 수 있다. H2는 MySQL의 쿼리를 수행해도 정상 작동한다.
 * 출력된 쿼리 MySQL 으로 보는방법 또한 application.properties 작성
 */

//@RunWith 생략 가능 버전이 올라가면서
@SpringBootTest
@RunWith(SpringRunner.class)
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test //Test코드에서는 이런식으로 한국어로 보기 쉽게 작성해도 상관없다.
    public void 게시물저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //table Posts 에 insert/update 쿼리를 실행
        //id가 존재하면 update 없으면 insert
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("admin.test.com")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll(); // posts 데이터 모두 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
