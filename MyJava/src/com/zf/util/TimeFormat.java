package com.zf.util;

import java.util.Date;
import java.util.Locale;

public class TimeFormat {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("默认日期格式："+ date);
		System.out.println("24小时制的小时："+ String.format("%tH", date));
		System.out.println("12小时制的小时："+ String.format("%tI", date));
		System.out.println("24小时制的小时："+ String.format("%tk", date));
		
		System.out.println("两位小时中的分钟："+ String.format("%tM", date));
		System.out.println("两位分钟中的秒："+ String.format("%tS", date));
		System.out.println("时区缩写形式字符串："+ String.format("%tZ", date));
		System.out.println("特定环境的上午下午标记以小写形式表示："+ String.format(Locale.US,"%tp", date));
	}
}
