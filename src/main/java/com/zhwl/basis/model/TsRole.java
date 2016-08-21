package com.zhwl.basis.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ts_role")
public class TsRole {
    /**
     * 主键
     */
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String roleId;

    /**
     * 角色编码
     */
    @Column(name = "ROLE_NO")
    private String roleNo;

    /**
     * 名称
     */
    @Column(name = "ROLE_NAME")
    private String roleName;

    /**
     * 状态
     */
    @Column(name = "ROLE_STATUS")
    private Integer roleStatus;

    /**
     * 角色描述
     */
    @Column(name = "ROLE_DESCRIBE")
    private String roleDescribe;

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
     * @return ROLE_ID - 主键
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置主键
     *
     * @param roleId 主键
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色编码
     *
     * @return ROLE_NO - 角色编码
     */
    public String getRoleNo() {
        return roleNo;
    }

    /**
     * 设置角色编码
     *
     * @param roleNo 角色编码
     */
    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    /**
     * 获取名称
     *
     * @return ROLE_NAME - 名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置名称
     *
     * @param roleName 名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取状态
     *
     * @return ROLE_STATUS - 状态
     */
    public Integer getRoleStatus() {
        return roleStatus;
    }

    /**
     * 设置状态
     *
     * @param roleStatus 状态
     */
    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    /**
     * 获取角色描述
     *
     * @return ROLE_DESCRIBE - 角色描述
     */
    public String getRoleDescribe() {
        return roleDescribe;
    }

    /**
     * 设置角色描述
     *
     * @param roleDescribe 角色描述
     */
    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
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