package com.zhwl.authority.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ra_user_role")
public class RaUserRole {
    /**
     * 主键
     */
    @Id
    @Column(name = "UR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String urId;

    /**
     * 用户编码
     */
    @Column(name = "UR_USER_NO")
    private String urUserNo;

    /**
     * 角色编码
     */
    @Column(name = "UR_ROLE_NO")
    private String urRoleNo;

    /**
     * 用户角色描述
     */
    @Column(name = "UR_DESCRIBE")
    private String urDescribe;

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
     * @return UR_ID - 主键
     */
    public String getUrId() {
        return urId;
    }

    /**
     * 设置主键
     *
     * @param urId 主键
     */
    public void setUrId(String urId) {
        this.urId = urId;
    }

    /**
     * 获取用户编码
     *
     * @return UR_USER_NO - 用户编码
     */
    public String getUrUserNo() {
        return urUserNo;
    }

    /**
     * 设置用户编码
     *
     * @param urUserNo 用户编码
     */
    public void setUrUserNo(String urUserNo) {
        this.urUserNo = urUserNo;
    }

    /**
     * 获取角色编码
     *
     * @return UR_ROLE_NO - 角色编码
     */
    public String getUrRoleNo() {
        return urRoleNo;
    }

    /**
     * 设置角色编码
     *
     * @param urRoleNo 角色编码
     */
    public void setUrRoleNo(String urRoleNo) {
        this.urRoleNo = urRoleNo;
    }

    /**
     * 获取用户角色描述
     *
     * @return UR_DESCRIBE - 用户角色描述
     */
    public String getUrDescribe() {
        return urDescribe;
    }

    /**
     * 设置用户角色描述
     *
     * @param urDescribe 用户角色描述
     */
    public void setUrDescribe(String urDescribe) {
        this.urDescribe = urDescribe;
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