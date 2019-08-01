package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StrJoinerEx1 {
	private static String PREFIX = "[";
	private static String SUFFIX = "]";
	
	public static void main(String[] args) {
		
		
		StringJoiner rule = new StringJoiner(",", "[", "]");
		rule.add("HP").add("Lenevo").add("Sony").add("Dell");
		
		System.out.println(rule);
		
		List<String> list =  
				Arrays.asList("HP", "Dell", "Sony", "Apple");
//		list.addAll(rule);
		StringJoiner ruleList = new StringJoiner("-", PREFIX, SUFFIX);
		
		for(String e : list)
			ruleList.add(e);
		
		System.out.println(ruleList.toString());
		
		
		StringJoiner ruleEmpty = new StringJoiner("-", PREFIX, SUFFIX);
		ruleEmpty.setEmptyValue("Default");
		
		System.out.println(ruleEmpty);
		System.out.println(ruleList.merge(rule));
	}

}
