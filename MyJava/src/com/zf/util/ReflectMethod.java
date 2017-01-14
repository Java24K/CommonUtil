package com.zf.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.zf.vo.User;

public class ReflectMethod {

	public static void main(String[] args) {
		User user = new User();
		user.setName("��������");
		System.out.println("�����滻ǰName��"+user.getName());
		
		Class<User> c = User.class;
		Object o = user;
		Method m;
		try {
			m = c.getMethod("setName", String.class);
			m.invoke(o, "���Է����滻����");
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
		
		System.out.println("�����滻��Name��"+user.getName());
		
		Field field;
		try {
			field = c.getDeclaredField("name");
			// ˽�����Կ��Է��ʵ�
			field.setAccessible(true);
			field.set(o, "�����ֶ��滻����");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		System.out.println("�����滻�ֶκ�Name��"+user.getName());
	}
}
