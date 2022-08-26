package dndtracker.Commands;

import dndtracker.DataTypes.Receiver;
import dndtracker.Interfaces.Command;

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
