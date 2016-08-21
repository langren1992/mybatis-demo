package com.zhwl.authority.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhwl.authority.mapper.RaDeptRoleMapper;
import com.zhwl.authority.mapper.RaUserRoleMapper;
import com.zhwl.authority.service.RaDeptRoleService;
import com.zhwl.authority.service.RaUserRoleService;
import com.zhwl.basis.model.TsUser;

@Service
public class RaDeptRoleServiceImpl implements RaDeptRoleService{
	
	@Autowired
	private RaDeptRoleMapper raUserRoleMapper;

	@Override
	public Set<String> findRoleByDept(String deptNo) {
		return raUserRoleMapper.findRoleByDept(deptNo);
	}
	
	

}
