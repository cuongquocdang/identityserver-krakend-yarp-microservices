package com.example.samplecoresystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PostsDTO {

    private String postsId;
    private String title;
    private String body;
}
