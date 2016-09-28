package com.chenq.aspose.generator;

import java.util.Map;

import com.aspose.words.Document;

public abstract class FormGen<T> extends BaseGenerator {
	
	protected T entity;
	
	/**
	 * 将对象的属性和值转换成Map，填充表单
	 * @return
	 */
	protected Map<String, Object> parseFormData() {
		return parseFormData(entity);
	}
	
	protected Map<String, Object> parseFormData(T t) {
		// 查询不到实体时，默认提供一个空构造器的实体类，将文档中的占位符替换成空字符串
		if (t == null) {
			@SuppressWarnings("unchecked")
			Class<T> clazz = ReflectHelper.getSuperClassGenricType(this.getClass());
			try {
				t = clazz.newInstance();
			} catch (Exception e) {
				logger.warn(e);
			} 
		}
		return ReflectHelper.getEntityMap(t);
	}

	public Document createDocument() {
		return replaceDocTem(parseFormData());
	}
	/**
	 * 构造器
	 * @param entity 数据源
	 */
	public FormGen(T entity) {
		this.entity = entity;
	}
	
}
