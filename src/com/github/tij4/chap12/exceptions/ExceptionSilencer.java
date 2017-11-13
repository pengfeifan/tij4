package com.github.tij4.chap12.exceptions;

public class ExceptionSilencer {

	public static void main(String[] args) {
		try{
			throw new RuntimeException();
		}finally{
			System.out.println("silence any thrown exception");
			return;
		}
	}
	/**
silence any thrown exception
	 */
}
