package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
interface DrawShape {
	void abstDraw2();   	// abstract method
	static void staticDraw(int n) {
		System.out.println("Default Width:"+50);
	};

	default public void defaultDraw2() 
	 {
		System.out.println("Default method,  Width: "+50);
	} 
}

@FunctionalInterface
interface Sayable extends DrawShape{
	// if we uncomment this then it compiler will give error because Functional Interface can hold only one abstract method
	//void say(String msg);	   //abstract method
	
	// It can contain any number of Object class methods.
	int hashCode();
	String toString();
	boolean equals(Object obj);
}

public class FuncIntfEx1 {

	public static void main(String[] args) {
		//static method call
		System.out.print("DrawShape Static method :");
		DrawShape.staticDraw(20);
		
		//Anonymous class
		Sayable S = new Sayable() {
			public void abstDraw2() {
				System.out.println("anonymous class");
			}
		}; 
		
		// above anonymous class using Lambda
		Sayable Say = () -> System.out.println("Lambda expression");
		
		S.defaultDraw2();
		S.abstDraw2();
		
		DrawShape d = () ->{ System.out.println("Drawing width :" +50);  };
		d.abstDraw2();
		
		
		List<Integer> numbersList=Arrays.asList(1,2,3,4,5,6,7,8,10,9,11,16,12,11,15);
		
		BiConsumer<Integer , Integer > bd = (x,y)->{System.out.println("addition:" + (x+y));};
		bd.accept(20, 30);

		System.out.println("Consumer Example, printing value from list:");
		Consumer<Integer> cons = (x-> System.out.println(x) );
		for (Integer n : numbersList) {
			cons.accept(n);								//accept() is abstract method of @FunctionInterface Consumer 
		}						
		
		System.out.println("Function Example, printing double value of list elements:");
		Function<Integer, Integer> func = (x) -> {return x*2;};
		for(Integer n:numbersList)
			System.out.println(func.apply(n));     		//apply() is abstract method of @FunctionInterface Function 
		
		System.out.println("Predicate Example, checking list elements > 10:");
		Predicate<Integer> predicate = (x) -> {return x > 10;};
		for(Integer n:numbersList)
			System.out.println(predicate.test(n)); 		//test() is abstract method of @FunctionInterface Predicate 
		
		System.out.println("BinaryOperator Example, Adding two elements:");
		BinaryOperator<Integer> bo = (x, y)->  x + y;
		Integer z = bo.apply(50, 30);					//apply() is abstract method of @FunctionInterface BinaryOperator 
		System.out.println(z);
		
		System.out.println("BiPredicate Example, checking greater between 2 numbers (is 30>100):");
		BiPredicate<Integer, Integer> bipred = (x, y) -> {return x > y;};
		System.out.println(bipred.test(30, 100));		//test() is abstract method of @FunctionInterface BiPredicate 
	}

}
