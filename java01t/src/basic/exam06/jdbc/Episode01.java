package basic.exam06.jdbc;

interface T {
	
}

class A {
	
}

class B extends A implements T {
	
}

class C extends B {
	
}

public class Episode01 {

	public static void main(String[] args) {
		T t;
		A a = new A();
		B b = new B();
		C c = new C();
		
		B b2 = c;
		A a2 = c;
		T t2 = c;
		
		//C c3 = b;
		A a3 = b;
		T t3 = b;
		
		//T t4 = a; // A는 T를 구현하지 않았다.
		

	}

}



























