package com.example.sampleservice.mappers;

import com.example.sampleservice.dtos.PostsDTO;
import com.example.sampleservice.dtos.SCSPostsDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SampleMapper {

    PostsDTO toPostsDTO(SCSPostsDTO scsPostsDTO);

    List<PostsDTO> toListPostsDTO(List<SCSPostsDTO> scsPostsDTO);
}
