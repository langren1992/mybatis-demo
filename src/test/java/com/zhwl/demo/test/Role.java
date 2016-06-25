package com.zhwl.demo.test;

public class Role {
	private String roleName;
	
	private String roleCode;
	
	private User[] users;
	
	/** 
	 * 要获得的 @return users 
	 */
	public User[] getUsers() {
		return users;
	}

	/** 
	 * @param users 要设置的 users 
	 */
	public void setUsers(User[] users) {
		this.users = users;
	}

	/** 
	 * 要获得的 @return roleName 
	 */
	public String getRoleName() {
		return roleName;
	}

	/** 
	 * @param roleName 要设置的 roleName 
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/** 
	 * 要获得的 @return roleCode 
	 */
	public String getRoleCode() {
		return roleCode;
	}

	/** 
	 * @param roleCode 要设置的 roleCode 
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
}
