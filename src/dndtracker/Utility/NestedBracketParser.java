package dndtracker.Utility;

public class NestedBracketParser {
	public static String parse(String in) {
		int indexOfParen = in.indexOf('(');
		int indexOfSquare = in.indexOf('[');
		int indexOfCurly = in.indexOf('{');
		char openBrace;
		char closingBrace;
		int startIndex;
		if (smallestNotNegativeOne(indexOfParen, indexOfSquare, indexOfCurly)) {
			openBrace = '(';
			closingBrace = ')';
			startIndex = indexOfParen;
		} else if (smallestNotNegativeOne(indexOfSquare, indexOfCurly, indexOfParen)) {
			openBrace = '[';
			closingBrace = ']';
			startIndex = indexOfSquare;
		} else if (smallestNotNegativeOne(indexOfCurly, indexOfParen, indexOfSquare)) {
			openBrace = '{';
			closingBrace = '}';
			startIndex = indexOfCurly;
		} else {
			return in;
		}
		
		int endIndex = startIndex + 1;
		int levelCount = 1;
		while(levelCount > 0) {
			if(in.charAt(endIndex) == closingBrace)
				levelCount--;
			else if(in.charAt(endIndex) == openBrace)
			    levelCount++;
			endIndex++;
		}
		return in.substring(startIndex+1,endIndex-1);
	}
	
	public static String parse(String in, int startIndex) {
		String temp = in.substring(startIndex);
		return parse(temp);
	}

	private static boolean smallestNotNegativeOne(int a, int b, int c) {
		return a != -1 && (b == -1 || a < b) && (c == -1 || a < c);
	}

}
