package com.gwnu.admin.Gangneungwalk.controller;


import com.gwnu.admin.Gangneungwalk.controller.dto.PostsSaveRequestDto;
import com.gwnu.admin.Gangneungwalk.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){

        return postsService.save(requestDto);
    }
}
