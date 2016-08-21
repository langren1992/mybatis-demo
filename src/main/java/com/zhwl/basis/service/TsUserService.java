package com.zhwl.basis.service;

import java.util.List;

import com.zhwl.basis.model.TsRole;
import com.zhwl.basis.model.TsUser;


public interface TsUserService {

	public TsUser findByUsername(TsUser user);
	
	public int createUser(TsUser tsUser);
	
	public String findUserRole(TsRole role);

}
