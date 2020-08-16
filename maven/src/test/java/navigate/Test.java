package navigate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
	    InputStream input = null;
	    OutputStream output = null;
		try {

	        input = new FileInputStream("application.properties");

	        // load a properties file
	        prop.load(input);

	        // get the property value and print it out
	        System.out.println(prop.getProperty("driver.chrome"));
	        System.out.println(prop.getProperty("driver.Chrome"));
	        // Write to properities file
	        prop.setProperty("driver.chrome", "edge");
	        output = new FileOutputStream("application.properties");
	        prop.save(output, "Updated driver.chrome");
	        System.out.println(prop.getProperty("driver.chrome"));
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (input != null) {
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	}

}
