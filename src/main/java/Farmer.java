package main.java;

public class Farmer {
    private String name;
    private double quality = 0;
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public String getName() {
        return name;
    }
    
    private void setQuality() {
        while (quality < 1) {
            quality = Math.random() * 10;
        }
    }
    
    public double getQuality() {
        return quality;
    }
    
}
