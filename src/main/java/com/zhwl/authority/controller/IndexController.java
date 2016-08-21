package com.zhwl.authority.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhwl.authority.bind.annotation.CurrentUser;
import com.zhwl.authority.service.RaDeptRoleService;
import com.zhwl.authority.service.RaRoleResourceService;
import com.zhwl.authority.service.RaUserRoleService;
import com.zhwl.basis.model.TsResource;
import com.zhwl.basis.model.TsUser;
import com.zhwl.common.entity.Result;


@Controller
public class IndexController {

	@Autowired
	private RaRoleResourceService raRoleResourceService;
	@Autowired
	private RaUserRoleService raUserRoleService;
	@Autowired
	private RaDeptRoleService raDeptRoleService;
	
	@RequestMapping("/menu")
	@ResponseBody
	public Result loadMenu(@CurrentUser TsUser loginUser) {
		Result rs = new Result();
		/**
		 * 查询用户的所有权限项
		 * */
		Set<String> permissions = raUserRoleService.findRoleByUser(loginUser.getUserNo());
		/**
		 * 查询用户部门权限项
		 * */
		permissions.addAll(raDeptRoleService.findRoleByDept(loginUser.getUserDeptNo()));
		/**
		 * 从权限项中查询出菜单情况
		 * */
		List<TsResource> menus = raRoleResourceService.findResourceByRole(permissions);
		rs.setData(menus);
		return rs;
	}

	@RequestMapping("/")
	public String index(@CurrentUser TsUser loginUser, Model model) {
		return "index";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
