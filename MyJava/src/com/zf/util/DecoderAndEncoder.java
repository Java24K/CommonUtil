package com.zf.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Description: Java编码与解码
 * 1.java.net 编码解码的使用
 * 2.java.net 编码解码的设计模式学习
 * 
 * All Rights Reserved.
 * @version 1.0  2017年1月12日 上午11:04:36  by zhoufeng
 */
public class DecoderAndEncoder {

	public static void main(String[] args) {
		String str = "我是一个兵";
		String encoderStr = encoder(str);
		System.out.println("'"+str+"'编码后结果:"+encoderStr);
		String decoderStr = decoder(encoderStr);
		System.out.println("'"+encoderStr+"'解码后结果:"+decoderStr);
	}
	
	public static String decoder(String encoderStr){
		String decoderStr = null;
		try {
			// 解码
			decoderStr = URLDecoder.decode(encoderStr, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decoderStr;
	}
	
	public static String encoder(String str){
		String encoderStr = null;
		try {
			// 编码
			encoderStr = URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encoderStr;
	}
}
