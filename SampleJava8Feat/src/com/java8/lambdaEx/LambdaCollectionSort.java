package com.java8.lambdaEx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class Device{
	Integer id;
	String name;
	Float price;
	public Device(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
public class LambdaCollectionSort {

	public static void main(String[] args) { 
		List<Device> list = new ArrayList<Device>();
		
		list.add(new Device(1, "HP Laptop", 30000F));
		list.add(new Device(2, "Moto G6", 14999F));
		list.add(new Device(3, "Vivo F11", 15999F));
		list.add(new Device(4, "OnePlus 7", 31999F));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter respective number for sorting"+"1 : sort by id"+"2: sort by name"
				+"3: sort by price");
		int selection = sc.nextInt();
		if(selection == 1) {
			sortById(list);
		}
		if(selection == 2) {
			sortByName(list);
		}
		if(selection == 3) {
			sortByPrice(list);
		}
		
		for(Device d:list) {
			System.out.println(d.id+"\t"+d.name+"\t"+d.price);
		}
		
		Stream<Device> filter_data = list.stream().filter(p->p.price > 20000);
		
		System.out.println("Filtered device greater than price > 20000");
		filter_data.forEach(
				p->System.out.println(p.name+": "+p.price)
			);
	}
	
	private static void sortByName(List<Device> list) {
		System.out.println("Sorting on basis of name");
		Collections.sort((List<Device>) list,(x1,x2)->{
			return x1.name.compareTo(x2.name);
		});		
		
	}
	
	private static void sortById(List<Device> list) {
		System.out.println("Sorting on basis of id");
		Collections.sort((List<Device>) list,(x1,x2)->{
			return x1.id.compareTo(x2.id);
		});	
	}
	
	private static void sortByPrice(List<Device> list) {
		System.out.println("Sorting on basis of price");
		Collections.sort((List<Device>) list,(x1,x2)->{
			return x1.price.compareTo(x2.price);
		});
		
	}
	
	
}
