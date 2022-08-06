package com.gwnu.admin.Gangneungwalk.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository<Entity class,PK 타입> 인터페이스를 상속하면 기본적인 CRUD 메소드 자동으로 생성된다.
 * @Repository를 추가할 필요없다. 대신 Entity class와 기본 Entity Repository는 함께 위치해야 된다.
 * 아주 밀접한 관계 이기 때문에 Entity class는 repository없이 제대로 역활을 수행 할 수 없다.
 */
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
