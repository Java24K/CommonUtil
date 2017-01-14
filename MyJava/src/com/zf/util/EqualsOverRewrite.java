package com.zf.util;

public class EqualsOverRewrite {

	private String name;
	
	private int age;
	
	public EqualsOverRewrite(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}
		
		if(obj==null){
			return false;
		}
		
		if(getClass()==obj.getClass()){
			return false;
		}
		
		EqualsOverRewrite r = (EqualsOverRewrite)obj;
		// ���������ֱ�ӷ������˽�б���
		return name.equals(r.name) && age==r.age;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("���֣�"+name+"\n");
		sb.append("���䣺"+age+"\n");
		return sb.toString();
	}
	
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result +((name==null)?0:name.hashCode());
		return result;
	}
}
