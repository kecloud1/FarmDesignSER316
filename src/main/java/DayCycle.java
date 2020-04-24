package main.java;

import java.util.ArrayList;

public class DayCycle implements Subject {
    
    private ArrayList<Observer> observers;
    private boolean isDay;

    public DayCycle() {
        observers = new ArrayList<Observer>();
        isDay = true;
        notifyObserver();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
        
    }

    @Override
    public void unregister(Observer o) {
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
