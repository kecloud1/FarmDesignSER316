package main.java;

//Implementation of strategy design pattern
public interface Produces {

    public String produces();
}

class ProducesMilk implements Produces {

    @Override
    public String produces() {
        return "Milk";
    }
    
}

class ProducesEggs implements Produces {

    @Override
    public String produces() {
        return "Egg";
    }
    
}

class ProducesBacon implements Produces {

    @Override
    public String produces() {
        return "Bacon";
    }
    
}