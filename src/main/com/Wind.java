package com;

public class Wind {

    private double speed;
    private double deg;

    public Wind() {
    }

    public Wind (double speed, double deg){
        this.speed = speed;
        this.deg = deg;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "src.main.com.Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
