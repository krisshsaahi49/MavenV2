package garbage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test6 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}

		list.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		});
	}

}
