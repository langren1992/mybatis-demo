package com.zhwl.authority.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhwl.authority.mapper.RaRoleResourceMapper;
import com.zhwl.authority.service.RaRoleResourceService;
import com.zhwl.basis.model.TsResource;
@Service
public class RaRoleResourceServiceImpl implements RaRoleResourceService{
	
	@Autowired
	private RaRoleResourceMapper raRoleResourceMapper;

	@Override
	public List<TsResource> findResourceByRole(Object[] roleNoArray) {
		return raRoleResourceMapper.findResourceByRole(roleNoArray);
	}



}
