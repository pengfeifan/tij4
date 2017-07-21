package com.github.tij4.chap10;

public class DotNew {

	public class Inner {
		public void f() {
			System.out.println("Inner.f() " + getClass().getSimpleName());
		}
	}

	public static void main(String[] args) {
		DotNew dn = new DotNew();
		DotNew.Inner dni = dn.new Inner();
		dni.f();
	}
}
/*
Inner.f() Inner
 */
