package com.github.tij4.chap12;

public class Rethrowing {
	
	public static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("thrown from f()");
	}

	public static void g() throws Exception {
		try{
			f();
		}catch (Exception e){
			System.out.println("Inside g().e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	public static void h() throws Exception {
		try{
			f();
		}catch (Exception e){
			System.out.println("inside h().e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception) e.fillInStackTrace(); //
		}
	}
	
	public static void main(String[] args) {
		try{
			System.out.println("start-g()");
			g();
		}catch (Exception e){
			System.out.println("main-g(): printStackTrace()");
			e.printStackTrace(System.out);
		}
		System.out.println("#########################");
		try{
			System.out.println("start-h()");
			h();
		}catch (Exception e){
			System.out.println("main-h(): printStackTrace()");
			e.printStackTrace(System.err);
		}
	}
	
	/**
start-g()
originating the exception in f()
Inside g().e.printStackTrace()
java.lang.Exception: thrown from f()
	at com.github.tij4.chap12.Rethrowing.f(Rethrowing.java:7)
	at com.github.tij4.chap12.Rethrowing.g(Rethrowing.java:12)
	at com.github.tij4.chap12.Rethrowing.main(Rethrowing.java:33)
main-g(): printStackTrace()
java.lang.Exception: thrown from f()
	at com.github.tij4.chap12.Rethrowing.f(Rethrowing.java:7)
	at com.github.tij4.chap12.Rethrowing.g(Rethrowing.java:12)
	at com.github.tij4.chap12.Rethrowing.main(Rethrowing.java:33)
#########################
start-h()
originating the exception in f()
inside h().e.printStackTrace()
java.lang.Exception: thrown from f()
	at com.github.tij4.chap12.Rethrowing.f(Rethrowing.java:7)
	at com.github.tij4.chap12.Rethrowing.h(Rethrowing.java:22)
	at com.github.tij4.chap12.Rethrowing.main(Rethrowing.java:41)
main-h(): printStackTrace()
java.lang.Exception: thrown from f()
	at com.github.tij4.chap12.Rethrowing.h(Rethrowing.java:26)
	at com.github.tij4.chap12.Rethrowing.main(Rethrowing.java:41)

	 */
}
