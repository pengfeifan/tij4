package com.github.tij4.chap12;

public class Cleanup {

	public static void main(String[] args) {
		try{
			InputFile in = new InputFile("README.md");
			try{
				String s;
				int i=1;
				while((s = in.getLine()) != null)
					System.out.println(s);
			}catch(Exception e){
				System.out.println("Caught Exception in main");
				e.printStackTrace(System.out);
			}finally{
				in.dispose();
			}
		}catch(Exception e){
			System.out.println("inputFile construction failed");
		}
	}
	/**
construct of InputFile
# tij4
thinking in Java 4
dispose() successful
	 */
}
