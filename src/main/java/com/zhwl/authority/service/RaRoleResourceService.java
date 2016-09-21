package com.zhwl.authority.service;

import java.util.List;
import java.util.Set;

import com.zhwl.basis.model.TsResource;

public interface RaRoleResourceService {
	
	public List<TsResource> findResourceByRole(Object[] roleNoArray);

}
