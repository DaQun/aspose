package com.chenq.data.entity;

/**
 * Created by chenq on 2016/9/28.
 */
public class TbWgPollLinkPollFaci{
	//废气污染信息ID
	private String wGPollInfoID;
	//企业产污环节ID
	private String enteProdPollLinkID;
	//污染物种类
	private String pollTypeCode;
	//排放形式
	private Integer emisForm;
	//污染治理设施Id
	private String treaFaciID;
	//排放口id
	private String outletID;
	//生产设施（设备）ID
	private String prodFacilitiesID;
	//生产设施编号
	private String prodFaciNumber;
	//对应产污环节名称
	private String prodPollLinkName;
	//污染治理设施名称
	private String treaFaciName;
	//污染治理设施能力
	private Double treaFaciCapa;
	//有组织排放口编号
	private String outletNumber;
	//排放形式名称
	private String emisFormName;

	public String getwGPollInfoID() {
		return wGPollInfoID;
	}

	public void setwGPollInfoID(String wGPollInfoID) {
		this.wGPollInfoID = wGPollInfoID;
	}

	public String getEnteProdPollLinkID() {
		return enteProdPollLinkID;
	}

	public void setEnteProdPollLinkID(String enteProdPollLinkID) {
		this.enteProdPollLinkID = enteProdPollLinkID;
	}

	public String getPollTypeCode() {
		return pollTypeCode;
	}

	public void setPollTypeCode(String pollTypeCode) {
		this.pollTypeCode = pollTypeCode;
	}

	public Integer getEmisForm() {
		return emisForm;
	}

	public void setEmisForm(Integer emisForm) {
		this.emisForm = emisForm;
	}

	public String getTreaFaciID() {
		return treaFaciID;
	}

	public void setTreaFaciID(String treaFaciID) {
		this.treaFaciID = treaFaciID;
	}

	public String getOutletID() {
		return outletID;
	}

	public void setOutletID(String outletID) {
		this.outletID = outletID;
	}

	public String getProdFacilitiesID() {
		return prodFacilitiesID;
	}

	public void setProdFacilitiesID(String prodFacilitiesID) {
		this.prodFacilitiesID = prodFacilitiesID;
	}

	public String getProdFaciNumber() {
		return prodFaciNumber;
	}

	public void setProdFaciNumber(String prodFaciNumber) {
		this.prodFaciNumber = prodFaciNumber;
	}

	public String getProdPollLinkName() {
		return prodPollLinkName;
	}

	public void setProdPollLinkName(String prodPollLinkName) {
		this.prodPollLinkName = prodPollLinkName;
	}

	public String getTreaFaciName() {
		return treaFaciName;
	}

	public void setTreaFaciName(String treaFaciName) {
		this.treaFaciName = treaFaciName;
	}

	public Double getTreaFaciCapa() {
		return treaFaciCapa;
	}

	public void setTreaFaciCapa(Double treaFaciCapa) {
		this.treaFaciCapa = treaFaciCapa;
	}

	public String getOutletNumber() {
		return outletNumber;
	}

	public void setOutletNumber(String outletNumber) {
		this.outletNumber = outletNumber;
	}

	public String getEmisFormName() {
		return emisFormName;
	}

	public void setEmisFormName(String emisFormName) {
		this.emisFormName = emisFormName;
	}
}
