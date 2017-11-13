package com.github.tij4.chap12;

class SimpleException extends Exception {
}

public class InheritingExceptions {

	public void fun() throws SimpleException {
		System.out.println("Throw SimpleException from fun()");
		throw new SimpleException();
	}

	public static void main(String[] args) {
		InheritingExceptions sed = new InheritingExceptions();
		try {
			sed.fun();
		} catch (SimpleException e) {
			System.out.println("Caught it!");
		}
	}
}
/** output:
Throw SimpleException from fun()
Caught it!
 */
