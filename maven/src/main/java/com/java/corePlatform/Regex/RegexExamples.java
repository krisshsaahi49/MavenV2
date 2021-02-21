package com.java.corePlatform.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class RegexExamples {

	@Test
	public void emailValidator() {
		List<String> emails = new ArrayList<String>();
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user1@domain.com");
		emails.add("user.name@domain.com");
		emails.add("user#@domain.co.in");
		emails.add("user@domaincom");

		// Invalid emails
		emails.add("user#domain.com");
		emails.add("@yahoo.com");

		String regex = "^(.+)@(.+)$";

		Pattern pattern = Pattern.compile(regex);

		for (String email : emails) {
			Matcher matcher = pattern.matcher(email);
			System.out.println(email + " : " + matcher.matches());
		}
	}
	
	@Test
	public void ex2() {
		List<String> emails = new ArrayList<String>();
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user1@domain.com");
		emails.add("user.name@domain.com");
		emails.add("user_name@domain.co.in");
		emails.add("user-name@domain.co.in");
		emails.add("user@domaincom");
		 
		//Invalid emails
		emails.add("@yahoo.com");
		
		String regex = "^[A-Za-z0-9._-]+@(.+)$";
		
		for(String s : emails) {
			System.out.println(s+ " - "+Pattern.matches(regex, s));
		}
		
	}
	
	@Test
	public void ex1() {
		String s = "will match color or colour";
//		System.out.println(Pattern.matches(".*(colou?r)", s));
		Pattern p = Pattern.compile("colou?r", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(s);
		
		while(m.find()) {
			System.out.println(m.group());
		}
	}
}
