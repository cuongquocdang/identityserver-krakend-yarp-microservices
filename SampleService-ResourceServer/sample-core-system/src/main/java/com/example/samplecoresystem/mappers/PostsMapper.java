package com.example.samplecoresystem.mappers;

import com.example.samplecoresystem.dtos.PostsCreationRequestDTO;
import com.example.samplecoresystem.dtos.PostsDTO;
import com.example.samplecoresystem.entities.Posts;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostsMapper {

    Posts toEntity(PostsCreationRequestDTO requestDTO);

    PostsDTO toDTO(Posts posts);

    List<PostsDTO> toListDTO(List<Posts> listOfPosts);
}
