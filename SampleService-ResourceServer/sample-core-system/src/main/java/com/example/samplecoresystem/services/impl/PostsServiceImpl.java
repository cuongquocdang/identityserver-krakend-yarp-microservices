package com.example.samplecoresystem.services.impl;

import com.example.samplecoresystem.dtos.PostsCreationRequestDTO;
import com.example.samplecoresystem.dtos.PostsDTO;
import com.example.samplecoresystem.mappers.PostsMapper;
import com.example.samplecoresystem.repositories.PostsRepository;
import com.example.samplecoresystem.services.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final PostsRepository postsRepository;
    private final PostsMapper postsMapper;

    @Override
    public PostsDTO retrievePostsByPostsId(String postsId) {
        var posts = postsRepository.findByPostsId(postsId)
                .orElseThrow();
        return postsMapper.toDTO(posts);
    }

    @Override
    public List<PostsDTO> retrieveAllPosts() {
        var listOfPosts = postsRepository.findAll();
        return postsMapper.toListDTO(listOfPosts);
    }

    @Override
    public PostsDTO createPosts(PostsCreationRequestDTO requestDTO) {
        var mappedPosts = postsMapper.toEntity(requestDTO);
        // random UUID postsId
        mappedPosts.setPostsId(UUID.randomUUID().toString());
        var posts = postsRepository.save(mappedPosts);
        return postsMapper.toDTO(posts);
    }
}
