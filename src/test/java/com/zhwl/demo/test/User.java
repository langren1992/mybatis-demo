package com.zhwl.demo.test;

public class User {

	private String name;
	
	private String code;

	private Role[] role ;
	
	public User(){
		
	}
	
	/** 
	 * 要获得的 @return role 
	 */
	public Role[] getRole() {
		return role;
	}

	/** 
	 * @param role 要设置的 role 
	 */
	public void setRole(Role[] role) {
		this.role = role;
	}

	/** 
	 * 要获得的 @return name 
	 */
	public String getName() {
		return name;
	}

	/** 
	 * @param name 要设置的 name 
	 */
	public void setName(String name) {
		this.name = name;
	}
 
	/** 
	 * 要获得的 @return code 
	 */
	public String getCode() {
		return code;
	}

	/** 
	 * @param code 要设置的 code 
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
