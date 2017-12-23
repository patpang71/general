package com.ppang.rest.webservices.restfulwebservices.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {
	private static List<Post> postList = new ArrayList<>();
	private static int postCount = 5;
	
	static {
		postList.add(new Post(101, 1, "This is the first post for user 1", new Date()));
		postList.add(new Post(102, 1, "Second post for user 1", new Date()));
		postList.add(new Post(103, 1, "Third post for user 1", new Date()));
		postList.add(new Post(204, 2, "Post for 2nd user", new Date()));
		postList.add(new Post(205, 2, "2nd post 2nd user", new Date()));
	}
	
	public List<Post> getAllPostForUser(Integer userId) {
		List<Post> result = new ArrayList<>();
		for (Post post : postList) {
			if (post.getUserId()==userId) {
				result.add(post);
			}
		}
		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public Post getOnePostForUser(Integer userId, Integer postId) {
		for (Post post : postList) {
			if (post.getId()==postId && post.getUserId()==userId) {
				return post;
			}
		}
		return null;
	}
	
	public Post addPost(Post post) {
		post.setId(++postCount);
		postList.add(post);
		return post;
	}
}
