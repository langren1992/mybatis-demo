package com.zhwl.authority.mapper;

import java.util.Set;

import com.zhwl.authority.model.RaRoleResource;

import tk.mybatis.mapper.common.Mapper;

public interface RaRoleResourceMapper extends Mapper<RaRoleResource> {
	
	public Set<String> findResourceByRole(String roleNo);
}