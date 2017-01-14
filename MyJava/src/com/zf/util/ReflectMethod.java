package com.zf.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.zf.vo.User;

public class ReflectMethod {

	public static void main(String[] args) {
		User user = new User();
		user.setName("测试名字");
		System.out.println("反射替换前Name："+user.getName());
		
		Class<User> c = User.class;
		Object o = user;
		Method m;
		try {
			m = c.getMethod("setName", String.class);
			m.invoke(o, "测试反射替换名字");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println("反射替换后Name："+user.getName());
		
		Field field;
		try {
			field = c.getDeclaredField("name");
			// 私有属性可以访问到
			field.setAccessible(true);
			field.set(o, "反射字段替换名字");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		System.out.println("反射替换字段后Name："+user.getName());
	}
}
