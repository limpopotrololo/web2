package Beans;


import java.io.Serializable;


public class Bean implements Serializable {
    private static final long serialVersionUID = 23423423L;
    private double x;
    private double y;
    private double r;
    private String currentTime;
    private String computingTime;
    private boolean result;


    public Bean(double x, double y, double r, String currentTime, String computingTime, boolean result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.computingTime = computingTime;
        this.result = result;
    }

    public Bean() {
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public String getComputingTime() {
        return computingTime;
    }

    public boolean isResult() {
        return result;
    }
}
