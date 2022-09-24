package com.example.sampleservice.controllers;

import com.example.sampleservice.dtos.PostsDTO;
import com.example.sampleservice.services.SampleManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/sample-managements")
@RequiredArgsConstructor
public class SampleManagementController {

    private final SampleManagementService sampleManagementService;

    @GetMapping("/posts/{postsId}")
    public PostsDTO retrievePostsById(@PathVariable String postsId) {
        return sampleManagementService.retrievePostsByPostsId(postsId);
    }

    @GetMapping("/posts")
    public List<PostsDTO> retrievePostsById() {
        return sampleManagementService.retrieveAllPosts();
    }
}
