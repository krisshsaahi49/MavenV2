package garbage;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Test2 extends PrintStream {

	String b = "Krissh";

	public Test2(String b) throws FileNotFoundException {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void println(String a) {
		a = "Krrissh";
	}
	
	public static void main(String b[]) {
		System.out.println("saahi");
		Test3 t = new Test3();
		System.out.println(t.test(t));
	}
}
