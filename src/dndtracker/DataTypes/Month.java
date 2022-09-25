package dndtracker.DataTypes;

import java.io.Serializable;
import java.util.regex.Matcher;

import dndtracker.Utility.SimpleMatcher;

public class Month implements Serializable {
	private static final long serialVersionUID = -5358513768313189204L;
	private int days;
	private String name;

	public void setDays(int in) {
		days = in;
	}

	public int getDays() {
		return days;
	}

	public void setName(String in) {
		name = in;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{Month:name=");
		builder.append(this.getName());
		builder.append(";days=");
		builder.append(this.getDays());
		builder.append(";}");
		return builder.toString();
	}

	@Deprecated
	public static Month parse(String in) {
		Month out = new Month();
		Matcher nameMatcher = SimpleMatcher.getMatcher("name=([a-z0-9]*);", in);
		if (nameMatcher.find()) {
			out.setName(nameMatcher.group(1));
		}
		Matcher daysMatcher = SimpleMatcher.getMatcher("days=(\\d)*;", in);
		if (daysMatcher.find()) {
			out.setDays(Integer.parseInt(daysMatcher.group(1)));
		}
		return out;
	}
}
