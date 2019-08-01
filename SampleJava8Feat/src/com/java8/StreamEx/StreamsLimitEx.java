package com.java8.StreamEx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsLimitEx {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8);
		
//		Stream<List<Integer>> strmList = Stream.iterate(numList,  e -> e);
		
		Stream<String> strmStr = Stream.iterate("",  e -> e + "Red").limit(10);
		Stream<Integer> strmInt = numList.stream().limit(4);
		
		strmStr.forEach(System.out::println);
		strmInt.limit(10).forEach(System.out::println);
		
//		List<Integer> numList = strmInt.limit(10)
//									.collect(Collectors.toList());
		
		
		System.out.println("skip first 5 numbers in list: ");
		numList.stream().skip(5).forEach(System.out::println);
		
	}

}
