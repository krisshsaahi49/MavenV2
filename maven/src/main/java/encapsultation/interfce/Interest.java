package encapsultation.interfce;

public interface Interest {

	// Interface can have static and default methods
	// default method - by default it is public
	default void Default() {
		System.out.println("I am a default method");
	}
	
	// static method
	static void StaticMethod(){
		System.out.println("I am a static method");
	}
	
	int getInterest();
}
