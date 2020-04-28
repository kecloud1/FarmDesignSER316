package main.java;

import java.util.ArrayList;

public class DayCycle implements Subject {
    
    private static ArrayList<Observer> observers = new ArrayList<Observer>();
    private boolean isDay;
    private int days = 0; 

    /**
     * Constructor for a DayCycle object.
     */
    public DayCycle() {
        isDay = true;
        days = 1;
        notifyObserver();
    }

    /**
     * Method registers an observer.
     * @param o - observer to register.
     */
    public static void register(Observer o) {
        observers.add(o);
        
    }

    /**
     * Method unregisters an observer.
     * @param o - observer to unregister.
     */
    public static void unregister(Observer o) {
        observers.remove(o);
        
    }

    /**
     * Method notifies all observers.
     */
    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(isDay);
        }
    }

    /**
     * Method moves cycle into a new day.
     */
    public void switchToDay() {
        isDay = true;
        days++;
        notifyObserver();
    }
    
    /**
     * Method moves cycle into night time.
     */
    public void switchToNight() {
        isDay = false;
        notifyObserver();
    }
    
    /**
     * Method returns boolean about whether it's day time.
     * @return true if day, false if night.
     */
    public boolean isDay() {
        if (isDay == true) {
            return true;
        }
        return false;
    }
    
    /**
     * Method returns day count.
     * @return days - days since cycle started.
     */
    public int getDays() {
        return days;
    }
}
