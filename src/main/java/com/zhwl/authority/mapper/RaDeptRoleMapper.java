package com.zhwl.authority.mapper;

import java.util.Set;

import com.zhwl.authority.model.RaDeptRole;

import tk.mybatis.mapper.common.Mapper;

public interface RaDeptRoleMapper extends Mapper<RaDeptRole> {

	Set<String> findRoleByDept(String deptNo);
}