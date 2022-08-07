package dndtracker.Commands;

import java.util.ArrayList;
import dndtracker.Interfaces.*;

public class Echo implements Command {

	@Override
	public void execute(Receiver receiver) {
		ArrayList<String> args = receiver.getArgs();
		String out = String.join(" ", args);
		System.out.println(out);
	}

	@Override
	public boolean command(String toCompare) {		
		return toCompare.equals("ECHO");
	}

}
