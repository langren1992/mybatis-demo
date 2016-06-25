package com.zhwl.authority.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zhwl.common.entity.BaseEntity;

/**
 * @ClassName: UserEntity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年6月11日 下午9:04:03
 * 
 */
@Table(name = "sys_user")
public class UserEntity implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 777418943938838359L;
	@Id
	@GeneratedValue(generator = "UUID")
	private String id;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "organization_id")
	private String organizationId; // 所属公司
	
	@Transient
	private String organizationName;// 所属公司名称
	
	@Column(name = "username")
	private String username; // 用户名
	
	@Column(name = "password")
	private String password; // 密码
	
	@Column(name = "salt")
	private String salt; // 加密密码的盐
	
	@Column(name = "locked")
	private Boolean locked = Boolean.FALSE;
	
	@Transient
	private String creatUser;
	
	@Transient
	private String updatUser;

	public UserEntity() {
	}

	public UserEntity(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * 要获得的 @return number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            要设置的 number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * 要获得的 @return organizationId
	 */
	public String getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId
	 *            要设置的 organizationId
	 */
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * 要获得的 @return organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @param organizationName
	 *            要设置的 organizationName
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * 要获得的 @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            要设置的 username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 要获得的 @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 要获得的 @return salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt
	 *            要设置的 salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}


	/**
	 * 要获得的 @return locked
	 */
	public Boolean getLocked() {
		return locked;
	}

	/**
	 * @param locked
	 *            要设置的 locked
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
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
	 * 要获得的 @return updatUser
	 */
	public String getUpdatUser() {
		return updatUser;
	}

	/**
	 * @param updatUser
	 *            要设置的 updatUser
	 */
	public void setUpdatUser(String updatUser) {
		this.updatUser = updatUser;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserEntity user = (UserEntity) o;

		if (id != null ? !id.equals(user.id) : user.id != null)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", organizationId=" + organizationId
				+ ", username='" + username + '\'' + ", password='" + password
				+ '\'' + ", salt='" + salt + '\'' + ", locked=" + locked + '}';
	}
}
