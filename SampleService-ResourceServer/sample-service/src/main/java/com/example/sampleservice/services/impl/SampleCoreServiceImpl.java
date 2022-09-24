package com.example.sampleservice.services.impl;

import com.example.resttemplateautoconfigure.CustomRestTemplateFactory;
import com.example.resttemplateautoconfigure.TargetExternalSystem;
import com.example.sampleservice.configs.SampleCoreServiceProperties;
import com.example.sampleservice.dtos.SCSPostsDTO;
import com.example.sampleservice.services.SampleCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleCoreServiceImpl implements SampleCoreService {

    private final CustomRestTemplateFactory restTemplateFactory;
    private final SampleCoreServiceProperties sampleCoreServiceProperties;

    @Override
    public SCSPostsDTO retrievePostsByPostsId(String postsId) {
        var endpoint = String.format(sampleCoreServiceProperties.getUrls().getRetrievePostsByPostsId(), postsId);
        return restTemplateFactory
                .target(TargetExternalSystem.CORE_ES)
                .getForObject(endpoint, SCSPostsDTO.class);
    }

    @Override
    public List<SCSPostsDTO> retrieveAllPosts() {
        var endpoint = sampleCoreServiceProperties.getUrls().getRetrieveAllPosts();
        var listOfPosts = restTemplateFactory
                .target(TargetExternalSystem.CORE_ES)
                .getForObject(endpoint, SCSPostsDTO[].class);
        return null == listOfPosts || 0 == listOfPosts.length
                ? List.of()
                : List.of(listOfPosts);
    }
}
