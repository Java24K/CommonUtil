package com.zf.util;

import java.util.Date;

public class DateTimeFormat {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("Ĭ�����ڸ�ʽ��"+ date);
		System.out.println("24Сʱʱ�䱻��ʽ��ΪСʱ�ͷ��ӣ�"+ String.format("%tR", date));
		System.out.println("24Сʱ����ʽ����Сʱ�����룺"+ String.format("%tT", date));
		System.out.println("12Сʱ��ʱ�䣺"+ String.format("%tD", date));
		System.out.println("���ڱ���ʽ����"+ String.format("%tD", date));
		System.out.println("ISO 8601��ʽ������"+ String.format("%tF", date));
		System.out.println("����ʱ�䱻��ʽ��:"+ String.format("%te", date));
	}
}
