package com.junlaninfo.controller;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.junlaninfo.domian.User;
import com.junlaninfo.service.userService;


import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class userController {
    
	/*
	 *  jpa的使用详解：
	 *           https://blog.csdn.net/liuchuanhong1/article/details/52042477
	 */
	@Autowired
	private userService  userserviceImpl;
	
	@ApiOperation(value="根据ID获取用户信息",notes="根据URL的id获取user的详细信息")
	@RequestMapping(value="/{username}")
	public User findUserByUserName(@PathVariable("username")String username) {
		User user=userserviceImpl.findUserByusername(username);
		return user;
	}

	@ApiOperation(value="查询所有的用户",notes="用户列表")
	@RequestMapping(value= {""},method=RequestMethod.GET)   //这种方式的value需要注意一下
	public List<User>   findAll(){
		return userserviceImpl.findAll();
	}
	
	@ApiOperation(value="保存用户",notes="保存用户")
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public User   saveUser(@RequestBody User  user) {   //Javabean接收数据
		
		return  userserviceImpl.save(user);
	}
	
	@ApiOperation(value="修改用户",notes="修改用户")
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public  User  updateUser( Long  id,String username,String password) {
		User user=userserviceImpl.findUserbyId(id);
		User user2 =null;
		if(user!=null) {
			user.setUsername(username);
			user.setPassword(password);
			 user2 = userserviceImpl.updateUser(user);
		}
		return user2;
	}
	
	@ApiOperation(value="删除用户",notes="根据ID值删除指定的用户")
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public  String deleteUser(Long id) {
		User user = userserviceImpl.findUserbyId(id);
		if (user!=null) {
		int i=	userserviceImpl.deleteUserById(id);
		return "success";
		}
		return "false";
	}
	
	@ApiIgnore   //忽略这个方法的API
	@RequestMapping(value="/hi",method=RequestMethod.GET)
	public  String  sayHi() {
		return "Hi";
	}
}
