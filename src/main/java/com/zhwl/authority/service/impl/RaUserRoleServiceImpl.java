package com.zhwl.authority.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhwl.authority.mapper.RaUserRoleMapper;
import com.zhwl.authority.service.RaUserRoleService;
import com.zhwl.basis.model.TsUser;

@Service
public class RaUserRoleServiceImpl implements RaUserRoleService{
	
	@Autowired
	private RaUserRoleMapper raUserRoleMapper;

	@Override
	public Set<String> findRoleByUser(String userNo) {
		return raUserRoleMapper.findRoleByUser(userNo);
	}
	
	

}
