package com.zf.util;

import java.util.Date;
import java.util.Locale;

/**
 * Description: ���ڸ�ʽ��
 * All Rights Reserved.
 * @version 1.0  2017��1��13�� ����5:03:07  by �����������������䣩����
 */
public class DateFormat {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("Ĭ�����ڸ�ʽ��"+ date);
		System.out.println("һ�����е���һ�죺"+ String.format("%te", date));
		System.out.println("��λ���£�"+ String.format("%tm", date));
		System.out.println("��λ���꣺"+ String.format("%ty", date));
		System.out.println("4λ���꣺"+ String.format("%tY", date));
		System.out.println("Ĭ�����Ի������ڼ�ƣ�"+ String.format(Locale.US,"%ta", date));
		System.out.println("Ĭ�����Ի�������ȫ�ƣ�"+ String.format("%tA", date));
		
		System.out.println("Ĭ�����Ի����·ݼ�ƣ�"+ String.format(Locale.US,"%tb", date));
		System.out.println("Ĭ�����Ի����·�ȫ�ƣ�"+ String.format("%tB", date));
	}
	
}
