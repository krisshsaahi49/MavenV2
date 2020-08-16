package lamdaExpressions;

import java.util.*;

public class CollectionsSorting {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(205);
		al.add(102);
		al.add(98);
		al.add(275);
		al.add(203);
		System.out.println("Elements of the ArrayList " + "before sorting : " + al);

//		Collections.sort(al, (a1,a2)-> (a1>a2) ? -1 : (a1<a2) ? 1 : 0);

		// using lambda expression in place of comparator object
		Collections.sort(al, (o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0);

		System.out.println("Elements of the ArrayList after" + " sorting : " + al);

		TreeSet<Integer> h = new TreeSet<Integer>((o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0);
		h.add(850);
		h.add(235);
		h.add(1080);
		h.add(15);
		h.add(5);
		System.out.println("Elements of the TreeSet after" + " sorting are: " + h);
	}
}
