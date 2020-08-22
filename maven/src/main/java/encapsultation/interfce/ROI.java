package encapsultation.interfce;

public class ROI {

	public static void main(String a[]) {
		Interest icici = new ICICI();
		Interest kotak = new KOTAK();
		System.out.println("ICICI ROI : "+icici.getInterest());
		System.out.println("KOTAK ROI : "+kotak.getInterest());
	}
}
