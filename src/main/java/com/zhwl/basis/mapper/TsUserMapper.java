package com.zhwl.basis.mapper;

import java.util.List;

import com.zhwl.basis.model.TsRole;
import com.zhwl.basis.model.TsUser;

import tk.mybatis.mapper.common.Mapper;

public interface TsUserMapper extends Mapper<TsUser> {
	
	public String findUserRole(String str);
}