package com.hassane.limitsservice.domain;

public class Limits {

    private int minimum;
    private int maximun;
    private int min;
    private int max;
    
    public int getMin() {
        return min;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public int getMinimum() {
        return minimum;
    }
    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }
    public int getMaximun() {
        return maximun;
    }
    public void setMaximun(int maximun) {
        this.maximun = maximun;
    }
    
    public Limits(int min, int max, int minimum, int maximun) {
        this.minimum = minimum;
        this.maximun = maximun;
        this.min=min;
        this.max=max;
    }
    @Override
    public String toString() {
        return "Limits [minimum=" + minimum + ", maximun=" + maximun + ", globale min="+ min+ ", globale max="+ max +"]";
    }

    
}
