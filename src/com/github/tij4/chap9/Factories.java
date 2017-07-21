package com.github.tij4.chap9;

// 工厂方法设计模式
interface Service {
	void method1();

	void method2();
}

interface ServiceFactory {
	Service getService();
}

class Implementation1 implements Service {

	Implementation1() {
	}

	@Override
	public void method1() {
		System.out.println("Implementation1 method1");
	}

	@Override
	public void method2() {
		System.out.println("Implementation1 method2");
	}

}

class Implementation1Factory implements ServiceFactory {

	@Override
	public Service getService() {
		return new Implementation1();
	}

}

class Implementation2 implements Service {

	Implementation2() {
	}

	@Override
	public void method1() {
		System.out.println("Implementation2 method1");
	}

	@Override
	public void method2() {
		System.out.println("Implementation2 method2");
	}

}

class Implementation2Factory implements ServiceFactory {

	@Override
	public Service getService() {
		return new Implementation2();
	}

}

public class Factories {

	public static void serviceConsumer(ServiceFactory factory) {
		Service srvc = factory.getService();
		srvc.method1();
		srvc.method2();
	}

	public static void main(String[] args) {
		serviceConsumer(new Implementation1Factory());
		serviceConsumer(new Implementation2Factory());
	}

}
/*Output:
Implementation1 method1
Implementation1 method2
Implementation2 method1
Implementation2 method2
 */
