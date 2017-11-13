package com.github.tij4.chap12.exceptions;

public class WithFinally {

	static Switch sw = new Switch();
	public static void main(String[] args) {
		try {
			sw.on();
			OnOffSwitch.f();
		} catch(OnOffException e){
			System.out.println("OnOffException");
		}catch(OnOffException1 e){
			System.out.println("OnOffExceptin1");
		}finally {
			sw.off();
		}
	}
	/**
on
f();
off
	 */
}
