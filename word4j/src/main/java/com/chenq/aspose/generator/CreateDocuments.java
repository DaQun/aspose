package com.chenq.aspose.generator;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import org.apache.log4j.Logger;

public class CreateDocuments {

	public void genAll() throws Exception {
		long time1 = System.currentTimeMillis();
		Document doc = genAllDocument();
		doc.save("C:\\Users\\chenq\\Desktop\\pics\\"+System.currentTimeMillis()+".pdf",SaveFormat.PDF);
//				.save("C:\\Users\\chenq\\Desktop\\pics\\zxxx.docx");
		long time2 = System.currentTimeMillis();
		System.out.println("文档生成,耗时:"+(time2 - time1) + "ms");
	}
	
	public Document genAllDocument() {
		return new DocBuilder.Builder()
				.build().getDoc();
	}
	
}
