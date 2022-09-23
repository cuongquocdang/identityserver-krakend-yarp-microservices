package com.example.samplecoresystem.controllers;

import com.example.samplecoresystem.dtos.PostsCreationRequestDTO;
import com.example.samplecoresystem.dtos.PostsDTO;
import com.example.samplecoresystem.services.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/posts")
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostsDTO createPosts(@RequestBody PostsCreationRequestDTO requestDTO) {
        return postService.createPosts(requestDTO);
    }

    @GetMapping
    public List<PostsDTO> retrieveAllPosts() {
        return postService.retrieveAllPosts();
    }

    @GetMapping("{postsId}")
    public PostsDTO retrievePostsByPostsId(@PathVariable String postsId) {
        return postService.retrievePostsByPostsId(postsId);
    }
}
