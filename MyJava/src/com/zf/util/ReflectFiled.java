package com.zf.util;

import com.zf.vo.User;

public class ReflectFiled {

	public static void main(String[] args) {
		User user = new User();
		user.setName("²âÊÔÃû×Ö");
		System.out.println("·´ÉäÌæ»»Ç°Name£º"+user.getName());
	}
	
}
