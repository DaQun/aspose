package com.chenq.test;

import com.chenq.aspose.generator.GenHelper;
import com.chenq.aspose.generator.gen.GenEnviManaAccount;
import com.chenq.aspose.generator.gen.GenPermit;
import com.chenq.data.entity.EnviManaAccount;
import com.chenq.data.entity.Permit;
import org.junit.Test;

import java.util.List;

/**
 * Created by chenq on 2016/9/28.
 */
public class WordGenTest {
    @Test
    public void testForm() throws Exception {
        Permit permit = GenHelper.createTestData4Form(Permit.class);
        new GenPermit(permit).execute();
//        new DocBuilder.Builder().append(new GenPermit(permit));
    }

    @Test
    public void testTable() throws Exception {
        List<EnviManaAccount> list1 = GenHelper.createTestData4Table(EnviManaAccount.class);
        List<EnviManaAccount> list2 = GenHelper.createTestData4Table(EnviManaAccount.class);
        new GenEnviManaAccount(list1, list2).execute();
    }



}
