package com.java8.lambdaEx;

interface Drawable {
	public void Draw();
	default void DrawDefault() {
		System.out.println("Drawing width: "+ 100);
	}
}

public class AnonClassExprNew {
		
	public static void main(String[] args) {
		int width=10;
		
		//Anonymous class
		Drawable d = new Drawable() {
			@Override
			public void Draw() {
				System.out.println("Drawing: "+width);
				
			}
			public void DrawDefault() {
				System.out.println("Default Drawing width: "+width*5);
				
			}
		};
		//using lambda
//		Drawable d = ()->System.out.println("Drawing with Lambda: "+40);
		d.Draw();
		d.DrawDefault();
		
		//Thread class
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("In another thread");
			}
		});
		th.start();
		
		//using lambda expression
		Thread th2 = new Thread(()->System.out.println("In another thread by lambda"));
		th2.start();
		
		System.out.println("In Main");
	}
}
