package com.zf.util;

import com.zf.vo.User;

public class ReflectFiled {

	public static void main(String[] args) {
		User user = new User();
		user.setName("��������");
		System.out.println("�����滻ǰName��"+user.getName());
	}
	
}
