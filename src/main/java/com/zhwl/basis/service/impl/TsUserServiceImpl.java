package com.zhwl.basis.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhwl.basis.helper.PasswordHelper;
import com.zhwl.basis.mapper.TsUserMapper;
import com.zhwl.basis.model.TsRole;
import com.zhwl.basis.model.TsUser;
import com.zhwl.basis.service.TsUserService;


@Service
public class TsUserServiceImpl implements TsUserService{

	@Autowired
	private TsUserMapper tsUserMapper;
	@Autowired
	private PasswordHelper passwordHelper;
	
	@Override
	public TsUser findByUsername(TsUser user) {
		return tsUserMapper.selectOne(user);
	}

	@Override
	public int createUser(TsUser tsUser) {
		passwordHelper.encryptPassword(tsUser);
		return this.tsUserMapper.insert(tsUser);
	}

	@Override
	public String findUserRole(TsRole role) {
		return this.findUserRole(role);
	}
	
	
	
}
