package lamdaExpressions;


public class Test3 {
	
	interface a{
		void b();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length = 10;
		a tobj = () -> System.out.println("Drawing "+length);
		tobj.b();
	}

}
