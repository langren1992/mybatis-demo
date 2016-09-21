package com.zhwl.basis.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhwl.basis.helper.PasswordHelper;
import com.zhwl.basis.mapper.TsResourceMapper;
import com.zhwl.basis.mapper.TsUserMapper;
import com.zhwl.basis.model.TsResource;
import com.zhwl.basis.model.TsRole;
import com.zhwl.basis.model.TsUser;
import com.zhwl.basis.service.TsResourceService;
import com.zhwl.basis.service.TsUserService;


@Service
public class TsResourceServiceImpl implements TsResourceService{
	
	@Autowired
	private TsResourceMapper tsResourceMapper;

	@Override
	public List<TsResource> findResources() {
		return tsResourceMapper.selectAll();
	}

	
	
}
