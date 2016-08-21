package com.zhwl.authority.service;

import java.util.List;
import java.util.Set;

import com.zhwl.basis.model.TsRole;
import com.zhwl.basis.model.TsUser;

/**
 * @ClassName: RaUserRoleService
 * @Description: 通过登陆名称查询角色(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年8月21日 下午6:04:06
 * 
 */
public interface RaUserRoleService {
	
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
