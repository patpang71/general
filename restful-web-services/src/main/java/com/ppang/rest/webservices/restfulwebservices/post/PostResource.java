package com.ppang.rest.webservices.restfulwebservices.post;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class PostResource {
	
	@Autowired
	private PostDaoService service;
	
	@GetMapping("/users/{userId}/posts")
	public List<Post> retrieveAllPosts(@PathVariable Integer userId) {
		List<Post> result = service.getAllPostForUser(userId);
		if (result==null) {
			throw new PostNotFoundException("Post not found");
		}
		return result;
	}
	
	@GetMapping("/users/{userId}/posts/{postId}")
	public Post retrieveOnePost(@PathVariable Integer userId, @PathVariable Integer postId) {
		Post res = service.getOnePostForUser(userId, postId);
		if (res==null) {
			throw new PostNotFoundException("Post not found " + Integer.toString(postId));
		}
		return res;
	}
	
	@PostMapping("/users/{userId}/posts") 
	public ResponseEntity<Object> addPost(@PathVariable Integer userId, @RequestBody Post post) {
		Post savedPost = service.addPost(post);
		/*
		 * URI location = ServletUriComponentsBuilder
			.fromCurrentRequest().path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		 */
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPost.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
