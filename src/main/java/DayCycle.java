package main.java;

import java.util.ArrayList;

public class DayCycle implements Subject {
    
    private static ArrayList<Observer> observers = new ArrayList<Observer>();
    private boolean isDay;

    public DayCycle() {
        isDay = true;
        notifyObserver();
    }

    public static void register(Observer o) {
        observers.add(o);
        
    }

    public static void unregister(Observer o) {
        observers.remove(o);
        
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update(isDay);
        }
    }

    public void switchToDay() {
        isDay = true;
        notifyObserver();
    }
    
    public void switchToNight() {
        isDay = false;
        notifyObserver();
    }
    
    public boolean isDay() {
        if (isDay == true) {
            return true;
        }
        return false;
    }
    
}
