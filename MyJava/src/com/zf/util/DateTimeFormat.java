package com.zf.util;

import java.util.Date;

public class DateTimeFormat {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("默认日期格式："+ date);
		System.out.println("24小时时间被格式化为小时和分钟："+ String.format("%tR", date));
		System.out.println("24小时被格式化的小时分钟秒："+ String.format("%tT", date));
		System.out.println("12小时制时间："+ String.format("%tD", date));
		System.out.println("日期被格式化："+ String.format("%tD", date));
		System.out.println("ISO 8601格式化日期"+ String.format("%tF", date));
		System.out.println("日期时间被格式化:"+ String.format("%te", date));
	}
}
