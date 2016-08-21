package com.zhwl.authority.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ra_user_dept")
public class RaUserDept {
    /**
     * 主键
     */
    @Id
    @Column(name = "UD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String udId;

    /**
     * 用户编码
     */
    @Column(name = "UD_USER_NO")
    private String udUserNo;

    /**
     * 部门编码
     */
    @Column(name = "UD_DEPT_NO")
    private String udDeptNo;

    /**
     * 部门角色描述
     */
    @Column(name = "UD_DESCRIBE")
    private String udDescribe;

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
     * @return UD_ID - 主键
     */
    public String getUdId() {
        return udId;
    }

    /**
     * 设置主键
     *
     * @param udId 主键
     */
    public void setUdId(String udId) {
        this.udId = udId;
    }

    /**
     * 获取用户编码
     *
     * @return UD_USER_NO - 用户编码
     */
    public String getUdUserNo() {
        return udUserNo;
    }

    /**
     * 设置用户编码
     *
     * @param udUserNo 用户编码
     */
    public void setUdUserNo(String udUserNo) {
        this.udUserNo = udUserNo;
    }

    /**
     * 获取部门编码
     *
     * @return UD_DEPT_NO - 部门编码
     */
    public String getUdDeptNo() {
        return udDeptNo;
    }

    /**
     * 设置部门编码
     *
     * @param udDeptNo 部门编码
     */
    public void setUdDeptNo(String udDeptNo) {
        this.udDeptNo = udDeptNo;
    }

    /**
     * 获取部门角色描述
     *
     * @return UD_DESCRIBE - 部门角色描述
     */
    public String getUdDescribe() {
        return udDescribe;
    }

    /**
     * 设置部门角色描述
     *
     * @param udDescribe 部门角色描述
     */
    public void setUdDescribe(String udDescribe) {
        this.udDescribe = udDescribe;
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
}