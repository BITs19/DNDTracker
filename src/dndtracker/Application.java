package dndtracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import dndtracker.Interfaces.*;
import dndtracker.Commands.*;
import dndtracker.DataTypes.Receiver;

public class Application {
	
	public static void main(String[] arggs) {
		Scanner stdin = new Scanner(System.in);
		String command = "";
		ArrayList<String> args = new ArrayList<String>();
		Receiver receiver = new Receiver();
		ArrayList<Command> commands = getCommands();
		
		do {			
			System.out.print(">");
			String line = stdin.nextLine();
			String[] tokens = line.split(" ");
			command = tokens[0].toUpperCase();
			args = new ArrayList<String>(Arrays.asList(tokens));
			args.remove(0);
			receiver.setArgs(args);
			boolean executed = false;
			for(Command c : commands) {
				if(c.command(command)) {
					c.execute(receiver);
					executed = true;
					if(receiver.getNextReceiver() != null) receiver = receiver.getNextReceiver();
					break;
				}
			}
			if(!executed && !command.equals("END")) System.out.println("No command found matching: " + command);
		}while(!command.equals("END"));
		
		receiver.save();
		stdin.close();
	}

	protected static ArrayList<Command> getCommands(){
		ArrayList<Command> out = new ArrayList<Command>();
		out.add(new Echo());
		out.add(new AddMonth());
		out.add(new SetPath());
		out.add(new Save());
		out.add(new Load());
		return out;
	}

}
