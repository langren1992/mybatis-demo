package com.zhwl.authority.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhwl.authority.entity.UserEntity;
import com.zhwl.authority.mapper.UserMapper;
import com.zhwl.authority.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserEntity findByUsername(String username) {
		UserEntity record = new UserEntity();
		record.setUsername(username);
		return userMapper.select(record).get(0);
	}
	
}
