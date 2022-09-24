package com.example.sampleservice.services;

import com.example.sampleservice.dtos.PostsDTO;

import java.util.List;

public interface SampleManagementService {

    PostsDTO retrievePostsByPostsId(String postsId);

    List<PostsDTO> retrieveAllPosts();
}
