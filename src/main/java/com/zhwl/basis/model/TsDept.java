package com.zhwl.basis.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ts_dept")
public class TsDept {
    /**
     * 主键
     */
    @Id
    @Column(name = "DEPT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String deptId;

    /**
     * 编码
     */
    @Column(name = "DEPT_NO")
    private String deptNo;

    /**
     * 名称
     */
    @Column(name = "DEPT_NAME")
    private String deptName;

    /**
     * 父级编码
     */
    @Column(name = "DEPT_PARENT_NO")
    private String deptParentNo;

    /**
     * 父级名称
     */
    @Column(name = "DEPT_PARENT_NAME＿CN")
    private String deptParentName＿cn;

    /**
     * 级别
     */
    @Column(name = "DEPT_LEVER")
    private Integer deptLever;

    /**
     * 状态
     */
    @Column(name = "DEPT_STATUS")
    private Integer deptStatus;

    /**
     * 负责人编码
     */
    @Column(name = "DEPT_LEAD_NO")
    private String deptLeadNo;

    /**
     * 负责人名称
     */
    @Column(name = "DEPT_LEAD_NAME")
    private String deptLeadName;

    /**
     * 电话
     */
    @Column(name = "DEPT_TEL")
    private String deptTel;

    /**
     * 服务区域编码
     */
    @Column(name = "DEPT_AREA_NO")
    private String deptAreaNo;

    /**
     * 服务区名称
     */
    @Column(name = "DEPT_AREA_NAME")
    private String deptAreaName;

    /**
     * 上级服务区域编码
     */
    @Column(name = "DEPT_PRO_AREA_NO")
    private String deptProAreaNo;

    /**
     * 上级服务区域名称
     */
    @Column(name = "DEPT_PRO_AREA_NAME")
    private String deptProAreaName;

    /**
     * 所在省
     */
    @Column(name = "DEPT_PRIVERNCE")
    private String deptPrivernce;

    /**
     * 所在市
     */
    @Column(name = "DEPT_CITY")
    private String deptCity;

    /**
     * 所在区/县
     */
    @Column(name = "DEPT_DISTRICT")
    private String deptDistrict;

    /**
     * 详细地址
     */
    @Column(name = "DEPT_ADDRESS")
    private String deptAddress;

    /**
     * 经度
     */
    @Column(name = "DEPT_LON")
    private Double deptLon;

    /**
     * 经度
     */
    @Column(name = "DEPT_LAT")
    private Double deptLat;

    /**
     * 是否与上级服务区域合并区域
     */
    @Column(name = "DEPT_MEG_AREA")
    private Integer deptMegArea;

    /**
     * 保价费率
     */
    @Column(name = "DEPT_INSUR_RATE")
    private Double deptInsurRate;

    /**
     * 是否虚拟组织
     */
    @Column(name = "DEPT_VIRTUAL")
    private Integer deptVirtual;

    /**
     * 代收货款费率
     */
    @Column(name = "DEPT_COLLECT_RATE")
    private Double deptCollectRate;

    /**
     * 临欠额度
     */
    @Column(name = "DEPT_DEBT_AMOUNT")
    private Double deptDebtAmount;

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
     * @return DEPT_ID - 主键
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 设置主键
     *
     * @param deptId 主键
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取编码
     *
     * @return DEPT_NO - 编码
     */
    public String getDeptNo() {
        return deptNo;
    }

    /**
     * 设置编码
     *
     * @param deptNo 编码
     */
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    /**
     * 获取名称
     *
     * @return DEPT_NAME - 名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置名称
     *
     * @param deptName 名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取父级编码
     *
     * @return DEPT_PARENT_NO - 父级编码
     */
    public String getDeptParentNo() {
        return deptParentNo;
    }

    /**
     * 设置父级编码
     *
     * @param deptParentNo 父级编码
     */
    public void setDeptParentNo(String deptParentNo) {
        this.deptParentNo = deptParentNo;
    }

    /**
     * 获取父级名称
     *
     * @return DEPT_PARENT_NAME＿CN - 父级名称
     */
    public String getDeptParentName＿cn() {
        return deptParentName＿cn;
    }

    /**
     * 设置父级名称
     *
     * @param deptParentName＿cn 父级名称
     */
    public void setDeptParentName＿cn(String deptParentName＿cn) {
        this.deptParentName＿cn = deptParentName＿cn;
    }

    /**
     * 获取级别
     *
     * @return DEPT_LEVER - 级别
     */
    public Integer getDeptLever() {
        return deptLever;
    }

    /**
     * 设置级别
     *
     * @param deptLever 级别
     */
    public void setDeptLever(Integer deptLever) {
        this.deptLever = deptLever;
    }

    /**
     * 获取状态
     *
     * @return DEPT_STATUS - 状态
     */
    public Integer getDeptStatus() {
        return deptStatus;
    }

    /**
     * 设置状态
     *
     * @param deptStatus 状态
     */
    public void setDeptStatus(Integer deptStatus) {
        this.deptStatus = deptStatus;
    }

    /**
     * 获取负责人编码
     *
     * @return DEPT_LEAD_NO - 负责人编码
     */
    public String getDeptLeadNo() {
        return deptLeadNo;
    }

    /**
     * 设置负责人编码
     *
     * @param deptLeadNo 负责人编码
     */
    public void setDeptLeadNo(String deptLeadNo) {
        this.deptLeadNo = deptLeadNo;
    }

    /**
     * 获取负责人名称
     *
     * @return DEPT_LEAD_NAME - 负责人名称
     */
    public String getDeptLeadName() {
        return deptLeadName;
    }

    /**
     * 设置负责人名称
     *
     * @param deptLeadName 负责人名称
     */
    public void setDeptLeadName(String deptLeadName) {
        this.deptLeadName = deptLeadName;
    }

    /**
     * 获取电话
     *
     * @return DEPT_TEL - 电话
     */
    public String getDeptTel() {
        return deptTel;
    }

    /**
     * 设置电话
     *
     * @param deptTel 电话
     */
    public void setDeptTel(String deptTel) {
        this.deptTel = deptTel;
    }

    /**
     * 获取服务区域编码
     *
     * @return DEPT_AREA_NO - 服务区域编码
     */
    public String getDeptAreaNo() {
        return deptAreaNo;
    }

    /**
     * 设置服务区域编码
     *
     * @param deptAreaNo 服务区域编码
     */
    public void setDeptAreaNo(String deptAreaNo) {
        this.deptAreaNo = deptAreaNo;
    }

    /**
     * 获取服务区名称
     *
     * @return DEPT_AREA_NAME - 服务区名称
     */
    public String getDeptAreaName() {
        return deptAreaName;
    }

    /**
     * 设置服务区名称
     *
     * @param deptAreaName 服务区名称
     */
    public void setDeptAreaName(String deptAreaName) {
        this.deptAreaName = deptAreaName;
    }

    /**
     * 获取上级服务区域编码
     *
     * @return DEPT_PRO_AREA_NO - 上级服务区域编码
     */
    public String getDeptProAreaNo() {
        return deptProAreaNo;
    }

    /**
     * 设置上级服务区域编码
     *
     * @param deptProAreaNo 上级服务区域编码
     */
    public void setDeptProAreaNo(String deptProAreaNo) {
        this.deptProAreaNo = deptProAreaNo;
    }

    /**
     * 获取上级服务区域名称
     *
     * @return DEPT_PRO_AREA_NAME - 上级服务区域名称
     */
    public String getDeptProAreaName() {
        return deptProAreaName;
    }

    /**
     * 设置上级服务区域名称
     *
     * @param deptProAreaName 上级服务区域名称
     */
    public void setDeptProAreaName(String deptProAreaName) {
        this.deptProAreaName = deptProAreaName;
    }

    /**
     * 获取所在省
     *
     * @return DEPT_PRIVERNCE - 所在省
     */
    public String getDeptPrivernce() {
        return deptPrivernce;
    }

    /**
     * 设置所在省
     *
     * @param deptPrivernce 所在省
     */
    public void setDeptPrivernce(String deptPrivernce) {
        this.deptPrivernce = deptPrivernce;
    }

    /**
     * 获取所在市
     *
     * @return DEPT_CITY - 所在市
     */
    public String getDeptCity() {
        return deptCity;
    }

    /**
     * 设置所在市
     *
     * @param deptCity 所在市
     */
    public void setDeptCity(String deptCity) {
        this.deptCity = deptCity;
    }

    /**
     * 获取所在区/县
     *
     * @return DEPT_DISTRICT - 所在区/县
     */
    public String getDeptDistrict() {
        return deptDistrict;
    }

    /**
     * 设置所在区/县
     *
     * @param deptDistrict 所在区/县
     */
    public void setDeptDistrict(String deptDistrict) {
        this.deptDistrict = deptDistrict;
    }

    /**
     * 获取详细地址
     *
     * @return DEPT_ADDRESS - 详细地址
     */
    public String getDeptAddress() {
        return deptAddress;
    }

    /**
     * 设置详细地址
     *
     * @param deptAddress 详细地址
     */
    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    /**
     * 获取经度
     *
     * @return DEPT_LON - 经度
     */
    public Double getDeptLon() {
        return deptLon;
    }

    /**
     * 设置经度
     *
     * @param deptLon 经度
     */
    public void setDeptLon(Double deptLon) {
        this.deptLon = deptLon;
    }

    /**
     * 获取经度
     *
     * @return DEPT_LAT - 经度
     */
    public Double getDeptLat() {
        return deptLat;
    }

    /**
     * 设置经度
     *
     * @param deptLat 经度
     */
    public void setDeptLat(Double deptLat) {
        this.deptLat = deptLat;
    }

    /**
     * 获取是否与上级服务区域合并区域
     *
     * @return DEPT_MEG_AREA - 是否与上级服务区域合并区域
     */
    public Integer getDeptMegArea() {
        return deptMegArea;
    }

    /**
     * 设置是否与上级服务区域合并区域
     *
     * @param deptMegArea 是否与上级服务区域合并区域
     */
    public void setDeptMegArea(Integer deptMegArea) {
        this.deptMegArea = deptMegArea;
    }

    /**
     * 获取保价费率
     *
     * @return DEPT_INSUR_RATE - 保价费率
     */
    public Double getDeptInsurRate() {
        return deptInsurRate;
    }

    /**
     * 设置保价费率
     *
     * @param deptInsurRate 保价费率
     */
    public void setDeptInsurRate(Double deptInsurRate) {
        this.deptInsurRate = deptInsurRate;
    }

    /**
     * 获取是否虚拟组织
     *
     * @return DEPT_VIRTUAL - 是否虚拟组织
     */
    public Integer getDeptVirtual() {
        return deptVirtual;
    }

    /**
     * 设置是否虚拟组织
     *
     * @param deptVirtual 是否虚拟组织
     */
    public void setDeptVirtual(Integer deptVirtual) {
        this.deptVirtual = deptVirtual;
    }

    /**
     * 获取代收货款费率
     *
     * @return DEPT_COLLECT_RATE - 代收货款费率
     */
    public Double getDeptCollectRate() {
        return deptCollectRate;
    }

    /**
     * 设置代收货款费率
     *
     * @param deptCollectRate 代收货款费率
     */
    public void setDeptCollectRate(Double deptCollectRate) {
        this.deptCollectRate = deptCollectRate;
    }

    /**
     * 获取临欠额度
     *
     * @return DEPT_DEBT_AMOUNT - 临欠额度
     */
    public Double getDeptDebtAmount() {
        return deptDebtAmount;
    }

    /**
     * 设置临欠额度
     *
     * @param deptDebtAmount 临欠额度
     */
    public void setDeptDebtAmount(Double deptDebtAmount) {
        this.deptDebtAmount = deptDebtAmount;
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