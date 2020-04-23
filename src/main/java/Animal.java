package main.java;

public abstract class Animal {
    private String name;
    private int daysOld;
    private boolean isProducingAge = false;
    private String produces;
    private int quality;
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return this.daysOld;
    }
    
    protected void isBorn() {
        daysOld = 0;
    }
    
    public boolean isProducingAge() {
        if (isProducingAge) {
            return isProducingAge;
        }
        if (daysOld > 3) {
            isProducingAge = true;
            return isProducingAge;
        }
        return isProducingAge;
    }
    
    public String getProduct() {
        return produces;
    }
    
    public void setProduct(String produces) {
        this.produces = produces;
    }
    
    public String toString() {
        String toString = "This animal is a " + name + ".";
        return toString;
    }
    
    public int getQuality() {
        return quality;
    }
    
    public void setQuality(int qual) {
        this.quality = qual;
    }
}
