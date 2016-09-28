package com.chenq.aspose.generator;

import java.io.File;
import java.io.FileInputStream;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;

public class ImageGen extends BaseGenerator{
	
	private FileInputStream fis;
	
	@Override
	protected String getTemplateName() {
		return "empty.docx";
	}
	
	public ImageGen(String imagePath) {
		try{
			File file = new File(imagePath);
			if (file.exists()) {
				this.fis = new FileInputStream(file);
			}
		} catch (Exception e) {
			logger.warn(e);
		}
	}
	
	public ImageGen(FileInputStream fis) {
		this.fis = fis;
	}
	public ImageGen() {}

	@Override
	public Document createDocument() throws Exception {
		Document doc = new Document(getTemplatePath());
		DocumentBuilder b = new DocumentBuilder(doc);
		if (fis != null) {
			b.insertImage(fis);
		} else {
			b.writeln("上传资料缺失！");
		}
		return doc;
	}

}
