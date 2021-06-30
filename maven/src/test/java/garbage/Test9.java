package garbage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.testng.annotations.Test;


public class Test9 {
	
	@Test
	public void test() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		
		Consumer<Integer> c = arg0 -> System.out.println(arg0);
		
		list.forEach(c);
		
		list.forEach(Test9::get);	// static Method reference
		
	}
	
	// static Method reference
	public static void get(Integer i) {
		System.out.println(i*i);
	}
	
	@Test
	public void test2() {
		List<Integer> list = Arrays.asList(11,82,43,24,5,66);
		
		List<Integer> updated = list.stream().filter(i -> i>20).map(a->a*a).collect(Collectors.toList());
		System.out.println(updated);
		
		System.out.println(list.stream().filter(i -> i>20).map(a->a*a).max((o1,o2)->o1-o2).get());
		System.out.println(list.stream().filter(i -> i>20).map(a->a*a).mapToInt(a->a).max());	

	}
	
}
