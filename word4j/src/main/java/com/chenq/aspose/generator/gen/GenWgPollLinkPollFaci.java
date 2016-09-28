package com.chenq.aspose.generator.gen;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.chenq.aspose.generator.GenHelper;
import com.chenq.aspose.generator.TableGen;
import com.chenq.data.entity.TbWgPollLinkPollFaci;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by chenq on 2016/9/28.
 */
public class GenWgPollLinkPollFaci extends TableGen<TbWgPollLinkPollFaci> {
	private List<String> imgs ;
	public GenWgPollLinkPollFaci(List<TbWgPollLinkPollFaci> list,List<String> imgs) {
		super(list);
		this.imgs = imgs;
	}

	@Override
	protected String getTableName() {
		return "t_bas_wg_poll_link_poll_faci";
	}

	@Override
	protected String getTemplateName() {
		return "tableAndImage.docx";
	}



	@Override
	public Document createDocument() throws Exception {
		Document doc = super.createDocument();
		DocumentBuilder builder = new DocumentBuilder(doc);
		// 将输出位置移动到‘treaFlowDiag_Mark’书签位
		builder.moveToBookmark("treaFlowDiag_Mark");
		for(String img: imgs){
			String path = GenHelper.BOOT_PATH +img;
			File file = new File(path);
			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				builder.writeln("\n\n" + img);
				builder.insertImage(fis);
			}else{
				builder.writeln("\n\n图片：‘" + img + "’丢失！！！");
			}
		}
		return doc;
	}

	@Override
	protected List<Map<String, Object>> parseFormData() throws Exception {
		List<Map<String, Object>> data = super.parseFormData();
		for (Map<String, Object> map : data) {
			if (needParse(map.get("treaFaciCapa"))) {
				Double treaFaciCapa = (Double)map.get("treaFaciCapa");
				map.put("treaFaciCapa", treaFaciCapa+"%");
			}
		}
		return data;
	}
}