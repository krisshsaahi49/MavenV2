package coding.practice.arrays;

public class TestMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5, j = 6;
		double value = a(i, j, 0);
		System.out.println(value);
	}

	static int a(int i, int j, int count) {
		int sum = i + j;
		/*
		 * if (count < 1) return 0;
		 */

		for (int a = 0; a < count; a++) {
			System.out.println(sum);
		}
		return sum;
	}

}
