package com.chenq.aspose.generator.gen;



import com.chenq.aspose.generator.FormGen;
import com.chenq.aspose.generator.GenHelper;
import com.chenq.data.entity.Permit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成:排污许可证申请表（样本)
 * @author chenq
 * 2016-9-3 下午3:51:13
 */
public class GenPermit extends FormGen<Permit> {
	
	public GenPermit(Permit entity) {
		super(entity);
	}
	
	private static final HashMap<String, Object> PARAM = new HashMap<String, Object>();
	static {
		PARAM.put("as_1", GenHelper.uncheck);
		PARAM.put("as_2", GenHelper.uncheck);
		PARAM.put("as_3", GenHelper.uncheck);
		PARAM.put("pc_1", GenHelper.uncheck);
		PARAM.put("pc_2", GenHelper.uncheck);
		PARAM.put("pc_3", GenHelper.uncheck);
	}
	
	@Override
	protected Map<String, Object> parseFormData() {
		Map<String, Object> datas = super.parseFormData();
		datas.putAll(PARAM);
		/** 首次申请/延续/变更*/
		datas.put("as_" + datas.get("applyStatus"), GenHelper.check);
		/** 许可证类别*/
		datas.put("pc_" + datas.get("permitCate"), GenHelper.check);
		/** 申请日期*/
		String date = "";
		if (needParse(datas.get("applyDate"))) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
			Date applyDate = (Date) datas.get("applyDate");
			if (applyDate != null) {
				date = dateFormat.format(applyDate);
			}
		}
		datas.put("applyDate", date);
		
		return datas;
	}

	@Override
	protected String getTemplateName() {
		return "form.docx";
	}

}
