package com.zhwl.basis.model;

import java.util.Date;

import javax.persistence.*;

@Table(name = "ts_user")
public class TsUser {
    /**
     * 主键
     */
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    /**
     * 编码/登陆名
     */
    @Column(name = "USER_NO")
    private String userNo;

    /**
     * 名称
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "USER_PASSWORD")
    private String userPassword;

    /**
     * 盐值
     */
    @Column(name = "USER_SALT")
    private String userSalt;

    /**
     * 状态 0:锁定;1:启用
     */
    @Column(name = "USER_STATUS")
    private Integer userStatus;

    /**
     * 电话
     */
    @Column(name = "USER_Tel")
    private String userTel;

    /**
     * 手机
     */
    @Column(name = "USER_PHONE")
    private String userPhone;

    /**
     * 所属部门编码
     */
    @Column(name = "USER_DEPT_NO")
    private String userDeptNo;

    /**
     * 所属部门名称
     */
    @Column(name = "USER_DEPT_NAME")
    private String userDeptName;

    /**
     * 创建人编码
     */
    @Column(name = "CREATOR")
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改人编码
     */
    @Column(name = "MODIFIER")
    private String modifier;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    /**
     * 组织
     */
    @Column(name = "ORG_ID")
    private String orgId;

    /**
     * 资源版本号
     */
    @Column(name = "REC_VER")
    private Integer recVer;

    /**
     * 获取主键
     *
     * @return USER_ID - 主键
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置主键
     *
     * @param userId 主键
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取编码/登陆名
     *
     * @return USER_NO - 编码/登陆名
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置编码/登陆名
     *
     * @param userNo 编码/登陆名
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * 获取名称
     *
     * @return USER_NAME - 名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置名称
     *
     * @param userName 名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码
     *
     * @return USER_PASSWORD - 密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置密码
     *
     * @param userPassword 密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取盐值
     *
     * @return USER_SALT - 盐值
     */
    public String getUserSalt() {
        return userSalt;
    }

    /**
     * 设置盐值
     *
     * @param userSalt 盐值
     */
    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    /**
     * 获取状态 0:锁定;1:启用
     *
     * @return USER_STATUS - 状态 0:锁定;1:启用
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 设置状态 0:锁定;1:启用
     *
     * @param userStatus 状态 0:锁定;1:启用
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取电话
     *
     * @return USER_Tel - 电话
     */
    public String getUserTel() {
        return userTel;
    }

    /**
     * 设置电话
     *
     * @param userTel 电话
     */
    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    /**
     * 获取手机
     *
     * @return USER_PHONE - 手机
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置手机
     *
     * @param userPhone 手机
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取所属部门编码
     *
     * @return USER_DEPT_NO - 所属部门编码
     */
    public String getUserDeptNo() {
        return userDeptNo;
    }

    /**
     * 设置所属部门编码
     *
     * @param userDeptNo 所属部门编码
     */
    public void setUserDeptNo(String userDeptNo) {
        this.userDeptNo = userDeptNo;
    }

    /**
     * 获取所属部门名称
     *
     * @return USER_DEPT_NAME - 所属部门名称
     */
    public String getUserDeptName() {
        return userDeptName;
    }

    /**
     * 设置所属部门名称
     *
     * @param userDeptName 所属部门名称
     */
    public void setUserDeptName(String userDeptName) {
        this.userDeptName = userDeptName;
    }

    /**
     * 获取创建人编码
     *
     * @return CREATOR - 创建人编码
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人编码
     *
     * @param creator 创建人编码
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人编码
     *
     * @return MODIFIER - 修改人编码
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人编码
     *
     * @param modifier 修改人编码
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * 获取修改时间
     *
     * @return MODIFY_TIME - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取组织
     *
     * @return ORG_ID - 组织
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 设置组织
     *
     * @param orgId 组织
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取资源版本号
     *
     * @return REC_VER - 资源版本号
     */
    public Integer getRecVer() {
        return recVer;
    }

    /**
     * 设置资源版本号
     *
     * @param recVer 资源版本号
     */
    public void setRecVer(Integer recVer) {
        this.recVer = recVer;
    }

	public TsUser(String userNo) {
		super();
		this.userNo = userNo;
	}
	
	public TsUser() {
		super();
	}
    
}