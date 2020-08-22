package encapsultation.abstractation;

public class EMI {

	static {
		System.out.println("I am a static block in MAIN method");
	}
	
	public static void main(String[] args) {
		
		int principal = 1000;
		Interest sbi = new SBI();
		Interest hdfc =  new HDFC();
		System.out.println("SBI EMI : "+principal*sbi.getInterest()*12+"\n");
		System.out.println("HDFC EMI : "+principal*hdfc.getInterest()*12);
	}

}
