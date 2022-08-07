package dndtracker;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Receiver {
	ArrayList<String> currentArgs;
	ArrayList<Observer> observers;

	Calendar calendar;

	public Receiver() {
		initArrays();
	}

	public Receiver(String path) {
		initArrays();
		File f = new File(path);
		Scanner in = null;
		try {
			f.createNewFile();
			in = new Scanner(f);
		} catch (Exception e) {
			System.err.println("Error creating file; " + e);
			System.exit(1);
		}
		int numOfMonths = in.nextInt();
		while (numOfMonths-- > 0) {
			String name = in.next();
			int numOfDays = in.nextInt();
			calendar.addMonth(name, numOfDays);
		}
	}

	public ArrayList<String> getArgs() {
		return currentArgs;
	}

	@SuppressWarnings("unchecked")
	public void setArgs(ArrayList<String> in) {
		currentArgs = (ArrayList<String>) in.clone();
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	private void notifyAll(String s) {
		for (Observer o : observers) {
			o.notify(s);
		}
	}

	private void initArrays() {
		observers = new ArrayList<Observer>();
		currentArgs = new ArrayList<String>();
		calendar = new Calendar();
	}

	public void nextMonth() {
		calendar.nextMonth();
		notifyAll("MONTH=" + calendar.getCurrentMonthName());
	}
}
