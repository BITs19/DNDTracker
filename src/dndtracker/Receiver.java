package dndtracker;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Receiver {
	ArrayList<String> currentArgs;
	ArrayList<Observer> observers;
	
	ArrayList<String> months;
	String currentMonth = "";
	
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
		}catch(Exception e) {
			System.err.println("Error creating file; " + e);
			System.exit(1);
		}
		while(in.hasNext()) {
			months.add(in.nextLine());
		}
		currentMonth = months.get(0);
	}
	
	public ArrayList<String> getArgs(){
		return currentArgs;
	}
	
	@SuppressWarnings("unchecked")
	public void setArgs(ArrayList<String> in) {
		currentArgs = (ArrayList<String>)in.clone();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	private void notifyAll(String s) {
		for(Observer o : observers) {
			o.notify(s);
		}
	}
	
	private void initArrays() {
		observers = new ArrayList<Observer>();
		currentArgs = new ArrayList<String>();
		months = new ArrayList<String>();
	}
	
	public void nextMonth() {
		int index = months.indexOf(currentMonth);
		index++;
		if(index >= months.size()) {
			index = 0;
		}
		
		currentMonth = months.get(index);
		
		notifyAll("MONTH="+currentMonth);
	}
}
