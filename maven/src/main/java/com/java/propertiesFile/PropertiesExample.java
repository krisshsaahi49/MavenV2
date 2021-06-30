package com.java.propertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

import org.testng.annotations.Test;

public class PropertiesExample {

	@Test
	public void loadProperty() {
		try {
			FileInputStream input =  new FileInputStream("application.properties");
			Properties props = new Properties();
			props.load(input);
			props.setProperty("db", "com.oracle");
			System.out.println(props.getProperty("driver.chrome"));
			props.setProperty("db", "com.oracle");
			System.out.println(props.getProperty("db"));
			System.out.println(props.getProperty("caps"));
			System.out.println(Arrays.asList("abc","bcd"));
			input.close();
			/*
			 * FileOutputStream output = new FileOutputStream("application.properties");
			 * props.setProperty("db", "com.oracle"); output.close();
			 */
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
