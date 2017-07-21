package com.github.tij4.chap10.innerclasses;

class WithInner {
	class Inner {
	}
}

public class InheritInner extends WithInner.Inner {

	InheritInner(WithInner wi) {
		wi.super();
	}

//	public InheritInner(){
//		(new WithInner()).super();
//	}
	
	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
//		InheritInner ii = new InheritInner();
		ii.show();
	}

	public void show() {
		System.out.println("InheritInner.show()");
	}

}
