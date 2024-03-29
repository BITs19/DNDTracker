package dndtracker.DataTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

import dndtracker.Utility.NestedBracketParser;
import dndtracker.Utility.SimpleMatcher;

public class Calendar implements Serializable {
	private static final long serialVersionUID = -2692098215974729114L;
	private List<Month> months;
	private int currentDate;
	private List<String> weekDays;

	public Calendar() {
		months = new ArrayList<Month>();
		weekDays = new ArrayList<String>();
	}

	public void setMonths(List<Month> in) {
		months = in;
	}

	public List<Month> getMonths() {
		return months;
	}

	public void setDate(int in) {
		currentDate = in % getDaysInYear();
	}

	public int getDate() {
		return currentDate;
	}

	public void setWeekDays(List<String> in) {
		weekDays = in;
	}

	public List<String> getWeekDays(){
		return weekDays;
	}

	public int incrementDate() {
		setDate(currentDate + 1);
		return getDate();
	}

	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("{Calendar:months=[");
		for (Month m : months) {
			out.append(m.toString());
			if (m != months.get(months.size() - 1)) {
				out.append(',');
			}
		}
		out.append("];currentDate=");
		out.append(getDate());
		out.append(";weekdays=[");
		for(String s : weekDays) {
			out.append(s);
			if(s != weekDays.get(weekDays.size() - 1)) {
				out.append(',');
			}
		}

		out.append("];}");
		return out.toString();
	}

	public int getDaysInYear() {
		int out = 0;

		for(Month m : getMonths()) {
			out += m.getDays();
		}

		return out;
	}

	public String getCurrentDateString() {		
		int tempDay = 0;
		int index = 0;
		Month m = new Month();
		m.setDays(0);
		do {
			tempDay += m.getDays();
			m = months.get(index++);
		}while(tempDay <= currentDate && currentDate < tempDay + m.getDays()) ;

		int num = currentDate - tempDay + 1;
		String out = m.getName() + " the " + num;
		return out;
	}

	@Deprecated
	public static Calendar parse(String in) {
		Calendar out = new Calendar();

		List<Month> outMonths = new ArrayList<Month>();		
		Matcher months = SimpleMatcher.getMatcher("months=\\[((?>\\{Month:[^,\\]]*\\},?)*)\\]", in);
		if (months.find()) {
			String match = months.group(1);
			if (match.length() != 0) {
				int startingIndex = 0;
				while(startingIndex < match.length()) {
					String monthString = NestedBracketParser.parse(match, startingIndex);
					startingIndex += monthString.length();
					Month month = Month.parse(monthString);
					outMonths.add(month);
				}
			}
		}
		out.setMonths(outMonths);

		Matcher currentDateMatch = SimpleMatcher.getMatcher("name=(\\d+);", in);
		if(currentDateMatch.find()) {
			out.setDate(Integer.parseInt(currentDateMatch.group(1)));
		}

		Matcher weekDaysMatch = SimpleMatcher.getMatcher("weekDays=\\[([^\\]]*)\\]", in);
		if(weekDaysMatch.find()) {
			String[] temp = weekDaysMatch.group(1).split(",");
			out.setWeekDays(Arrays.asList(temp));
		}

		return out;
	}


}
