package com.zf.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Description: Java���������
 * 1.java.net ��������ʹ��
 * 2.java.net �����������ģʽѧϰ
 * 
 * All Rights Reserved.
 * @version 1.0  2017��1��12�� ����11:04:36  by zhoufeng
 */
public class DecoderAndEncoder {

	public static void main(String[] args) {
		String str = "����һ����";
		String encoderStr = encoder(str);
		System.out.println("'"+str+"'�������:"+encoderStr);
		String decoderStr = decoder(encoderStr);
		System.out.println("'"+encoderStr+"'�������:"+decoderStr);
	}
	
	public static String decoder(String encoderStr){
		String decoderStr = null;
		try {
			// ����
			decoderStr = URLDecoder.decode(encoderStr, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decoderStr;
	}
	
	public static String encoder(String str){
		String encoderStr = null;
		try {
			// ����
			encoderStr = URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encoderStr;
	}
}
