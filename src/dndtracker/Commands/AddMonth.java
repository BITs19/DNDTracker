package dndtracker.Commands;

import java.util.List;

import dndtracker.DataTypes.Calendar;
import dndtracker.DataTypes.Month;
import dndtracker.Interfaces.Command;
import dndtracker.Interfaces.Receiver;

public class AddMonth implements Command {

	@Override
	public void execute(Receiver receiver) {
		
		List<String> args = receiver.getArgs();
		if(args.size() != 2) {
			System.out.println("Usage: addmonth <name> <number of days>");
			return;
		}
		List<Month> months = receiver.getCalendar().getMonths();
		Month month = new Month();
		month.setName(args.get(0));
		try {
			month.setDays(Integer.parseInt(args.get(1)));
		}catch(Exception e) {
			System.out.println("Exception parsing number of days: " + e.toString());
			return;
		}
		months.add(month);
		System.out.println("Added " + receiver.getCalendar().getMonths().get(months.size() - 1).toString());
	}

	@Override
	public boolean command(String toCompare) {
		return toCompare.equals("ADDMONTH");
	}

}
