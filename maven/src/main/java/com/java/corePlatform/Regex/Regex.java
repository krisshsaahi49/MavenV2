package com.java.corePlatform.Regex;

import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class Regex {

	@Test
	public void regex() {
		System.out.println(Pattern.matches(".", "h")); // true , . matches only single character
		System.out.println(Pattern.matches(".", "ssh hsad")); // false , . doesnt matches only multiple characters
		System.out.println(Pattern.matches(".*", "heimdal in asgard")); // true , .* matches anything including empty
																		// string
		System.out.println(Pattern.matches(".*", "")); // true , .* matches anything including empty string
		System.out.println(Pattern.matches("^h", "h")); // true , ^ matches only beginning of the string and single
														// character
		System.out.println(Pattern.matches("^h", "hh")); // false , ^ matches beginning but has multiple characters
		System.out.println(Pattern.matches("^h.*", "heimdal is bad boy")); // true , ^ matches only beginning of the
																			// string and rest assured can be anything
																			// (.*)'
		System.out.println(Pattern.matches(".*h$", "harsh")); // true, $ matches last character (in case it has to match
																// h)
		System.out.println(Pattern.matches(".*h$", "harsh")); // true, $ matches last character (in case it has to match
																// h)
		System.out.println(Pattern.matches("wil?ma", "wima")); // true, ? matches with preceding character 0 or 1 time
																// (in this case 0 occurence of l in wima)
		System.out.println(Pattern.matches("wil?ma", "wilma")); // true, ? matches with preceding character 0 or 1 time
																// (in this case 1 occurence of l in wilma)
		System.out.println(Pattern.matches("[abc]", "a")); // true, [] matches any of the character within [] brackets
															// to single character (in this case a or b or c matches
															// with single character a
		System.out.println(Pattern.matches("[abc]", "b")); // true, [] matches any of the character within [] brackets
															// to single character (in this case a or b or c matches
															// with single character b
		System.out.println(Pattern.matches("[abc]", "ca")); // false, [] matches any of the character within [] brackets
															// to single character (in this case a or b or c matches
															// with two character ca
		System.out.println(Pattern.matches("[abc]*", "acb")); // true, [] matches any of the character within []
																// brackets
																// to single character (in this case a or b or c matches
																// with acb with mulltiple occurances coz of *
		System.out.println(Pattern.matches("[abc]*", "aaaccbabbbaaccaa")); // true, [] matches any of the character
																			// within [] brackets
		// to single character (in this case a or b or c matches
		// with single character a
		System.out.println(Pattern.matches(".*[a-d]$", "I am talking shit a")); // true
		System.out.println(Pattern.matches("[^a-g]", "h")); // true
		System.out.println(Pattern.matches("[^a-g]", "b")); // false
		System.out.println(Pattern.matches(".*[a-d]*", " hail caesar and stalin I dont care")); // false

	}

	@Test
	public void regex1() {

		final String EXAMPLE_TEST = "This is my small example " + "string which I'm going to "
				+ "use for pattern matching.";

		System.out.println(EXAMPLE_TEST);

		System.out.println(EXAMPLE_TEST.matches("\\w.*"));
		String[] splitString = (EXAMPLE_TEST.split("\\s+"));
		System.out.println(splitString.length);// should be 14
		for (String string : splitString) {
			System.out.println(string);
		} // replace all whitespace with tabs
		System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));

	}
	
	@Test
	public void regex2() {
		String TEST_STRING = "++ ++ ??";
		System.out.println(TEST_STRING.matches("\\W*"));  // zero or more non word character
	}
	
	@Test
	public void regex3() {
		String s = "abcde@xyz.com";
		System.out.println(Pattern.matches(".+(?:\\.)+", s));
	}

}
