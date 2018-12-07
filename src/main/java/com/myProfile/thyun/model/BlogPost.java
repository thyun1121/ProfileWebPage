package com.myProfile.thyun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_POST")
public class BlogPost {
	@Id
	@Column(name="POST_NO")
	private int postNo;
	@Column(name="POST_TITLE")
	private String postTitle;
	@Column(name="POST_SUBTITLE")
	private String postSubtitle;
	@Column(name="POST_DATE")
	private String postDate;
	@Column(name="POST_URL")
	private String postUrl;
	@Column(name="POST_CONTS")
	private String postConts;
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostSubtitle() {
		return postSubtitle;
	}
	public void setPostSubtitle(String postSubtitle) {
		this.postSubtitle = postSubtitle;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getPostUrl() {
		return postUrl;
	}
	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}
	public String getPostConts() {
		return postConts;
	}
	public void setPostConts(String postConts) {
		this.postConts = postConts;
	}
	
}
