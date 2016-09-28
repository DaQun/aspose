package com.chenq.aspose.generator;

import java.util.List;

import com.aspose.words.Document;
/**
 * 表单里面嵌表格时使用
 * @author chenq
 * 2016-9-5 下午5:02:14
 * @param <T>
 */
public class CommonTable<T> extends TableGen<T>{
	
	private String tableName;
	private Document document;
	
	public CommonTable(List<T> list,String tableName,Document document) {
		super(list);
		this.tableName = tableName;
		this.document = document;
	}

	@Override
	public void execute() throws Exception {
		document.getMailMerge().executeWithRegions(
				new MapMailMergeDataSource(parseFormData(), getTableName()));
	}

	@Override
	protected String getTableName() {
		return this.tableName;
	}

	@Override
	protected String getTemplateName() {
		return null;
	}
}
