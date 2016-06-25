package com.zhwl.demo.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "sys_role")
public class RoleEntity {
	private static final long serialVersionUID = -8950193603543155734L;
	@Id
	@GeneratedValue(generator = "UUID")
	private String id;
	@Column(name = "name")
	private String roleName;// 名称
	@Column(name = "code")
	private Integer code;// 编码
	@Column(name = "alias")
	private String alias;// 中文别名
	@Column(name = "available")
	private Boolean available; // 是否可用,如果不可用将不会添加给用户
	@Column(name = "description")
	private String description; // 角色描述,UI界面显示使用
	@Column(name = "create_user_id")
	private String creatUser;
	@Column(name = "update_user_id")
	private String updateUser;
	@Transient
	private String resId;// 关联的资源ID
	@Transient
	private String roleResStr;// 存放新增的资源，主要是JSON字符串

	public RoleEntity() {
	}

	public RoleEntity(String role, String description, Boolean available) {
		this.description = description;
		this.available = available;
	}

	/**
	 * 要获得的 @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 要获得的 @return roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            要设置的 roleName
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 要获得的 @return code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code
	 *            要设置的 code
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * 要获得的 @return alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias
	 *            要设置的 alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * 要获得的 @return available
	 */
	public Boolean getAvailable() {
		return available;
	}

	/**
	 * @param available
	 *            要设置的 available
	 */
	public void setAvailable(Boolean available) {
		this.available = available;
	}

	/**
	 * 要获得的 @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            要设置的 description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 要获得的 @return creatUser
	 */
	public String getCreatUser() {
		return creatUser;
	}

	/**
	 * @param creatUser
	 *            要设置的 creatUser
	 */
	public void setCreatUser(String creatUser) {
		this.creatUser = creatUser;
	}

	/**
	 * 要获得的 @return updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser
	 *            要设置的 updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * 要获得的 @return resId
	 */
	public String getResId() {
		return resId;
	}

	/**
	 * @param resId
	 *            要设置的 resId
	 */
	public void setResId(String resId) {
		this.resId = resId;
	}

	/**
	 * 要获得的 @return roleResStr
	 */
	public String getRoleResStr() {
		return roleResStr;
	}

	/**
	 * @param roleResStr
	 *            要设置的 roleResStr
	 */
	public void setRoleResStr(String roleResStr) {
		this.roleResStr = roleResStr;
	}

}
