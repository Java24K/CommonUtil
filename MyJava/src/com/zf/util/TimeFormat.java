package com.zf.util;

import java.util.Date;
import java.util.Locale;

public class TimeFormat {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("Ĭ�����ڸ�ʽ��"+ date);
		System.out.println("24Сʱ�Ƶ�Сʱ��"+ String.format("%tH", date));
		System.out.println("12Сʱ�Ƶ�Сʱ��"+ String.format("%tI", date));
		System.out.println("24Сʱ�Ƶ�Сʱ��"+ String.format("%tk", date));
		
		System.out.println("��λСʱ�еķ��ӣ�"+ String.format("%tM", date));
		System.out.println("��λ�����е��룺"+ String.format("%tS", date));
		System.out.println("ʱ����д��ʽ�ַ�����"+ String.format("%tZ", date));
		System.out.println("�ض�������������������Сд��ʽ��ʾ��"+ String.format(Locale.US,"%tp", date));
	}
}
