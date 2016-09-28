package com.chenq.data.entity;

import java.util.Date;

/**
 * Created by chenq on 2016/9/28.
 */
public class Permit {
    //企业名称
    private String enteName;
    //注册地址
    private String regAdress;
    //行业类别
    private String indTypeCode;
    //行业类别名称
    private String indTypeCodeName;
    //生产经营场所地址
    private String prodBusiAdd;
    //组织机构代码
    private String orgCode;
    //统一社会信用代码
    private String creditCode;
    //法定代表人
    private String legalPerson;
    //负责工程师-角色-人员名称
    private String staffName;
    //工程师固定电话
    private String fixedlineTele;
    //工程师移动电话
    private String contact;

    public String getDiscPermitEncodOut() {
        return discPermitEncodOut;
    }

    public void setDiscPermitEncodOut(String discPermitEncodOut) {
        this.discPermitEncodOut = discPermitEncodOut;
    }

    private String discPermitEncodOut;
    /**
     * 申请状态- 1首次，2延续 3变更
     */
    private String applyStatus;
    /**
     * 申请类别：1特种 2普通 3登记
     */
    private String permitCate;
    /**
     * 申请日期
     */
    private Date applyDate;

    public String getEnteName() {
        return enteName;
    }

    public void setEnteName(String enteName) {
        this.enteName = enteName;
    }

    public String getRegAdress() {
        return regAdress;
    }

    public void setRegAdress(String regAdress) {
        this.regAdress = regAdress;
    }

    public String getIndTypeCode() {
        return indTypeCode;
    }

    public void setIndTypeCode(String indTypeCode) {
        this.indTypeCode = indTypeCode;
    }

    public String getIndTypeCodeName() {
        return indTypeCodeName;
    }

    public void setIndTypeCodeName(String indTypeCodeName) {
        this.indTypeCodeName = indTypeCodeName;
    }

    public String getProdBusiAdd() {
        return prodBusiAdd;
    }

    public void setProdBusiAdd(String prodBusiAdd) {
        this.prodBusiAdd = prodBusiAdd;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getFixedlineTele() {
        return fixedlineTele;
    }

    public void setFixedlineTele(String fixedlineTele) {
        this.fixedlineTele = fixedlineTele;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getPermitCate() {
        return permitCate;
    }

    public void setPermitCate(String permitCate) {
        this.permitCate = permitCate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}
