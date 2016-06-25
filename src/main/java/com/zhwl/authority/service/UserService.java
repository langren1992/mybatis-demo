package com.zhwl.authority.service;

import com.zhwl.authority.entity.UserEntity;

public interface UserService {

	public UserEntity findByUsername(String username);

}
