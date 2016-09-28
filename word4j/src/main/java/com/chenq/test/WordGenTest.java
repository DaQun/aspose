package com.chenq.test;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import com.chenq.aspose.generator.DocBuilder;
import com.chenq.aspose.generator.GenHelper;
import com.chenq.aspose.generator.ImageGen;
import com.chenq.aspose.generator.gen.GenEnviManaAccount;
import com.chenq.aspose.generator.gen.GenPermit;
import com.chenq.aspose.generator.gen.GenWgPollLinkPollFaci;
import com.chenq.data.entity.EnviManaAccount;
import com.chenq.data.entity.Permit;
import com.chenq.data.entity.TbWgPollLinkPollFaci;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenq on 2016/9/28.
 */
public class WordGenTest {
    @Test
    public void testForm() throws Exception {
        Permit permit = GenHelper.createTestData4Form(Permit.class);
		new GenPermit(permit).execute();
    }

    @Test
    public void testTable() throws Exception {
        List<EnviManaAccount> list1 = GenHelper.createTestData4Table(EnviManaAccount.class);
        List<EnviManaAccount> list2 = GenHelper.createTestData4Table(EnviManaAccount.class);
        new GenEnviManaAccount(list1, list2).execute();
    }

	@Test
	public void testImage() throws Exception {
		String path = GenHelper.BOOT_PATH;
		path += "image/1.png";
		System.out.println(path);
		new ImageGen(path).execute();
	}

	@Test
	public void testTableAndImg() throws Exception {
		List<TbWgPollLinkPollFaci> list = GenHelper.createTestData4Table(TbWgPollLinkPollFaci.class);
		List<String> imgs = new ArrayList<String>();
		imgs.add("image/2.jpg");
		imgs.add("image/3.jpg"); // 不存在

		new GenWgPollLinkPollFaci(list, imgs).execute();
	}

	@Test
	public void genAllDocument() throws Exception {
		Document doc = new DocBuilder.Builder()
				.append(genForm())
				.append(genTable())
				.append(genImage())
				.append(genTableAndImg())
				.build().getDoc();
		doc.save("D://wordExport//all2.pdf", SaveFormat.PDF);
	}

	private Document genForm() {
		Permit permit = GenHelper.createTestData4Form(Permit.class);
		return new GenPermit(permit).returnDoc();
	}

	private Document genTable() {
		List<EnviManaAccount> list1 = GenHelper.createTestData4Table(EnviManaAccount.class);
		List<EnviManaAccount> list2 = GenHelper.createTestData4Table(EnviManaAccount.class);
		return new GenEnviManaAccount(list1, list2).returnDoc();
	}

	private Document genImage() {
		String path = GenHelper.BOOT_PATH;
		path += "image/1.png";
		System.out.println(path);
		return new ImageGen(path).returnDoc();
	}

	public Document genTableAndImg()  {
		List<TbWgPollLinkPollFaci> list = GenHelper.createTestData4Table(TbWgPollLinkPollFaci.class);
		List<String> imgs = new ArrayList<String>();
		imgs.add("image/2.jpg");
		imgs.add("image/3.jpg"); // 不存在

		return new GenWgPollLinkPollFaci(list, imgs).returnDoc();
	}
}
