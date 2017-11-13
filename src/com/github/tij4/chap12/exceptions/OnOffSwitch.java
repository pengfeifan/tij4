package com.github.tij4.chap12.exceptions;

public class OnOffSwitch {

	private static Switch sw = new Switch();
	public static void f() throws OnOffException,OnOffException1{
		System.out.println("f();");
	}
	
	public static void main(String[] args) {
		try{
			sw.on();
			f();
			sw.off();
		}catch(OnOffException e){
			System.out.println("OnOffException");
			sw.off();
		}catch(OnOffException1 e){
			System.out.println("OnOffExceptin1");
			sw.off();
		}
	}
	/**
on
f();
off
	 */
}
