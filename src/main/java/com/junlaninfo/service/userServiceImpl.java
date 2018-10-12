package com.junlaninfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junlaninfo.dao.userDao;
import com.junlaninfo.domian.User;

@Service
public class userServiceImpl  implements userService{
    @Autowired
    private userDao   userdaoImpl;
	public User findUserByusername(String username) {
	     User user= userdaoImpl.findUserByusername(username);
		return user;
	}

}
