package dndtracker;

import java.util.ArrayList;

public class Next implements Command {

	@Override
	public void execute(Receiver receiver) {
		ArrayList<String> args = receiver.getArgs();
		if (args.size() < 1)
			return;
		String comm = args.get(0);
		if (comm.equals("MONTH"))
			receiver.nextMonth();
	}

	@Override
	public boolean command(String toCompare) {
		return toCompare.equals("NEXT");
	}

}
