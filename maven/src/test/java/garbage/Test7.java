package garbage;

public class Test7{
	
	public void a() {
		System.out.println("I am overriding method");
	}
	
	public static void main(String[] args) {
		
		String str = "abcde";
		
		for(int i=0;i<str.length();i++){
			for(int j=i+1;j<=str.length();j++) {
				System.out.println(str.substring(i,j));
			}
		}
	}
}
