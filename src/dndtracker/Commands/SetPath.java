package dndtracker.Commands;

import dndtracker.Interfaces.Command;
import dndtracker.Interfaces.Receiver;

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
