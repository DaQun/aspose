package com.chenq.aspose.generator;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenHelper {
	public static final String check  = "☑";
	public static final String uncheck  = "□";

	public static final String BOOT_PATH;
	static {
		// replace替换文件中的'%20'为空格,substring去掉开头的'/'
		BOOT_PATH = GenHelper.class.getClassLoader().getResource("").getPath().replace("%20", " ").substring(1);
	}

    /**
     * 千分位,以及格式化
     * @param text
     * @param scale
     * @return
     */
	public static String format(String text, int scale) {
		String format = "###,##0";
		if (text.indexOf(".") > 0) {
			format += ".";
			for (int i=0;i<scale;i++) {
				format += "0";
			}
		} 
		DecimalFormat df = new DecimalFormat(format);
		try {
			return df.format(Double.parseDouble(text));
		} catch (Exception e) {
			return "0";
		}
	}
	
	/**
	 * 将小数类型的经纬度转换成度分秒经纬度
	 */
	public static String conventlongiLatiTude(double value) {
		Double v1 = Math.floor(value);
		double v = (value - v1) * 60;
		Double v2 = Math.floor(v);
		Double v3 = (v - v2) * 60;
		v3 = Math.rint(v3);
		return v1.intValue() + "°" + v2.intValue() + "′" + v3.intValue() + "″";
	}
	
	/**
	 * 模拟测试数据
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> createTestData4Table(Class<T> clazz) {
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < 10; i++) {
			T t = null;
			try {
				t = createTestData4Form(clazz);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(t);
		}

		return list;
	}

	public static <T> T createTestData4Form(Class<T> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		T t = null;
		try {
			t = clazz.newInstance();
			int i = 0;
			for (Field field : fields) {
				i++;
				field.setAccessible(true);
				Type type = field.getGenericType();
				// 如果类型是String
				if (type.toString().equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
					field.set(t, field.getName() + i);
				}
				// 如果类型是Integer
				if (type.toString().equals("class java.lang.Integer")) {
					field.set(t, i);
				}
				// 如果类型是Double
				if (type.toString().equals("class java.lang.Double")) {
					field.set(t, new Double(i + 1));
				}
				// 如果类型是Date
				if (type.toString().equals("class java.util.Date")) {
					field.set(t, new Date());
				}
				// 如果类型是Boolean 是封装类
				if (type.toString().equals("class java.lang.Boolean")) {
					field.set(t, i % 2 == 0 ? false : true);
				}
				// 如果类型是Short
				if (type.toString().equals("class java.lang.Short")) {
					field.set(t, (short) i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}
