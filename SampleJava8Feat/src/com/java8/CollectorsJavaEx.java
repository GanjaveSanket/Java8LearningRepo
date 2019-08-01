package com.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java8.lambdaEx.Employee;
import com.java8.lambdaEx.Employee.Gender;

public class CollectorsJavaEx {
	
	public static void createEmployees(List<Employee> list) {
		list.add(new Employee("Jayesh", "Bangalore, India","jayesh@globant.com", 35000F, 2F, 24, Gender.MALE));	
		list.add(new Employee("Ajay", "Pune, India","ajay@globant.com", 25000F, 1.2F, 22, Gender.MALE));	
		list.add(new Employee("Meera", "Hyderabad, India","meera@globant.com", 45000.5F, 2.5F, 26, Gender.FEMALE));	
		list.add(new Employee("Anna", "Tandil, Argentina","anna@globant.com", 55000F, 2F, 25, Gender.FEMALE));
	}
	
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		createEmployees(employeeList);
		
		/**Collectors class** toList method**/
		System.out.println("List of Employees Resident of India: ");
		List<String> nameList = employeeList.stream().filter(x -> x.getAddress().contains("India"))
							.map(Employee::getName)
							.collect(Collectors.toList());
		nameList.forEach(System.out::println);
		
//		System.out.println(employeeList.stream().filter(x -> x.getAddress().contains("India"))
//							.map(Employee::getName)
//							.collect(Collectors.toCollection(LinkedList::new)));
		
//		List<Employee> result = employeeList.stream()
//				  .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		
		employeeList.stream().filter(x -> x.getAddress().contains("India"))
				.collect(Collectors.toMap(Employee::getGender, Employee::getAge));
		
		/**Collectors.joining**/
		System.out.println("joining example, List of Employees having age > 24: "+
				employeeList.stream().filter(x -> x.getAge() > 24)
							.map(Employee::getName)
							.collect(Collectors.joining(", ", "[", "]")));
		
		/**Collectors class groupingBy() and mapping() map to key and value**/
		System.out.println("grouping and mapping Example,map of mail and names  : " + 
					employeeList.stream().filter(x -> x.getAddress().contains("India"))
							.collect(Collectors.groupingBy(Employee::getName,
											Collectors.mapping(Employee::getEmail, Collectors.toList()))));
			
		/**Collectors class partitioningBy()**/
		System.out.println("partitioningBy Example, Salary of Indian Employees > 25000:\n" + 
				employeeList.stream().filter(x -> x.getAddress().contains("India"))
				.map(Employee::getSalary)
				.collect(Collectors.partitioningBy(e -> e > 25000 )));
		
		/**Collectors class counting()**/
		System.out.println("counting Example, count of Indian Employees by gender:\n" + employeeList.stream().filter(x -> x.getAddress().contains("India"))
				.collect(Collectors.groupingBy(Employee::getGender, 
						Collectors.counting())));
		
		/**Collectors class averagingDouble()**/
		System.out.println("averagingDouble Example, average of Male Indian Employees' salary:\n" +
				employeeList.stream().filter(x -> x.getAddress().contains("India"))
				.collect(Collectors.averagingDouble(Employee::getAge)));
		
		/**Collectors class summingDouble()**/
		System.out.println("summingDouble Example, sum of Male Indian Employees' salary:\n" + 
				employeeList.stream().filter(x -> x.getAddress().contains("India"))
				.collect(Collectors.summingDouble(Employee::getSalary)));
		
		/**Collectors class summarizingDouble()**/
		System.out.println("summarizingDouble Example, summary of Male Indian Employees' salary:\n" + 
				employeeList.stream().filter(x -> x.getAddress().contains("India"))
				.collect(Collectors.summarizingDouble(Employee::getSalary)));
	}

}
