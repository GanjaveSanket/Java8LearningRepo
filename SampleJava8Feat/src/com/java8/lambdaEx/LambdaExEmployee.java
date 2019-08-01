package com.java8.lambdaEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;
import java.util.stream.Stream;

import com.java8.lambdaEx.Employee.Gender;

public class LambdaExEmployee {

	public static void printEmployeeOlderThan(List<Employee> list, int age) {
		Stream<Employee> filter_data = list.stream().filter(x -> x.getAge()>age);
		filter_data.map(x -> x.getName())
			.forEach( System.out::println );
	}
	
	public static void printEmployeeWithinAgeRange(List<Employee> list, int low, int high) {
		list.stream().filter(x-> x.getAge() >= low && x.getAge() < high)
				.map(x -> x.getName())
				.forEach( x->System.out.println(x) );
	}
	
	//without using filter operation, using if condition in lambda
	public static void printEmployeeEligibleforService(List<Employee> list, int low, int high) {
		list.forEach( x -> { if(x.getAge() >= low && x.getAge() < high && x.getGender()== Gender.MALE) {
				System.out.println(x.toString());
			}
		});
	}
	
	public static void printEmployeeWithPredicate(List<Employee> list, Predicate<Employee> condition) {
		for(Employee x:list) 
			if(condition.test(x)) {
				System.out.println(x.toString());
			}
	}
	
	public static void checkEmployees(List<Employee> list, Predicate<Employee> condition, Consumer<Employee> block) {
		for(Employee x:list) 
			if(condition.test(x)) {
				block.accept(x);
			}
	}
	
	public static void checkEmployeesWithFunction(List<Employee> list, Predicate<Employee> condition, Function<Employee, String> mapper,  Consumer<String> block) {
		for(Employee x:list) 
			if(condition.test(x)) {
				String result=mapper.apply(x);
				block.accept(result);
			}
	}
	
	public static<T, U> void processEmployees(List<T> list, Predicate<T> condition, Function<T, U> mapper,  Consumer<U> block) {
		for(T x:list) 
			if(condition.test(x)) {
				U result=mapper.apply(x);
				block.accept(result);
			}
	}
	
	public static void createEmployees(List<Employee> list) {
		list.add(new Employee("Ajay", "Pune, India","ajay@globant.com", 25000F, 1.2F, 22, Gender.MALE));	
		list.add(new Employee("Jayesh", "Bangalore, India","jayesh@globant.com", 35000F, 2F, 24, Gender.MALE));	
		list.add(new Employee("Meera", "Hyderabad, India","meera@globant.com", 45000.5F, 2.5F, 24, Gender.FEMALE));	
		list.add(new Employee("Anna", "Argentina","anna@globant.com", 55000F, 2F, 25, Gender.FEMALE));
		list.add(new Employee("Nilesh", "Pune, India","nilesh@globant.com", 95000F, 10F, 32, Gender.MALE));	
		list.add(new Employee("Jaya", "Pune , India","jaya@globant.com", 65000F, 4F, 26, Gender.FEMALE));
		list.add(new Employee("Ajay", "Pune, India","ajay22@globant.com", 25000F, 1.2F, 22, Gender.MALE));	
		list.add(new Employee("Ajay", "Pune, India","ajay33@globant.com", 25000F, 1.2F, 22, Gender.MALE));	
	}
	
	public static void sortByName(List<Employee> list) {
		Collections.sort(list, (a, b)->{return a.getName().compareTo(b.getName());});
		list.stream().map(x->x.getName()).forEach(x->System.out.println(x));
	}
	
	//lambda expression for Comparator interface implementation 
	public static void sortUsingComaprator(List<Employee> list) {
		Employee[] listAsArray = list.toArray(new Employee[list.size()]);

		//without lambda
		class EmployeeNameComparator implements Comparator<Employee> {
		    public int compare(Employee a, Employee b) {
		        return a.getName().compareTo(b.getName());
		    }
		}
		
		//using lambda
		Comparator<Employee> Comp = (a, b)-> a.getName().compareTo(b.getName()); 
		
		Collections.sort(list, Comp);
		
		//Arrays.sort(listAsArray, new EmployeeNameComparator());
		//Arrays.sort(listAsArray, (Employee a, Employee b)->{return a.getName().compareTo(b.getName());});		
	}
	
	public static void mapEmployeesByAge(List<Employee> list) {
		System.out.println(
		list.stream()
			.collect(Collectors.toMap(Employee::getName, Employee::getEmail, (e1, e2) -> e2 ))); 
//					groupingBy(Employee::getName,
//					Collectors.mapping(Employee::getEmail, Collectors.toList()))));
	}
	
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		List<String> strList= new ArrayList<String>();
		
		createEmployees(list);
		strList.add("India");
		strList.add("United States");
		strList.add("Russia");
		strList.add("China");
		
		System.out.println("Employees older than 24");
		printEmployeeOlderThan(list, 24);
		
		System.out.println("Employees in range 20-24");
		printEmployeeWithinAgeRange(list, 20, 25);
//		
//		System.out.println("\nMale Employees in range 20-24 ");
//		printEmployeeEligibleforService(list, 20, 25);
		
//		System.out.println("\nFemale Employees with experience >= 2 ");
//		printEmployeeWithPredicate(list, x-> x.getGender() == Gender.FEMALE && x.getExperience() >=2 );
		
//		System.out.println("\nMale Employees with experience >= 2 ");
//		checkEmployees(list, x-> x.getGender() == Gender.MALE && x.getExperience() >=2 , x->System.out.println(x.toString()));
//		
//		System.out.println("\nMale Employees with experience >= 2 Email Ids:");
//		checkEmployeesWithFunction(list, x-> x.getGender() == Gender.MALE && x.getExperience() >=2 , x->x.getEmail(), System.out::println);
		
		System.out.println("Email Ids of Male Employees with Experience >=2,");
		processEmployees(list, x-> x.getGender() == Gender.MALE && x.getExperience() >=2 , x->x.getEmail(), mail->System.out.println(mail));
		
//		System.out.println("\nFemale Employees with Pune location, Email Ids:");
//		list.stream().filter(x->x.getGender() == Gender.FEMALE && x.getAddress().contains("Pune")).map(x->x.getEmail()).forEach(x->System.out.println(x.toString()));
		
		
//		String[] strArray= new String[strList.size()];
//		strArray = strList.toArray(strArray);
		
		System.out.println("List Sorted by name");
		sortUsingComaprator(list);
		list.stream().map(x -> x.getName())
					 .forEach(System.out::println);
		//sortByName(list);
		
		System.out.println("Converting List to map");
		mapEmployeesByAge(list);
	}

}
