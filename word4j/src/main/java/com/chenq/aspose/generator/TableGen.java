package com.chenq.aspose.generator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aspose.words.Document;
/**
 * 表格模板生成
 * <p>需在word文档中插入文档部件MergeField</p>
 * @author chenq
 * 2016-9-3 下午11:08:34
 * @param <T>
 */
public abstract class TableGen<T> extends BaseGenerator{
	/**
	 * 在一行单元格中设置MergeField:<<TableStart:tableName>>,
	 * <<columnName1>>,<<columnName2>>...<<TableEnd:tableName>>
	 * @return 表格名
	 */
	protected abstract String getTableName();
	
	// 临时存放数据的map，防止多次查询
	protected Map<String, String> tempMap = new HashMap<String, String>();
	
	protected List<T> list;
	/**
	 * @param list 数据源
	 */
	public TableGen(List<T> list) {
		this.list = list;
	}
	/**
	 * @return
	 * @throws IOException
	 */
	protected List<Map<String, Object>> parseFormData() throws Exception {
		return parseFormData(list);
	}
	/**
	 * 一个表格有多个类别时，需要再次调用
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<Map<String, Object>> parseFormData(List<T> list) throws Exception {
		// list 为空时，提供一个空构造器的实体，将模板文件中的mergefield替换成空字符串
		if (list == null || list.isEmpty()) {
			list = new ArrayList<T>();
			Class<?> clazz = ReflectHelper.getSuperClassGenricType(this.getClass()); 
			T t = (T) clazz.newInstance();
			list.add(t);
		}
		
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = ReflectHelper.getEntityMap(list.get(i));
			map.put("order", i + 1);
			dataList.add(map);
		}
		return dataList;
	}
	
	/**
	 * 获取模板文件，并将数据填充到table中
	 * @return 
	 * @throws Exception 
	 * @throws IOException 
	 */
	public Document createDocument() throws Exception {
		Document doc = new Document(getTemplatePath());
		doc.getMailMerge().executeWithRegions(
				new MapMailMergeDataSource(parseFormData(), getTableName()));
		
		return doc;
	}
}
