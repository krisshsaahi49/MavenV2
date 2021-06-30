package httpUrlConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class WebAppStatus {

	@Test
	public void checkStatus() throws IOException {
		URL url = new URL("http://ww6.fmovie.sc/");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		int status;
		try {
			status = connection.getResponseCode();
			System.out.println("STATUS : "+status);
			System.out.println(connection.getResponseMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("DNS NOT FOUND");
		}
		
	}
}
