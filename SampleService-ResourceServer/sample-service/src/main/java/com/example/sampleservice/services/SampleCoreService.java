package com.example.sampleservice.services;

import com.example.sampleservice.dtos.SCSPostsDTO;

import java.util.List;

public interface SampleCoreService {

    SCSPostsDTO retrievePostsByPostsId(String postsId);

    List<SCSPostsDTO> retrieveAllPosts();
}

