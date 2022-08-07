package dndtracker;

import java.util.LinkedList;
import java.util.Queue;

public class Calendar {
    private Queue<Month> months;
    private Month currentMonth;
    private int numOfMonths;
    private int numOfDaysInWeek;
    private int dayOfWeek;
    private int yearNumber;

    public Calendar() {
        months = new LinkedList<Month>();
    }

    public Calendar(int numOfDaysInWeek, int numOfMonths, int yearNumber) {
        this.setNumOfDaysInWeek(numOfDaysInWeek);
        this.setNumOfMonths(numOfMonths);
        this.setYearNumber(yearNumber);
        months = new LinkedList<Month>();
    }

    public void addMonth(String name, int numOfDays) {
        months.add(new Month(name, numOfDays));
    }

    public String getCurrentMonthName() {
        return currentMonth.getName();
    }

    public int getNumOfDaysInWeek() {
        return numOfDaysInWeek;
    }

    public void setNumOfDaysInWeek(int numOfDaysInWeek) {
        this.numOfDaysInWeek = numOfDaysInWeek;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Month nextMonth() {
        months.add(currentMonth);
        currentMonth = months.remove();
        return currentMonth;
    }

    public int getNumOfMonths() {
        return numOfMonths;
    }

    private void setNumOfMonths(int numOfMonths) {
        this.numOfMonths = numOfMonths;
    }

    public String toString() {
        String out = "";
        out += this.getYearNumber() + " " + this.getNumOfDaysInWeek() + " " + this.getDayOfWeek() + " "
                + this.getNumOfMonths() + "\n";
        return out;
    }

    public int getYearNumber() {
        return yearNumber;
    }

    private void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

}
