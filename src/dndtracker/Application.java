package dndtracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
			
			for(Command c : commands) {
				if(c.command(command)) {
					c.execute(receiver);
					break;
				}
			}
		}while(!command.equals("END"));
			
		stdin.close();
	}

	protected static ArrayList<Command> getCommands(){
		ArrayList<Command> out = new ArrayList<Command>();
		out.add(new Echo());
		return out;
	}

}
