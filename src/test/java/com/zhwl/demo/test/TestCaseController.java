package com.zhwl.demo.test;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/test")
public class TestCaseController {
	
//	@RequestMapping(value ="/testSingleParam",method= RequestMethod.GET)
	@RequestMapping(value ="/testSingleParam",method= RequestMethod.POST)
	@ResponseBody
	public String testSingleParam(String name,@RequestBody String na){
		return name+">>>>>>>>>>>>>>>>"+na;
	}
	
//	@RequestMapping(value ="/testMoreParam",method= RequestMethod.GET)
	@RequestMapping(value ="/testMoreParam",method= RequestMethod.POST)
	@ResponseBody
	public String testMoreParam(String name,String code,@RequestBody String na,@RequestBody String co){
//		@SuppressWarnings("static-access")
//		JSONObject jsonObject = new JSONObject().fromObject(na);
//		User bean = (User) JSONObject.toBean(jsonObject, User.class);
//		JSONArray jsonArray = new JSONArray().fromObject(na);
//		List list = (List<User>)JSONArray.toCollection(jsonArray, User.class);
		List<User> parseArray = JSON.parseArray(na,User.class);
		return name+">>>>>>>>>>>>>>>>>>"+code+">>>>>>>>>>>>>>>>"+na+">>>>>>>>>>>>>>>>"+co;
	}
	
//	@RequestMapping(value ="/testSingleObjectParam",method= RequestMethod.GET)
	@RequestMapping(value ="/testSingleObjectParam",method= RequestMethod.POST)
	@ResponseBody
	public String testSingleObjectParam( User user, @RequestBody User[] u){
		Role[] role = null;
		for (int i = 0; i < u.length; i++) {
			User user2 = u[i];
			role = user2.getRole();
		}
		User[] users =null;
		for (int i = 0; i < role.length; i++) {
			Role role2 = role[i];
			users = role2.getUsers();
		}
		for (int i = 0; i < users.length; i++) {
			User user2 = users[i];
		}
		return user.getName()+">>>>>>>>>>>>>>>>>>"+user.getCode()+">>>>>>>"+u[0].getName()+">>>>>>>>>>>>>>>>>>"+u[0].getCode();
	}

	/**
	 * 
	 * 在多个@RequestBody非基础类的情况下接受多个平级的json对象的时候400 bed Request
	 * */
//	@RequestMapping(value ="/testMoreObjectParam",method= RequestMethod.GET)
	@RequestMapping(value ="/testMoreObjectParam",method= RequestMethod.POST)
	@ResponseBody
	public String testMoreObjectParam(User user,Role role,@RequestBody User u,@RequestBody  Role r){
		return "User:"+user.getName()+">>>>>>>>>>>>>>>>>>"+user.getName()
				+"Role:"+role.getRoleName()+">>>>>>>>>>>>>>>>>>"+role.getRoleCode()
				+"U:"+u.getName()+">>>>>>>>>>>>>>>>>>"+u.getName()
				+"R:"+r.getRoleName()+">>>>>>>>>>>>>>>>>>"+r.getRoleCode();
	}
	
}
//class User{
//	
//	private String name;
//	
//	private String code;
//
//	private Role[] role ;
//	
//	public User(){
//		
//	}
//	
//	/** 
//	 * 要获得的 @return role 
//	 */
//	public Role[] getRole() {
//		return role;
//	}
//
//	/** 
//	 * @param role 要设置的 role 
//	 */
//	public void setRole(Role[] role) {
//		this.role = role;
//	}
//
//	/** 
//	 * 要获得的 @return name 
//	 */
//	public String getName() {
//		return name;
//	}
//
//	/** 
//	 * @param name 要设置的 name 
//	 */
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	/** 
//	 * 要获得的 @return code 
//	 */
//	public String getCode() {
//		return code;
//	}
//
//	/** 
//	 * @param code 要设置的 code 
//	 */
//	public void setCode(String code) {
//		this.code = code;
//	}
//	
//}
//
//class Role{
//	
//	private String roleName;
//	
//	private String roleCode;
//	
//	private User[] users;
//	
//	/** 
//	 * 要获得的 @return users 
//	 */
//	public User[] getUsers() {
//		return users;
//	}
//
//	/** 
//	 * @param users 要设置的 users 
//	 */
//	public void setUsers(User[] users) {
//		this.users = users;
//	}
//
//	/** 
//	 * 要获得的 @return roleName 
//	 */
//	public String getRoleName() {
//		return roleName;
//	}
//
//	/** 
//	 * @param roleName 要设置的 roleName 
//	 */
//	public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	}
//
//	/** 
//	 * 要获得的 @return roleCode 
//	 */
//	public String getRoleCode() {
//		return roleCode;
//	}
//
//	/** 
//	 * @param roleCode 要设置的 roleCode 
//	 */
//	public void setRoleCode(String roleCode) {
//		this.roleCode = roleCode;
//	}
//
//	

//	
//}