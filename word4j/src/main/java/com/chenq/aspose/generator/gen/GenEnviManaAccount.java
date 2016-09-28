package com.chenq.aspose.generator.gen;

import com.aspose.words.*;
import com.chenq.aspose.generator.MapMailMergeDataSource;
import com.chenq.aspose.generator.TableGen;
import com.chenq.data.entity.EnviManaAccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 6-2 环境管理台账信息表
 *
 * @author chenq
 *         2016-9-6 上午11:59:54
 */
public class GenEnviManaAccount extends TableGen<EnviManaAccount> {
	// 污染防治
	private List<EnviManaAccount> reduceList;

	/**
	 * @param productList 生产设施
	 * @param reduceList  污染防治设施
	 */
	public GenEnviManaAccount(List<EnviManaAccount> productList, List<EnviManaAccount> reduceList) {
		super(productList);
		this.reduceList = reduceList;
	}

	@Override
	protected String getTableName() {
		return "productEnviManaAccount";
	}

	@Override
	protected String getTemplateName() {
		return "table.docx";
	}

	private static final Map<String, String> PARAMS = new HashMap<String, String>();

	static {
		// 生产参数
		PARAMS.put("0_1", "生产运行参数");
		PARAMS.put("0_2", "原、燃、辅料数据");
		PARAMS.put("0_3", "其他");
		// 防污设施参数
		PARAMS.put("1_1", "污染防治设施运行参数");
		PARAMS.put("1_2", "污染防治设置药剂参数");
		PARAMS.put("1_3", "污染物监测参数");
		PARAMS.put("1_4", "DCS曲线");
		PARAMS.put("1_5", "实际排放量核算数据");
		PARAMS.put("1_6", "其他");
		// 记录形式
		PARAMS.put("1", "电子台账");
		PARAMS.put("2", "纸质台账");
		PARAMS.put("3", "其他");
	}

	@Override
	public Document createDocument() throws Exception {
		Document doc = super.createDocument();
		doc.getMailMerge().executeWithRegions(
				new MapMailMergeDataSource(parseFormData(reduceList), "reduceEnviManaAccount"));

		try {
			// 合并单元格操作
			Table table = (Table) doc.getChild(NodeType.TABLE, 0, true);
			RowCollection rows = table.getRows();
			int rowStartIndex = 1;
			for (int i = 2; i < rows.getCount(); i++) {
				Row row = rows.get(i);
				Row preRow = rows.get(i - 1);
				if (row.getCells().get(1).getText().equals(preRow.getCells().get(1).getText())) {
					rows.get(rowStartIndex).getCells().get(1)
							.getCellFormat().setVerticalMerge(CellMerge.FIRST);
					rows.get(i).getCells().get(1).getCellFormat()
							.setVerticalMerge(CellMerge.PREVIOUS);
				} else {
					rowStartIndex = i;
				}
			}
		} catch (Exception e) {
			logger.warn(e);
		}

		return doc;
	}

	@Override
	protected List<Map<String, Object>> parseFormData(List<EnviManaAccount> list)
			throws Exception {
		List<Map<String, Object>> data = super.parseFormData(list);
		for (Map<String, Object> map : data) {
			/** 操作参数*/
			String operParamKey = (String) map.get("operParam");
			String operParamValue = PARAMS.get(map.get("faciType") + "_"
					+ operParamKey);
			map.put("operParam", operParamValue);
			/** 记录形式*/
			String recordForm = (String) map.get("recordForm");
			map.put("recordForm", PARAMS.get(recordForm));
		}
		return data;
	}

}
