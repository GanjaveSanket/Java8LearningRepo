package com.java8.lambdaEx;

public class Employee {
		public enum Gender{
			MALE,FEMALE;
		}
		private String name, address, email;
		private Float salary, experience;
		private int age;
		private Gender gender;
		
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Float getSalary() {
			return salary;
		}
		public void setSalary(Float salary) {
			this.salary = salary;
		}
		public Float getExperience() {
			return experience;
		}
		public void setExperience(Float experience) {
			this.experience = experience;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		public Employee(String name,String address,String email, Float salary,Float experience,int age,Gender gender) {
			this.name=name;
			this.address=address;
			this.email=email;
			this.salary=salary;
			this.experience=experience;
			this.age=age;
			this.gender=gender;
		}
	
		public String toString() {
			return ("Employee details: \nName:\t"+this.name+"\nAddress:\t"+this.address+"\nAge:\t"+this.age+"\nGender:\t"+this.gender
					+"\nSalary:\t"+this.salary+"\nExperience:\t"+this.experience);
		}
	}
