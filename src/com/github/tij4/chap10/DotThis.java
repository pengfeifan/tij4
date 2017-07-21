package com.github.tij4.chap10;

public class DotThis {

	void f() {
		System.out.println("DotThis.f() " + getClass().getSimpleName());
	}

	public class Inner {
		public DotThis outer() {
			return DotThis.this;
		}
	}

	public Inner inner() {
		return new Inner();
	}

	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner dti = dt.inner();
		dti.outer().f();
	}

}
/*Output:
DotThis.f() DotThis
*/