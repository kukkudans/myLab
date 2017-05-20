package com.harilal.java.v8.samples;

import java.util.List;

import com.harilal.java.v8.samples.util.Helper;

public class Sample3 {

	public static void main(String[] args) {
		Sample3 obj=new Sample3();
		List<String> nameList = Helper.getNameList();
		//passing method as argument
		nameList.forEach(System.out::println);
		
		nameList.forEach(Sample3::length);	
		nameList.forEach(obj::isEquals);
	}

	public static void length(String str){
		System.out.println(str.length());
	}
	
	public  void isEquals(String str1){
		System.out.println(str1.equals(str1));
	}
}
