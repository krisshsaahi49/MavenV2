package garbage;

public class Test1 {
	private String a = "dude..";
	private static String b = "saahi";
	public void a() {
		Test1 t = new  Test1();
		System.out.println(t);
	}

	/*
	 * public Test1 test() { return new Test1(); }
	 */
	
	@Override
	public String toString() {
		return "ReferenceExample [status=" + a + b+ "]";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 t = new  Test1();
		System.out.println(t.toString());
		//t.a();
	}

}
