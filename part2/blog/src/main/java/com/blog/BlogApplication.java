package com.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.blog.domain.Post;
import com.blog.repository.PostRepository;

@SpringBootApplication
public class BlogApplication {
		
	@Autowired
	private PostRepository pr;
	
	public BlogApplication(PostRepository pr){		
		this.pr = pr;
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	
		@Bean
	    CommandLineRunner runner(){
	    	return new CommandLineRunner() {
				
				@Override
				public void run(String... arg0) throws Exception {
					
					Post post1 = new Post();
					post1.setTitle("Blog Post 1");
					post1.setBody("Blog Body 1");
					pr.save(post1);
					
					Post post2 = new Post();
					post2.setTitle("Blog Post 2");
					post2.setBody("Blog Body 2");
					pr.save(post2);
					
					Post post3 = new Post();
					post3.setTitle("Blog Post 3");
					post3.setBody("Blog Body 3");
					pr.save(post3);

				}
			};
	    }
}
