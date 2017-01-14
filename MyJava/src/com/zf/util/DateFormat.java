package com.zf.util;

import java.util.Date;
import java.util.Locale;

/**
 * Description: 日期格式化
 * All Rights Reserved.
 * @version 1.0  2017年1月13日 下午5:03:07  by 您的姓名（您的邮箱）创建
 */
public class DateFormat {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("默认日期格式："+ date);
		System.out.println("一个月中的那一天："+ String.format("%te", date));
		System.out.println("两位的月："+ String.format("%tm", date));
		System.out.println("两位的年："+ String.format("%ty", date));
		System.out.println("4位的年："+ String.format("%tY", date));
		System.out.println("默认语言环境星期简称："+ String.format(Locale.US,"%ta", date));
		System.out.println("默认语言环境星期全称："+ String.format("%tA", date));
		
		System.out.println("默认语言环境月份简称："+ String.format(Locale.US,"%tb", date));
		System.out.println("默认语言环境月份全称："+ String.format("%tB", date));
	}
	
}
