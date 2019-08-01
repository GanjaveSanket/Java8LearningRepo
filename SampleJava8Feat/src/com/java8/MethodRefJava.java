package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.java8.lambdaEx.Employee;
import com.java8.lambdaEx.Employee.Gender;
import com.java8.lambdaEx.LambdaExEmployee;

public class MethodRefJava {

	static String printStatic() {
		return "in static method";
	} 
	public static void createEmployees(List<Employee> list) {
		list.add(new Employee("Ajay", "Pune, India","ajay@globant.com", 25000F, 1.2F, 22, Gender.MALE));	
		list.add(new Employee("Jayesh", "Bangalore, India","jayesh@globant.com", 35000F, 2F, 24, Gender.MALE));	
		list.add(new Employee("Meera", "Hyderabad, India","meera@globant.com", 45000.5F, 2.5F, 24, Gender.FEMALE));	
		list.add(new Employee("Anna", "Argentina","anna@globant.com", 55000F, 2F, 25, Gender.FEMALE));
		list.add(new Employee("Nilesh", "Pune, India","nilesh@globant.com", 95000F, 10F, 32, Gender.MALE));	
		list.add(new Employee("Jaya", "Pune , India","jaya@globant.com", 65000F, 4F, 26, Gender.FEMALE));
		
	}
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		createEmployees(list);
		
		
		List<Integer> integers = Arrays.asList(123,22,233,205);
        
		/*
		 * 1. Reference to static method
		 * Math::max equivalent to Math.max(x,y)
		 */
		Optional<Integer> maxValue = integers.stream().reduce( Math::max );
		 
		maxValue.ifPresent(value -> System.out.println("Max Value: " + value));
		
		/* 
		 * 2. Reference to instance method from instance
		 * System.out::println equivalent to System.out.println(x)
		 * 
		 */
		System.out.println("Employees age > 24 : ");
		list.stream().filter(x -> x.getAge() > 24)
					.map(x -> x.getName()).forEach(System.out::println);
		
		
		/*
		 * 3. Reference to an instance method of an arbitrary object of a particular type from class type
		 */
		
		Map<String, String> nameList = list.stream()
					.collect(Collectors.toMap(Employee::getName, Employee::getEmail));   

		nameList.forEach((K, V) -> System.out.println("Key: " + K + " Value: " + V));

		/* 4. Reference to a LinkedList constructor */
		LinkedList<String> nameLinkedList = list.stream()
										.map(Employee::getEmail)	
										.collect(Collectors.toCollection(LinkedList::new)); 
		nameLinkedList.forEach(System.out::println);
		
		//below functionality can't be done using method reference because of customization in println() 
		list.stream().forEach(e -> System.out.println("Name: "+e.getName() + "\tEmail: "+ e.getEmail()));
	}

}
