package com.java8;

import java.util.Optional;
import java.util.Random;

import com.java8.lambdaEx.Employee;
import com.java8.lambdaEx.Employee.Gender;

public class OptionalClEx1 {

	public static void processOptional(Employee e) {
		/** of and ofNullable **/
		Optional<String> nullValue = Optional.ofNullable(null);
		Optional<String> str = Optional.ofNullable(e.getEmail());
		
		
		System.out.println(Optional.ofNullable(nullValue));
		System.out.println(str);
		
		
		/**Checking data is present 
		 * isPresent() and     Java 11 - isEmpty() **/
		System.out.println("Available: "+nullValue.isPresent());
		System.out.println("Available: "+str.isPresent());
		
		//null value check with ifPresent()
		nullValue.ifPresent(value->System.out.println(value));
		str.ifPresent(value->System.out.println(value.length()));
		
		/** orElse and orElseGet **/
//		System.out.println("Value: "+nullValue.orElse("default"));
//		System.out.println("Value: "+nullValue.orElseGet(()->("default value ")+ new Random().nextInt(1000)));
		/**null value**/
//		System.out.println("Value: "+nullValue.orElse(getDefault()));
//		System.out.println("Value: "+nullValue.orElseGet(()->getDefault()));
		
		/** 
		 * when using orElse(), whether the wrapped value is present or not, 
		 * the default object is created. 
		 * So in this case, we have just created one redundant object that is never used.
		 * 
		 **/
		
		/* wrapper value */
		String defaultText = Optional.ofNullable("new text").orElseGet(()->getDefault());
		System.out.println("Using orElseGet Value: "+ defaultText);
		
		defaultText = Optional.ofNullable("new text").orElse(getDefault());
		System.out.println("Using orElse Value : "+ defaultText);
		
		//orElseThrow()
		//System.out.println(nullValue.orElseThrow(()->new IllegalArgumentException()));
		
		//retrive value with get()
		//System.out.println(str.get());
		//System.out.println(nullValue.get());
		
		/**filter()**/
		System.out.println(str.filter(s->s.contains("globant")).isPresent());
		
		Optional.ofNullable(e).filter(x->x.getAge()>20 && x.getAge()<30)
				.map(x->x.getName())
				.ifPresent(System.out::println);
	}
	
	public static String getDefault() {
		System.out.println("Getting default value...");
		return "default value";
	}
	
	public static void main(String[] args) {
		Employee e = new Employee("Jayesh", "Bangalore, India","jayesh@globant.com", 35000F, 2F, 24, Gender.MALE);
		processOptional(e);
		
//		String[] strArray = new String[5];
//		strArray[2]= null;
//		Optional<String> checkNull = Optional.ofNullable(strArray[2]);
//		
//		checkNull.ifPresent(System.out::println);
//		//System.out.println(checkNull.get());
//		if(checkNull.isPresent()) {
//		String upperCaseStr = strArray[2].toUpperCase();
//		System.out.println(upperCaseStr);
//		}else 
//			System.out.println("Value not present");
		
		String nullName = null;
    	Optional<String> name = Optional.ofNullable(nullName);//.orElse("john");
    	
    	System.out.println(name);
		
		
	}

}
