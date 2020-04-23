package main.java;

//Implementation of strategy design pattern
public interface Produces {

    public String produces();
}

class producesMilk implements Produces{

    @Override
    public String produces() {
        return "Milk";
    }
    
}

class producesEggs implements Produces{

    @Override
    public String produces() {
        return "Egg";
    }
    
}

class producesBacon implements Produces{

    @Override
    public String produces() {
        return "Bacon";
    }
    
}