package com.junlaninfo.domian;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity    //表明这个类是一个实体类
public class User {   //会自动建表，表的名称是
    
	@Id     //对应于数据库中的主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)   //策略为自增长
	private  Long   id;
	
	@Column(nullable=false,unique=true)    //该变量对应于数据库中的字段
	private String    username;
	@Column
	private  String  password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
