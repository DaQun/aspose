package com.chenq.aspose.generator;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.aspose.words.Document;
import com.aspose.words.License;

public abstract class BaseGenerator {
	
	protected final static Logger logger = Logger.getLogger(BaseGenerator.class);
	// 模板文件存放目录
//	private final String TEMPLATE_PATH = "C:/Users/chenq/Desktop/aspose生成模板/";
	private final String TEMPLATE_PATH = "wordTemplate/";
	// 生成文件输出目录
	private final String OUT_PATH = "D:/wordExport/";
	// 替换符
	private final String PREFIX  = "$"; 
	private final String SUFFIX  = "$";
	
	/**
	 * 初始化获取证书
	 * 默认没有license,会有水印文字  
	 */
	static {
		try {
			InputStream is = BaseGenerator.class.getClassLoader().getResourceAsStream("\\license.xml");
			new License().setLicense(is);
		} catch (Exception e) {
			logger.warn("获取ASPOSE证书失败",e);
		}
	}
	/**
	 * 模板文件名称
	 * @return
	 */
	protected abstract String getTemplateName();
	
	/**
	 * 输出文件名称
	 */
	protected String getExportName() {
		return System.currentTimeMillis() + "--" + getTemplateName();
	}
	/**
	 * 模板文件路径
	 */
	protected String getTemplatePath() {
		String path = TEMPLATE_PATH + getTemplateName();
		path = GenHelper.BOOT_PATH + path;
		return path;
	}
	/**
	 * 输出文件路径
	 */
	protected String getExportPath() {
		return OUT_PATH + getExportName();
	}
	/**
	 * 生成文件,覆写方法时,最后一定要调用Document.save方法
	 * @throws Exception
	 */
	public void execute() throws Exception {
		createDocument().save(getExportPath());
	}
	
	public Document returnDoc() {
		Document doc = null;
		try {
			doc = createDocument();
		} catch (Exception e) {
			logger.warn("ASPOSE.WORD Document 生成失败", e);
		}
		return doc;
	}
	
	protected abstract Document createDocument() throws Exception;
	
	 /** 
     * 替换内容的主要操作 
     * @param datas 数据
     */  
	protected Document replaceDocTem(Map<String, Object> datas) {
		return replaceDocTem(datas, null);
	}
	
	protected Document replaceDocTem(Map<String, Object> datas, Document doc) {
		try {
			if (doc == null) {
				doc = new Document(getTemplatePath());
			}
			// 遍历要替换的内容
			Iterator<String> keys = datas.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				String value = String.valueOf(datas.get(key));
				value = StringUtils.defaultIfEmpty(value, "").replaceAll("\n\n", "" + (char) 11);//替换换行符
				// 要求替换的内容是完全匹配时的替换
				doc.getRange().replace(wrap(key), value, true, false);
			}
		} catch (Exception e) {
			logger.warn("替换文件模板失败", e);
		}

		return doc;
	}
	
	
	protected String wrap(String property) {
		return PREFIX + property + SUFFIX;
	}
	
	protected boolean needParse(Object obj) {
		if(obj == null || StringUtils.isEmpty(obj + "")) {
			return false;
		}
		return true;
	}
	/**
	 * 仅在知道该类型为double时使用
	 * @param obj
	 * @return
	 */
	protected boolean needParseDouble(Object obj) {
		if (needParse(obj) && (Double) obj != 0d) {
			return true;
		}
		return false;
	}
}
