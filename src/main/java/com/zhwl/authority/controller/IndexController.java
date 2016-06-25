package com.zhwl.authority.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhwl.authority.bind.annotation.CurrentUser;
import com.zhwl.authority.entity.UserEntity;
import com.zhwl.authority.service.UserService;
import com.zhwl.common.entity.Result;


@Controller
public class IndexController {

//	@Autowired
//	private ResourceService resourceService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/menu")
	@ResponseBody
	public Result loadMenu(@CurrentUser UserEntity loginUser) {
		Result rs = new Result();
//		/**
//		 * 查询用户的所有权限项
//		 * */
//		Set<String> permissions = userService.findPermissions(loginUser
//				.getUsername());
//		/**
//		 * 从权限项中查询出菜单情况
//		 * */
//		List<ResourceEntity> menus = resourceService.findMenus(permissions);
//		rs.setData(menus);
		return rs;
	}

	@RequestMapping("/")
	public String index(@CurrentUser UserEntity loginUser, Model model) {
		return "index";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
