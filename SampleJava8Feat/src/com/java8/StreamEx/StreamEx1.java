package com.java8.StreamEx;

import java.util.Arrays;
import java.util.List;

public class StreamEx1 {

	public static void main(String[] args) {
		List<Integer> numbersList=Arrays.asList(1,2,3,4,5,6,7,8,10,9,11,16,12,11,15);
		
		//find double of first even number greater than 5
		System.out.println(
			numbersList.stream().filter(StreamEx1::isGrThan5)
						.filter(StreamEx1::isEven)
						.map(StreamEx1::doubleValue)
						.findFirst());
		
		numbersList.stream().filter(StreamEx1::isGrThan5)
		.filter(StreamEx1::isEven)
		.sorted()
		.distinct()
		.forEach(System.out::println);
	}
	public static boolean isGrThan5(int number) {
//		System.out.println("isGrThan5 "+number);
		return number > 5;
	}
	public static boolean isEven(int number) {
//		System.out.println("isEven "+number);
		return number % 2 == 0;
	}
	public static int doubleValue(int number) {
//		System.out.println("doubleValue "+number);
		return number * 2;
	}
}
