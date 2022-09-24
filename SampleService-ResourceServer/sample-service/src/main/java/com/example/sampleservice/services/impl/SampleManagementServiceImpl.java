package com.example.sampleservice.services.impl;

import com.example.sampleservice.dtos.PostsDTO;
import com.example.sampleservice.mappers.SampleMapper;
import com.example.sampleservice.services.SampleCoreService;
import com.example.sampleservice.services.SampleManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleManagementServiceImpl implements SampleManagementService {

    private final SampleCoreService sampleCoreService;
    private final SampleMapper sampleMapper;

    @Override
    public PostsDTO retrievePostsByPostsId(String postsId) {
        var scsPosts = sampleCoreService.retrievePostsByPostsId(postsId);
        return sampleMapper.toPostsDTO(scsPosts);
    }

    @Override
    public List<PostsDTO> retrieveAllPosts() {
        var listsOfSCSPosts = sampleCoreService.retrieveAllPosts();
        return sampleMapper.toListPostsDTO(listsOfSCSPosts);
    }
}
