package garbage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test8 {

	public static void main(String[] args) throws ParseException {
		System.out.println(Math.pow(3, 21) % 5);
		System.out.println(1657%304);
		String ex = "Fri Nov 19 09:05:36 IST 2021";
		System.out.println(ex);
		Date expiry = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(ex);
		System.out.println(expiry);
		
	}
	
}
