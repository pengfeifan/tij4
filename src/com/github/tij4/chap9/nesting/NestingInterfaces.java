package com.github.tij4.chap9.nesting;

import com.github.tij4.chap9.nesting.A.DImp2;

class A {
	interface B {
		void f();
	}

	public class BImp implements B {
		public void f() {
			System.out.println("classA.ClassBImp.f()");
		}
	}

	private class BImp2 implements B {
		public void f() {
			System.out.println("classA.ClassBImp2.f()");
		}
	}

	public interface C {
		void f();
	}

	class CImp implements C {
		public void f() {
			System.out.println("classA.classCImp.f()");
		}
	}

	private class CImp2 implements C {
		public void f() {
			System.out.println("classA.classCImp2.f()");
		}
	}

	private interface D {
		void f();
	}

	private class DImp implements D {
		public void f() {
			System.out.println("classA.classDImp.f()");
			;
		}
	}

	public class DImp2 implements D {
		public void f() {
			System.out.println("classA.classDImp2.f()");
		}
	}

	public D getD() {
		return new DImp2();
	}

	private D dRef;

	public void receiveD(D d) {
		dRef = d;
		dRef.f();
	}
}

interface E {
	interface G {
		void f();
	}

	public interface H {
		void f();
	}

	void g();
}

public class NestingInterfaces {

	public class BImp implements A.B {
		public void f() {
			System.out.println("NestingInterfaces.BImp.f()");
		}
	}

	class CImp implements A.C {
		public void f() {
			System.out.println("NestingInterfaces.CImp.f()");
		}
	}

	class EImp implements E {
		public void g() {
			System.out.println("NestingInterfaces.EImp.g()");
		}
	}

	class EGImp implements E.G {
		public void f() {
			System.out.println("NestingInterfaces.EGImp.f()");
		}
	}

	class EImp2 implements E {
		public void g() {
			System.out.println("NestingInterfaces.EImp2.g()");
		}

		class EG implements E.G {
			public void f() {
				System.out.println("NestingInterfaces.EImp2.EG.f()");
			}
		}
	}

	public static void main(String[] args) {
		A a = new A();
		// !ERR:A.D ad=a.getD();
		A.DImp2 di2 = (DImp2) a.getD();
		di2.f();
		// !ERR:a.getD().f();
		A a2 = new A();
		a2.receiveD(a.getD());
	}
}
/*Output:
classA.classDImp2.f()
classA.classDImp2.f()
 */
