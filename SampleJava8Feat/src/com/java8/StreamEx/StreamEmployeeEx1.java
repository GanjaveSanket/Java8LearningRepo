package com.java8.StreamEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java8.lambdaEx.*;
import com.java8.lambdaEx.Employee.Gender;


public class StreamEmployeeEx1 {
	
	public static void createEmployees(List<Employee> list) {
		list.add(new Employee("Jayesh", "Bangalore, India","jayesh@globant.com", 35000F, 2F, 24, Gender.MALE));	
		list.add(new Employee("Ajay", "Pune, India","ajay@globant.com", 25000F, 1.2F, 22, Gender.MALE));	
		list.add(new Employee("Meera", "Hyderabad, India","meera@globant.com", 45000.5F, 2.5F, 26, Gender.FEMALE));	
		list.add(new Employee("Anna", "Tandil, Argentina","anna@globant.com", 55000F, 2F, 25, Gender.FEMALE));
		list.add(new Employee("Nilesh", "Pune, India","nilesh@globant.com", 95000F, 10F, 32, Gender.MALE));	
		list.add(new Employee("Jason", "California , USA","jason@globant.com", 85000F, 4F, 28, Gender.MALE));	
		list.add(new Employee("Adam", "New York , USA","adam@globant.com", 115000F, 8F, 32, Gender.MALE));
		list.add(new Employee("Sara", "Toronto , Canada","sara@globant.com", 85000F, 10F, 35, Gender.FEMALE));
		list.add(new Employee("David", "Berlin , Germany","david@globant.com", 225000F, 16F, 42, Gender.MALE));
		list.add(new Employee("Kate", "Munich , Germany","kate@globant.com", 175000F, 14F, 44, Gender.FEMALE));
	}
	
	public static Stream<String> filterExpGT5(List<Employee> employeeList){
		return employeeList.stream().filter(x->x.getExperience()>=5)
				.map(x->x.getName());
	} 
	
	public static void matchOperations(List<Employee> employeeList){
		
		System.out.println("Are all employess having exp > 1 : " + employeeList.stream().allMatch(e -> e.getExperience() > 1));
		
//		System.out.println("is there any female employee : " + employeeList.stream().anyMatch(e -> e.getGender().equals(Gender.FEMALE)));
//		
//		System.out.println("no one having age < 20 : " + employeeList.stream().noneMatch(e -> e.getAge() < 20));
	}
	
	public static long countOperation(List<Employee> employeeList){
		return employeeList.stream().
				filter(x -> x.getExperience() > 5)
				.count();
	} 
	
	public static void forEachOperation(List<Employee> employeeList){
		 employeeList.stream().filter(x -> x.getExperience() > 5)
				.map(Employee::getName)
				.forEach(System.out::println);
	}
	
	public static void minMaxOperation(List<Employee> employeeList){
		System.out.println("Min age of female employee : "+ employeeList.stream().filter(x -> x.getGender().equals(Gender.FEMALE))
				.min((e1,e2) -> e1.getAge() - e2.getAge()));
//				.map(Employee::getName));
	}
	
	public static void findFirstOperation(List<Employee> employeeList){
		System.out.println("First employee having age > 25 : "+ employeeList.stream().filter(x -> x.getAge() > 25)
				.map(Employee::getName)
				.findFirst());
	}
	
	public static void reductionOperation(List<Employee> employeeList){
//		System.out.println("Male employees names : " + employeeList.stream().filter(x -> x.getGender().equals(Gender.MALE))
//				.map(Employee::getName)
//				.reduce( (x1,x2) -> x1 + ", " + x2));
		
		System.out.println("sum of Male employees salary  : "+ employeeList.stream().filter(x -> x.getGender().equals(Gender.MALE))
				.mapToDouble(Employee::getSalary)
				.reduce(0, Double::sum));
//		
//		System.out.println("sum of Male employees salary using combiner, accumulator  : "+ employeeList.stream().filter(x -> x.getGender().equals(Gender.MALE))
////				.map(Employee::getSalary)
//				.reduce(0.0 ,(sum , e) -> sum + e.getSalary(), Double::sum));
	}
	
	public static void collectOperation(List<Employee> employeeList){
		
		System.out.println("List of Employees Resident of India: ");
		System.out.println(employeeList.stream().filter(x -> x.getAddress().contains("India"))
							.map(Employee::getName)
							.collect(Collectors.toList()));
		
		System.out.println(employeeList.stream().filter(x -> x.getAddress().contains("India"))
				.map(Employee::getName)
				.collect(Collectors.toCollection(TreeSet::new)));
		
		System.out.println("List of Employees having age > 40: "+
				employeeList.stream().filter(x -> x.getAge() > 40)
							.map(Employee::getName)
							.collect(Collectors.joining(", ")));
	}
	
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		createEmployees(employeeList);
		
		List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
		int factor = 2;
		
		int[] numInt = new int[] {1,2,3};
//		System.out.println("primitive array: " + Arrays.stream(numInt).min());
		
		/**print double of first even numbers**/
		/**Lazy evaluation**/
		System.out.println("double of first 10 even numbers");
		numInt[0] = 2;
		Stream<Integer> numStream =  numList.stream().filter(e->e%2==0)
										.map(e->e*numInt[0])
										.limit(4);
		/*
		 * local variables used in Lambda expression have to be final or effectively
		 * final, dev would not ideally change this, here array element is used which is mutative 
		 * and thats why changing it effects stream result. 
		 */
		numInt[0] = 3;   
		numStream.forEach(System.out::println);
		
		/**find sqaure roots of even numbers**/
//		System.out.println(numList.stream().filter(e->e%2==0)
//					.mapToDouble(Math::sqrt)
//					.sum());
		
		
		/**Filter employees having exp >= 5 **/
		System.out.println("List of Employees having exp >= 5\n"+filterExpGT5(employeeList));
//														.collect(Collectors.toList());
		
		
		/**allMatch(),anyMatch(), noneMatch() operation **/
//		matchOperations(employeeList);
				
		/**print count using count()**/
//		System.out.println("Count of Employees having experience > 5 is :"+ countOperation(employeeList));
		
		/**forEach() method**/
//		System.out.println("Name of Employees having experience > 5 is : ");
//		forEachOperation(employeeList);
		
		/**min(), max(), **/
//		minMaxOperation(employeeList);
		
		/**findFirst operation**/
//		findFirstOperation(employeeList);
		
		/**Reduction  operation  reduce()**/
//		reductionOperation(employeeList);
		
		/**:: Filter employees Resident of India and accumulate then into list **/
		/**collect() operation using Collectors class**/
		collectOperation(employeeList);
	}
	
	
}
