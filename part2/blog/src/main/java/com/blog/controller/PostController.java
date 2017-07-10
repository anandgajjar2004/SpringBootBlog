package com.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	/*
	 * Get List of Post 
	 */
	@RequestMapping(value = "/posts", method= RequestMethod.GET)
	public List<Post> getListOfPost(){
		List<Post> posts = (List<Post>) postRepository.findAll();			
		return posts;
	}
	
	/*
	 * POST Method which accept Post object 
	 * Persist Post object into database.
	 * return Post object with Id.  
	 */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public Post savePost(@RequestBody Post post) {				
		return postRepository.save(post);			
	}
	
	/*
	 * GET  Method which accept id 
	 * get Post object from database using Id.
	 * return Post object.  
	 */
	@RequestMapping(value="/post/{id}",method = RequestMethod.GET)
	public Post getPostById(@PathVariable(value="id") Long id){		
		return postRepository.findOne(id);
	}
	
	/*
	 * DELETE Method which accept id 
	 * delete Post object from database using Id.
	 * return Success Message.  
	 */
	@RequestMapping(value="/post/{id}", method = RequestMethod.DELETE)
	public Map<String, String> deletePostById(@PathVariable Long id) {
		Map<String, String> message = new HashMap<String,String>();
		postRepository.delete(id);
		message.put("message", "Post Deleted Successfully");
		return message;
	}
	
	  /*
	  * PUT Method which accept id and Post object.  
	  * update Post object into database.
      * return Updated Post object.  
	  */
	  @RequestMapping(value="/post/{id}", method=RequestMethod.PUT)
	  public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
	    Post update = postRepository.findOne(id);
	    update.setTitle(post.getTitle());
	    update.setBody(post.getBody());	    	   
	    return postRepository.save(update);
	  }
}
