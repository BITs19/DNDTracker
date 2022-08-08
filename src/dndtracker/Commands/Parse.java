package dndtracker.Commands;

import dndtracker.Interfaces.Command;
import dndtracker.Interfaces.Receiver;

public class Parse implements Command {

	@Override
	public void execute(Receiver receiver) {
		receiver.parse();
	}

	@Override
	public boolean command(String toCompare) {
		return toCompare.equals("PARSE");
	}

}
