/**
 * 
 */
package com.ppang.rest.webservices.restfulwebservices.post;

import java.util.Date;

/**
 * @author kaitaipang
 *
 */
public class Post {
	private Integer id;
	private Integer userId;
	private String content;
	private Date postDate;
	
	protected Post() {}
	
	public Post(Integer id, Integer userId, String content, Date postDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.postDate = postDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", userId=" + userId + ", content=" + content + ", postDate=" + postDate + "]";
	}
	
	
}
