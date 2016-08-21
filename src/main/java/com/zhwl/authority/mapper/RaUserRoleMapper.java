package com.zhwl.authority.mapper;

import java.util.List;
import java.util.Set;

import com.zhwl.authority.model.RaUserRole;
import com.zhwl.basis.model.TsRole;
import com.zhwl.basis.model.TsUser;

import tk.mybatis.mapper.common.Mapper;

public interface RaUserRoleMapper extends Mapper<RaUserRole> {
	
	/** 
	 * @Title: findRoleByUser 
	 * @Description: 通过用户信息查询用户角色(这里用一句话描述这个方法的作用) 
	 * @author Administrator
	 * @param user
	 * @return List<TsRole> 返回类型 
	 * @throws 
	 */ 
	public Set<String> findRoleByUser(String userNo);
}