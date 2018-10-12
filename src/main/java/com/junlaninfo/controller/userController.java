package com.junlaninfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junlaninfo.domian.User;
import com.junlaninfo.service.userService;

@RestController
public class userController {
    
	@Autowired
	private userService  userserviceImpl;
	@RequestMapping(value="/{username}")
	public User findUserByUserName(@PathVariable("username")String username) {
		User user=userserviceImpl.findUserByusername(username);
		return user;
	}
	
}
