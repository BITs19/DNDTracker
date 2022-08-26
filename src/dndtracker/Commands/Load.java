package dndtracker.Commands;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import dndtracker.DataTypes.Receiver;
import dndtracker.Interfaces.Command;

public class Load implements Command {

	@Override
	public void execute(Receiver receiver) {
		try {
			FileInputStream fileIn = new FileInputStream(receiver.getPath());
			ObjectInputStream in = new ObjectInputStream(fileIn);
			receiver.setNextReceiver((Receiver) in.readObject());
		}catch(Exception e) {
			System.out.println("Error loading receiver from file: " + e);
		}
	}

	@Override
	public boolean command(String toCompare) {
		return toCompare.equals("LOAD");
	}

}
