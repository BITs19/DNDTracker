package dndtracker.Interfaces;

import dndtracker.DataTypes.Receiver;

public interface Command {
	public void execute(Receiver receiver); // executes the command
	public boolean command(String toCompare); // returns true if the provided string matches the command call pattern
}
