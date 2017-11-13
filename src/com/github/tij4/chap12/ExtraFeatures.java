package com.github.tij4.chap12;

class MyException2 extends Exception {
	private int x;

	public MyException2() {
	}

	public MyException2(String msg) {
		super(msg);
	}

	public MyException2(String msg, int x) {
		super(msg);
		this.x = x;
	}

	public int val() {
		return x;
	}

	public String getMessage() {
		return "Detail Message " + x + " " + super.getMessage();
	}
}

public class ExtraFeatures {

	public static void fun() throws MyException2 {
		System.out.println("Throwing MyException2 from fun()");
		throw new MyException2();
	}

	public static void funG() throws MyException2 {
		System.out.println("Throwing MyException2 from funG()");
		throw new MyException2("Originated in funG()");
	}

	public static void funH() throws MyException2 {
		System.out.println("Throwing MyException2 from funH()");
		throw new MyException2("Originated in funH()", 99);
	}

	public static void main(String[] args) {
		try {
			fun();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		try {
			funG();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		try {
			funH();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
			System.out.println("e.val()=" + e.val());
		}
	}
}
/*Output:
Throwing MyException2 from fun()
com.github.tij4.chap12.MyException2: Detail Message 0 null
	at com.github.tij4.chap12.ExtraFeatures.fun(ExtraFeatures.java:31)
	at com.github.tij4.chap12.ExtraFeatures.main(ExtraFeatures.java:46)
Throwing MyException2 from funG()
com.github.tij4.chap12.MyException2: Detail Message 0 Originated in funG()
	at com.github.tij4.chap12.ExtraFeatures.funG(ExtraFeatures.java:36)
	at com.github.tij4.chap12.ExtraFeatures.main(ExtraFeatures.java:51)
Throwing MyException2 from funH()
com.github.tij4.chap12.MyException2: Detail Message 99 Originated in funH()
	at com.github.tij4.chap12.ExtraFeatures.funH(ExtraFeatures.java:41)
	at com.github.tij4.chap12.ExtraFeatures.main(ExtraFeatures.java:56)
e.val()=99
 */
