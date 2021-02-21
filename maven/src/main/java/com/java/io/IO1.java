package com.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.Test;

public class IO1 {

	@Test
	public void io1() throws IOException {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("test1.txt");
			fout.write(65);
			System.out.println("success...");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			fout.close();
		}
	}

	@Test
	public void io2() throws IOException {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("test1.txt");
			String s = "Hello this is test string...";
//			s.getBytes();
			fout.write(s.getBytes());
			System.out.println("success...");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			fout.close();
		}
	}

	@Test
	public void io3() throws FileNotFoundException {
		FileInputStream input = new FileInputStream("test1.txt");
		try {
			System.out.println((char) input.read()); // Read single character
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void io4() throws FileNotFoundException {
		FileInputStream input = new FileInputStream("test1.txt");
		try {
			int i =0;
			while ((i=input.read())!=-1) {
				System.out.print((char) i);
			} // Read all character
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void io5() throws IOException {
		BufferedInputStream input = new BufferedInputStream(new FileInputStream("test1.txt"));
		int i;
		while((i=input.read())!=-1) {
			System.out.print((char)i);
		}
		input.close();
	}
	
	@Test
	public void io6() throws IOException {
		BufferedOutputStream output = null;
		try {
			output = new BufferedOutputStream(new FileOutputStream("test1.txt"));
			String s = "This is true";
			output.write(s.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			output.close();
		}
	}
}
