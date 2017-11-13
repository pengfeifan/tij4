package com.github.tij4.chap12;

class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}

abstract class Inning{
	public Inning() throws BaseballException{}
	
	public void event() throws BaseballException{
	}
	
	public abstract void atEat() throws Strike,Foul;
	public void walk(){}
}

class StormException extends Exception{}
class RainedOut extends StormException{}
class PopFoul extends Foul{}

interface Storm{
	public void event() throws RainedOut;
	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{

	public StormyInning() throws RainedOut,BaseballException{}
	
	public StormyInning(String s) throws Foul,BaseballException{}
	
	public void event(){}
	
	@Override
	public void rainHard() throws RainedOut {
	}

	@Override
	public void atEat() throws PopFoul {
	}

	public static void main(String[] args) {
		try{
			StormyInning si = new StormyInning();
			si.atEat();
		}catch(PopFoul e){
			System.out.println("PopFoul");
		}catch(RainedOut e){
			System.out.println("RainedOut");
		}catch(BaseballException e){
			System.out.println("Generic baseball Exception");
		}
		System.out.println("=========");
		try{
			Inning i = new StormyInning();
			i.atEat();
		}catch(Strike e){
			System.out.println("Strike");
		}catch(Foul e){
			System.out.println("Foul");
		}catch(RainedOut e){
			System.out.println("RainedOut");
		}catch(BaseballException e){
			System.out.println("baseball Exception");
		}
	}
}
