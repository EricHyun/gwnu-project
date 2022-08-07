package com.gwnu.admin.Gangneungwalk.service.posts;

import com.gwnu.admin.Gangneungwalk.controller.dto.PostsSaveRequestDto;
import com.gwnu.admin.Gangneungwalk.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();

    }
}
