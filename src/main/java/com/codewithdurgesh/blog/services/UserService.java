package com.codewithdurgesh.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.payloads.UserDto;



public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userid);
	UserDto getUserById(Integer userid);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
	 
	
}
