package com.zf.util;

public class CheckHandSetNum {

	public static void main(String[] args) {
		
		// 验证手机号码
		System.out.println(check("^1[3,4,5,7,8]\\d{9}$", "17311428530"));
		// 验证电话号码
		System.out.println(check("^\\d{3}-?\\d{8}|\\d{4}-?\\d{8}$","010-57719449"));
		// 邮政编码
		System.out.println(check("^[1-9]\\d{5}$","458000"));
	}
	
	public static String check(String reg , String text){
		String result;
		if(text.matches(reg)){
			result = text+"合法";
		}else{
			result = text+"不合法";
		}
		return result;
	}
	
}
