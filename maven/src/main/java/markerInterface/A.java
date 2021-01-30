package markerInterface;

//Interface which doesnt have body (i.e no methods, fields etc) 

public class A implements Cloneable{

	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.getClass());
		System.out.println(a.hashCode());
		System.out.println(a.toString());
		System.out.println(a);
	}
}
