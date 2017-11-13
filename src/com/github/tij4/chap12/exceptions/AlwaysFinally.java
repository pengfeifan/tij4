package com.github.tij4.chap12.exceptions;

class FourException extends Exception{}

public class AlwaysFinally {

	public static void main(String[] args) {
		System.out.println("Enter first try block");
		try{
			System.out.println("Enter second try block");
			try{
				throw new FourException();
			}finally{
				System.out.println("finally in 2nd try block");
			}
		}catch (FourException e){
			System.out.println("Caught fourexception in 1st try block");
		}finally{
			System.out.println("finally in 1st try block");
		}
	}
	/**
Enter first try block
Enter second try block
finally in 2nd try block
Caught fourexception in 1st try block
finally in 1st try block
	 */
}
