package encapsultation.abstractation;

public abstract class Interest {

	protected abstract int getInterest();

	protected Interest() {
		System.out.println("Dude.......I am a constructor in abstract classs");
	}

	static {
		System.out.println("Dude I am a static block in abstract class");
	}
}
