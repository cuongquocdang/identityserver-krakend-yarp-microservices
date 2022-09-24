package com.example.sampleservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class SCSPostsDTO {

    private String postsId;
    private String title;
    private String body;
}
