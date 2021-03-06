package com.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blog.domain.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
