package com.gwnu.admin.Gangneungwalk.controller.dto;


import com.gwnu.admin.Gangneungwalk.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Controller와 Service에서 사용할 Dto클래스
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

  @Builder
    public PostsSaveRequestDto(String title, String content, String author){
      this.title = title;
      this.content = content;
      this.author = author;
  }

  public Posts toEntity(){
      return Posts.builder()
              .title(title)
              .content(content)
              .author(author)
              .build();
  }
}
