package com.jthread.uma.asgmt1;

public class Welcome {
	char c = 'a';

	public static void show() {
		System.out.println("Welcome to jThread!");

	}

	public void display() {
		System.out.println("Great Learning \"Uma\"!!\nAll the Best!");// escape sequence demo
		System.out.println(Integer.toHexString(c));
	}

	public static void main(String[] args) {

		Welcome disObj = new Welcome();
		Welcome.show();// static method called using classname.methodname
		disObj.display();
		System.out.println("Practise is key");
	}

}
