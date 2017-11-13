package com.github.tij4.chap12;

class MyException extends Exception {
	public MyException() {
	}

	public MyException(String msg) {
		super(msg);
	}
}

public class FullConstructors {

	public static void fun() throws MyException {
		System.out.println("Throwing MyException from fun()");
		throw new MyException();
	}

	public static void funG() throws MyException {
		System.out.println("Throwing MyException from funG()");
		throw new MyException("Originated in funG()");
	}

	public static void main(String[] args) {
		try {
			fun();
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}

		try {
			funG();
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}
	}
}
/**Output:
Throwing MyException from fun()
com.github.tij4.chap12.MyException
	at com.github.tij4.chap12.FullConstructors.fun(FullConstructors.java:16)
	at com.github.tij4.chap12.FullConstructors.main(FullConstructors.java:26)
Throwing MyException from funG()
com.github.tij4.chap12.MyException: Originated in funG()
	at com.github.tij4.chap12.FullConstructors.funG(FullConstructors.java:21)
	at com.github.tij4.chap12.FullConstructors.main(FullConstructors.java:32)
 
 */
