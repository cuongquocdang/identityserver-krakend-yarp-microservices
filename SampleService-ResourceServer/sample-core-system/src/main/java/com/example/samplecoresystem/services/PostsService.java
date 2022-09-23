package com.example.samplecoresystem.services;

import com.example.samplecoresystem.dtos.PostsDTO;
import com.example.samplecoresystem.dtos.PostsCreationRequestDTO;

import java.util.List;

public interface PostsService {

    PostsDTO retrievePostsByPostsId(String postsId);

    List<PostsDTO> retrieveAllPosts();

    PostsDTO createPosts(PostsCreationRequestDTO requestDTO);
}
