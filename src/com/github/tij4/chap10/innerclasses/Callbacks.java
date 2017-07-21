package com.github.tij4.chap10.innerclasses;

interface Incrementable {
	void increment();
}

class Callee1 implements Incrementable {
	private int i = 0;

	@Override
	public void increment() {
		i++;
		System.out.println("Callee1.increment:" + i);
	}
}

class MyIncrement {
	public void increment() {
		System.out.println("MyIncrement.increment=====Other operation");
	}

	static void f(MyIncrement mi) {
		mi.increment();
	}
}

class Callee2 extends MyIncrement {
	private int i = 0;

	public void increment() {
		super.increment();
		i++;
		System.out.println("Callee2.increment:" + i);
	}

	private class Closure implements Incrementable {

		@Override
		public void increment() {
			Callee2.this.increment();
		}

	}

	Incrementable getCallbackReference() {
		return new Closure();
	}
}

class Caller {
	private Incrementable callbackReference;

	Caller(Incrementable cbh) {
		callbackReference = cbh;
	}

	void go() {
		callbackReference.increment();
	}
}

public class Callbacks {

	public static void main(String[] args) {
		Callee1 c1 = new Callee1();
		Callee2 c2 = new Callee2();
		MyIncrement.f(c2);
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReference());

		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}

}
/*Output:
MyIncrement.increment=====Other operation
Callee2.increment:1

Callee1.increment:1

Callee1.increment:2

MyIncrement.increment=====Other operation
Callee2.increment:2

MyIncrement.increment=====Other operation
Callee2.increment:3
 */
