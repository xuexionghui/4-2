package com.junlaninfo.service;

import java.util.List;

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
	
	/*
	 * 返回所有的用户
	 */
	@Override
	public List<User> findAll() {
		List<User> users = userdaoImpl.findAll();
		return users;
	}
     /*
      * 保存用户
      */
	@Override
	public User save(User user) {
		User user2 = userdaoImpl.saveAndFlush(user);  //保存并强制同步
		return user2;
	}

	@Override
	public User findUserbyId(Long id) {
		User user = userdaoImpl.findOne(id);
		return user;
	}

	@Override
	public User updateUser(User user) {
		User user2 = userdaoImpl.saveAndFlush(user);   //保存并且强制刷新  jpa中，保存或者更新都使用saveAndFlush()  这个方法
		return user2;
	}
    
	@Override
	public int deleteUserById(Long id) {
		userdaoImpl.delete(id);
		return 0;
	}

}
