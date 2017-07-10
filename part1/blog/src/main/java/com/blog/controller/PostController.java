package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.domain.Post;
import com.blog.repository.PostRepository;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	public PostController(PostRepository postRepository){		
		this.postRepository = postRepository;
	}
	
	@RequestMapping("/posts")
	public List<Post> getListOfPost(){
		List<Post> posts = (List<Post>) postRepository.findAll();			
		return posts;
	}	

}
