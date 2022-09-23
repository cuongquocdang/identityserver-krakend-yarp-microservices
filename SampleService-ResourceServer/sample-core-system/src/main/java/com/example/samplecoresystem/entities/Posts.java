package com.example.samplecoresystem.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL")
    private Long id;

    @Column(name = "posts_id")
    private String postsId;

    @Column
    private String title;

    @Column
    private String body;
}
