package com.chenq.data.entity;

/**
 * 环境管理台账信息
 * @author chenq
 * 2016-8-12 下午5:08:43
 */
public class EnviManaAccount{
	private String enviManaAccountingID; // 环境管理台帐信息ID
	private String enteID; // 企业ID
	private String ix; // 序号
	private String faciType; // 设施类别
	private String operParam; // 操作参数
	private String recordContent; // 记录内容
	private String recordFrequency; // 记录频次
	private String recordForm; // 记录形式

	public String getEnviManaAccountingID() {
		return enviManaAccountingID;
	}

	public void setEnviManaAccountingID(String enviManaAccountingID) {
		this.enviManaAccountingID = enviManaAccountingID;
	}

	public String getEnteID() {
		return enteID;
	}

	public void setEnteID(String enteID) {
		this.enteID = enteID;
	}

	public String getIx() {
		return ix;
	}

	public void setIx(String ix) {
		this.ix = ix;
	}

	public String getFaciType() {
		return faciType;
	}

	public void setFaciType(String faciType) {
		this.faciType = faciType;
	}

	public String getOperParam() {
		return operParam;
	}

	public void setOperParam(String operParam) {
		this.operParam = operParam;
	}

	public String getRecordContent() {
		return recordContent;
	}

	public void setRecordContent(String recordContent) {
		this.recordContent = recordContent;
	}

	public String getRecordFrequency() {
		return recordFrequency;
	}

	public void setRecordFrequency(String recordFrequency) {
		this.recordFrequency = recordFrequency;
	}

	public String getRecordForm() {
		return recordForm;
	}

	public void setRecordForm(String recordForm) {
		this.recordForm = recordForm;
	}
}
