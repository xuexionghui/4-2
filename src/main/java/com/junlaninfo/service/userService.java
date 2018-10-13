package com.junlaninfo.service;

import java.util.List;

import com.junlaninfo.domian.User;

public interface userService {

	User findUserByusername(String username);

	List<User> findAll();

	User save(User user);

	User findUserbyId(Long id);

	User updateUser(User user);

	int deleteUserById(Long id);

}
