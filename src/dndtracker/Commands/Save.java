package dndtracker.Commands;

import dndtracker.Interfaces.Command;
import dndtracker.Interfaces.Receiver;

public class Save implements Command {

	@Override
	public void execute(Receiver receiver) {
		receiver.save();
	}

	@Override
	public boolean command(String toCompare) {
		return toCompare.equals("SAVE");
	}

}
