package garbage;

public class Main2{

	public static void main(String args[]) {
		A a = new A();
//		System.out.println(a.sum());
		System.out.println(a.reurnV());
	}


}

class A {
	int a,b=10;
	
	public int sum() {
		
		return a+b;
		
	}
	
	public int reurnV() {
		return (new A()).sum();
	}
	
	
}
