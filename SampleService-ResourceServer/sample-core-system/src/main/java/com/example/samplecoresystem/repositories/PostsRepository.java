package com.example.samplecoresystem.repositories;

import com.example.samplecoresystem.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    Optional<Posts> findByPostsId(String postsId);
}
