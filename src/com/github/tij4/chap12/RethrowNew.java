package com.github.tij4.chap12;

class OneException extends Exception{
	public OneException(String s) {
		super(s);
	}
}

class TwoException extends Exception{
	public TwoException(String s){
		super(s);
	}
}

public class RethrowNew {

	public static void f() throws OneException{
		System.out.println("originating the exception in f()");
		throw new OneException("thrown form f()");
	}
	
	public static void main(String[] args){
		try{
			try{
				f();
			}catch(OneException e){
				System.out.println("Caught in inner try, e.printStackTrace()");
				e.printStackTrace(System.out);
				throw new TwoException("from inner try"); //
			}
		}catch(TwoException e){
			System.out.println("Caught in outer try,e.printStackTrace()");
			e.printStackTrace(System.out);
		}
	}
	/**
originating the exception in f()
Caught in inner try, e.printStackTrace()
com.github.tij4.chap12.OneException: thrown form f()
	at com.github.tij4.chap12.RethrowNew.f(RethrowNew.java:19)
	at com.github.tij4.chap12.RethrowNew.main(RethrowNew.java:25)
Caught in outer try,e.printStackTrace()
com.github.tij4.chap12.TwoException: from inner try
	at com.github.tij4.chap12.RethrowNew.main(RethrowNew.java:29)
	 */
}
