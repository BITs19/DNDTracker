package dndtracker.Interfaces;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import dndtracker.DataTypes.Calendar;

public class Receiver {
	private ArrayList<String> currentArgs;
	private ArrayList<Observer> observers;
	private Calendar calendar;
	private String savePath = null;
	public Receiver() {
		init();
	}
	
	public Receiver(String path) {
		init();
		File f = new File(path);
		String saveData;
		try {
			f.createNewFile();
			Path filePath = f.toPath();
			saveData = Files.readString(filePath);
			savePath = path;
		}catch(Exception e) {
			System.err.println("Error creating file; " + e);
			System.exit(1);
		}
		
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
	
	public Calendar getCalendar() {
		return calendar;
	}
	
	private void init() {
		observers = new ArrayList<Observer>();
		currentArgs = new ArrayList<String>();
		calendar = new Calendar();
	}
	
	public void setPath(String path) {
		savePath = path;
	}
	
	public boolean save() {
		if(savePath == null) {
			System.out.println("Error saving; savepath null");
			return false;
		}
		File f = new File(savePath);
		PrintWriter printer;
		try {
			f.createNewFile();
			printer = new PrintWriter(f);
			printer.print(this.toString());
			printer.close();
			return true;
		}catch(Exception e) {
			System.out.println("Exception saving receiver; " + e.toString());
		    return false;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("{Receiver:");
		out.append(calendar.toString());
		out.append(";}");
		return out.toString();
	}
}