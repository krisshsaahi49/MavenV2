package lib;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class FileUtility {

	public static void writeFile(String directoryName){
	    String PATH =System.getProperty("user.dir");

	    File directory = new File(directoryName);
	    if (! directory.exists()){
	        directory.mkdir();
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }

	}
	
	   
	public String getTimeStamp() {
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyMMddHHmmss");
	        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			return sdf.format(timestamp);
	   }
}
