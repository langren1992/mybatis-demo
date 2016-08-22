package com.zhwl.authority.mapper;

import java.util.List;
import java.util.Set;

import com.zhwl.authority.model.RaRoleResource;
import com.zhwl.basis.model.TsResource;

import tk.mybatis.mapper.common.Mapper;

public interface RaRoleResourceMapper extends Mapper<RaRoleResource> {
	
	public List<TsResource> findResourceByRole(String roleNo);
}