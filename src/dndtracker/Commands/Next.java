package dndtracker.Commands;

import java.util.ArrayList;

import dndtracker.DataTypes.Receiver;
import dndtracker.Interfaces.*;

public class Next implements Command {

	@Override
	public void execute(Receiver receiver) {
		ArrayList<String> args = receiver.getArgs();
	}

	@Override
	public boolean command(String toCompare) {
		return toCompare.equals("NEXT");
	}

}
