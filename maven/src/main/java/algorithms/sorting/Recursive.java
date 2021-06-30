package algorithms.sorting;

public class Recursive {

	public static void main(String[] args) {
		main(10);
	}
	
	static void main(int n) {
		if(n==0) {
			System.out.println("Done");
		}else {
			System.out.println(n);
//			n--;
			main(n--);
		}
	}
}
