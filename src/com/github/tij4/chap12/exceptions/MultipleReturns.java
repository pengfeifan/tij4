package com.github.tij4.chap12.exceptions;

public class MultipleReturns {

	public static void f(int i){
		System.out.println("Initialization that return requires cleanup");
		try{
			System.out.println("Point 1");
			if(i==1){
				return;
			}
			System.out.println("Point 2");
			if(i==2){
				return;
			}
			System.out.println("Point 3");
			if(i==3){
				return;
			}
			System.out.println("end");
		}finally{
			System.out.println("Performing cleanup");//
		}
	}
	
	public static void main(String[] args) {
		for(int i=1;i<=4;i++){
			f(i);
		}
	}
	/**
Initialization that return requires cleanup
Point 1
Performing cleanup
Initialization that return requires cleanup
Point 1
Point 2
Performing cleanup
Initialization that return requires cleanup
Point 1
Point 2
Point 3
Performing cleanup
Initialization that return requires cleanup
Point 1
Point 2
Point 3
end
Performing cleanup

	 */
}
