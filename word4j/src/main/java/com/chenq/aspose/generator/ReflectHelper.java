package com.chenq.aspose.generator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ReflectHelper {

	/**
	 * 将一个类查询方式加入map（属性值为int型时，0时不加入， 属性值为String型或Long时为null和“”不加入）
	 */
	public static Map<String, Object> getEntityMap(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj == null) {
			return null;
		}
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			Object fieldValue = getValueByFieldName(fieldName, obj);
//			Type type = field.getGenericType();
//			if (type.toString().equals("class java.util.Date") || type.toString().equals("class java.sql.Date")) {
//				map.put(fieldName, fieldValue);
//			} else if(type.toString().equals("class java.lang.Double")){
//				map.put(fieldName, fieldValue == null ? 0d : fieldValue);
//			} else {
//				map.put(fieldName, fieldValue == null ? "" : fieldValue);
//			}
			map.put(fieldName, fieldValue == null ? "" : fieldValue);
		}
		return map;
	}

	/**
	 * 根据属性名获取该类此属性的值
	 */
	private static Object getValueByFieldName(String fieldName, Object object) {
		String firstLetter = fieldName.substring(0, 1).toUpperCase();
		String getter = "get" + firstLetter + fieldName.substring(1);
		try {
			Method method = object.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(object, new Object[] {});
			return value;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
     * 通过反射,获得定义Class时声明的父类的泛型参数的类型. 如public UserDao extends HibernateDao<User>
     */
	public static Class getSuperClassGenricType(final Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }
 
    /**
     * 通过反射,获得定义Class时声明的父类的泛型参数的类型. 如public UserDao extends
     */
	
	private static Class getSuperClassGenricType(final Class clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }
}
