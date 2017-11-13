package com.github.tij4.chap12;

public class NeverCaught {

	static void f(){
		throw new RuntimeException("From f()");
	}
	static void g(){
		f();
	}
	
	public static void main(String[] args){
		g();
	}
	/**
Exception in thread "main" java.lang.RuntimeException: From f()
	at com.github.tij4.chap12.NeverCaught.f(NeverCaught.java:6)
	at com.github.tij4.chap12.NeverCaught.g(NeverCaught.java:9)
	at com.github.tij4.chap12.NeverCaught.main(NeverCaught.java:13)
	 */
}
