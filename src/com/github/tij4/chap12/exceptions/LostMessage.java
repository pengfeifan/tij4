package com.github.tij4.chap12.exceptions;

class VeryImportantException extends Exception{
	
	@Override
	public String toString() {
		return "A Very important exception";
	}
}

class HoHumException extends Exception{
	
	@Override
	public String toString() {
		return "A trivaial exception";
	}
}

public class LostMessage {

	void f() throws VeryImportantException{
		throw new VeryImportantException();
	}
	
	void dispose() throws HoHumException{
			throw new HoHumException();
	}
	
	public static void main(String[] args){
		try{
			LostMessage lm = new LostMessage();
			try{
				lm.f();
			}finally{
				lm.dispose();
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	/**
A trivaial exception
	 */
}
