package com.github.tij4.chap10.innerclasses;

abstract class Base {
	public Base(int i) {
		System.out.println("Base constructor.i= " + i);
	}

	public abstract void f();
}

public class AnonymousConstructor {

	public static Base getBase(int i) {
		return new Base(i) {
			{
				System.out.println("Inside instance initializer");
			}

			public void f() {
				System.out.println("In anonymous f()");
			}
		};
	}

	public static void main(String[] args) {
		Base base = getBase(77);
		base.f();
	}
}
/*
Base constructor.i= 77
Inside instance initializer
In anonymous f()
*/