package coding.practice.arrays;

public class TestString {

	public static void main(String[] args) {
		// Before interning
		String s1 = "Ryu"; s1 = s1+"zaki";
		String s2 = "Ry";  s2 = s2+"uzaki";
		
		if(s1==s2) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		// after interning
		String s3 = s1.intern();
		String s4 = s2.intern();
		
		if(s3==s4) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
	}

}
