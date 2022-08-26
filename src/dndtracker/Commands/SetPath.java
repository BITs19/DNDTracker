package dndtracker.Commands;

import dndtracker.DataTypes.Receiver;
import dndtracker.Interfaces.Command;

public class SetPath implements Command {

	@Override
	public void execute(Receiver receiver) {
		if(receiver.getArgs().size() < 1) {
		  System.out.println("Usage: setpath <path>");
		  return;
		}
		receiver.setPath(receiver.getArgs().get(0));
	}

	@Override
	public boolean command(String toCompare) {		
		return toCompare.equals("SETPATH");
	}

}
