package com.zhwl.basis.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ts_resource")
public class TsResource {
    /**
     * 主键
     */
    @Id
    @Column(name = "RES_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String resId;

    /**
     * 资源编码
     */
    @Column(name = "RES_NO")
    private String resNo;

    /**
     * 名称
     */
    @Column(name = "RES_NAME")
    private String resName;

    /**
     * 父级资源编码
     */
    @Column(name = "RES_PARENT_NO")
    private String resParentNo;

    /**
     * 父级资源名称
     */
    @Column(name = "RES_PARENT_NAME")
    private String resParentName;

    /**
     * 路径
     */
    @Column(name = "RES_URL")
    private String resUrl;

    /**
     * 类型
     */
    @Column(name = "RES_TYPE")
    private Integer resType;

    /**
     * 状态
     */
    @Column(name = "RES_STATUS")
    private Integer resStatus;

    /**
     * 权限项
     */
    @Column(name = "RES_PERMISSION")
    private String resPermission;

    /**
     * 图标
     */
    @Column(name = "RES_ICONCLS")
    private String resIconcls;

    /**
     * 描述
     */
    @Column(name = "RES_DESCRIBE")
    private String resDescribe;

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
     * @return RES_ID - 主键
     */
    public String getResId() {
        return resId;
    }

    /**
     * 设置主键
     *
     * @param resId 主键
     */
    public void setResId(String resId) {
        this.resId = resId;
    }

    /**
     * 获取资源编码
     *
     * @return RES_NO - 资源编码
     */
    public String getResNo() {
        return resNo;
    }

    /**
     * 设置资源编码
     *
     * @param resNo 资源编码
     */
    public void setResNo(String resNo) {
        this.resNo = resNo;
    }

    /**
     * 获取名称
     *
     * @return RES_NAME - 名称
     */
    public String getResName() {
        return resName;
    }

    /**
     * 设置名称
     *
     * @param resName 名称
     */
    public void setResName(String resName) {
        this.resName = resName;
    }

    /**
     * 获取父级资源编码
     *
     * @return RES_PARENT_NO - 父级资源编码
     */
    public String getResParentNo() {
        return resParentNo;
    }

    /**
     * 设置父级资源编码
     *
     * @param resParentNo 父级资源编码
     */
    public void setResParentNo(String resParentNo) {
        this.resParentNo = resParentNo;
    }

    /**
     * 获取父级资源名称
     *
     * @return RES_PARENT_NAME - 父级资源名称
     */
    public String getResParentName() {
        return resParentName;
    }

    /**
     * 设置父级资源名称
     *
     * @param resParentName 父级资源名称
     */
    public void setResParentName(String resParentName) {
        this.resParentName = resParentName;
    }

    /**
     * 获取路径
     *
     * @return RES_URL - 路径
     */
    public String getResUrl() {
        return resUrl;
    }

    /**
     * 设置路径
     *
     * @param resUrl 路径
     */
    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    /**
     * 获取类型
     *
     * @return RES_TYPE - 类型
     */
    public Integer getResType() {
        return resType;
    }

    /**
     * 设置类型
     *
     * @param resType 类型
     */
    public void setResType(Integer resType) {
        this.resType = resType;
    }

    /**
     * 获取状态
     *
     * @return RES_STATUS - 状态
     */
    public Integer getResStatus() {
        return resStatus;
    }

    /**
     * 设置状态
     *
     * @param resStatus 状态
     */
    public void setResStatus(Integer resStatus) {
        this.resStatus = resStatus;
    }

    /**
     * 获取权限项
     *
     * @return RES_PERMISSION - 权限项
     */
    public String getResPermission() {
        return resPermission;
    }

    /**
     * 设置权限项
     *
     * @param resPermission 权限项
     */
    public void setResPermission(String resPermission) {
        this.resPermission = resPermission;
    }

    /**
     * 获取图标
     *
     * @return RES_ICONCLS - 图标
     */
    public String getResIconcls() {
        return resIconcls;
    }

    /**
     * 设置图标
     *
     * @param resIconcls 图标
     */
    public void setResIconcls(String resIconcls) {
        this.resIconcls = resIconcls;
    }

    /**
     * 获取描述
     *
     * @return RES_DESCRIBE - 描述
     */
    public String getResDescribe() {
        return resDescribe;
    }

    /**
     * 设置描述
     *
     * @param resDescribe 描述
     */
    public void setResDescribe(String resDescribe) {
        this.resDescribe = resDescribe;
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