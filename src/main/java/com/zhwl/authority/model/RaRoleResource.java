package com.zhwl.authority.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ra_role_resource")
public class RaRoleResource {
    /**
     * 主键
     */
    @Id
    @Column(name = "RR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String rrId;

    /**
     * 角色编码
     */
    @Column(name = "RR_ROLE_NO")
    private String rrRoleNo;

    /**
     * 资源编码
     */
    @Column(name = "RR_RESOURCE_NO")
    private String rrResourceNo;

    /**
     * 角色资源描述
     */
    @Column(name = "RR_DESCRIBE")
    private String rrDescribe;

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
     * @return RR_ID - 主键
     */
    public String getRrId() {
        return rrId;
    }

    /**
     * 设置主键
     *
     * @param rrId 主键
     */
    public void setRrId(String rrId) {
        this.rrId = rrId;
    }

    /**
     * 获取角色编码
     *
     * @return RR_ROLE_NO - 角色编码
     */
    public String getRrRoleNo() {
        return rrRoleNo;
    }

    /**
     * 设置角色编码
     *
     * @param rrRoleNo 角色编码
     */
    public void setRrRoleNo(String rrRoleNo) {
        this.rrRoleNo = rrRoleNo;
    }

    /**
     * 获取资源编码
     *
     * @return RR_RESOURCE_NO - 资源编码
     */
    public String getRrResourceNo() {
        return rrResourceNo;
    }

    /**
     * 设置资源编码
     *
     * @param rrResourceNo 资源编码
     */
    public void setRrResourceNo(String rrResourceNo) {
        this.rrResourceNo = rrResourceNo;
    }

    /**
     * 获取角色资源描述
     *
     * @return RR_DESCRIBE - 角色资源描述
     */
    public String getRrDescribe() {
        return rrDescribe;
    }

    /**
     * 设置角色资源描述
     *
     * @param rrDescribe 角色资源描述
     */
    public void setRrDescribe(String rrDescribe) {
        this.rrDescribe = rrDescribe;
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