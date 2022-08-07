package dndtracker.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleMatcher {
	public static Matcher getMatcher(String pattern, String in) {
		Pattern patt = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		return patt.matcher(in);
	}
}
