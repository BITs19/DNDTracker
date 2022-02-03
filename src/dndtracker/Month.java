package dndtracker;

public class Month {
    private String name;
    private int numOfDays;
    private int currentDay;

    public Month(String name, int numOfDays) {
        this.name = name;
        this.numOfDays = numOfDays;
    }

    public String getName() {
        return name;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public String toString() {
        return name + " " + numOfDays + "\n";
    }
}
