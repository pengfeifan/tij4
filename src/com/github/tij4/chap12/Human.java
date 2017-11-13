package com.github.tij4.chap12;

class Annoyance extends Exception{}

class Sneeze extends Annoyance{}

public class Human {

	public static void main(String[] args) {
		try{
			throw new Sneeze();
		}catch(Sneeze e){
			System.out.println("Caught Sneeze");
		}catch(Annoyance e){
			System.out.println("Caught Annoyance");
		}
		try{
			throw new Sneeze();
		}catch(Annoyance e){
			System.out.println("======Caught==Annoyance");
		}
	}
	/**
Caught Sneeze
======Caught==Annoyance

	 */
}
