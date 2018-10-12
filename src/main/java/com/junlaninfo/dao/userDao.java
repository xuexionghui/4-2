package com.junlaninfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junlaninfo.domian.User;

public interface userDao   extends JpaRepository<User, Long> {

	User findUserByusername(String username);

	

}
