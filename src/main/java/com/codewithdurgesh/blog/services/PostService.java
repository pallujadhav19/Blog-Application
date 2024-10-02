package com.codewithdurgesh.blog.services;

import java.util.List;

import com.codewithdurgesh.blog.entities.Post;
import com.codewithdurgesh.blog.payloads.PostDto;
import com.codewithdurgesh.blog.payloads.PostResponse;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all post
	
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	//get single post
	PostDto getPostById(Integer postId);
	
	//get all post by category
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostByUser(Integer userId);
	
	//search post
	List<PostDto> searchPosts(String keyword);
	

}
