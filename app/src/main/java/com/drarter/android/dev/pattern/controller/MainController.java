package com.drarter.android.dev.pattern.controller;

import com.drarter.android.dev.pattern.model.Motor;
import com.drarter.android.dev.pattern.model.Vehicle;

public class MainController {

    private Vehicle vehicle;

    public MainController() {
        this.vehicle = new Vehicle(new Motor());
    }

    public void increaseSpeed(int value) {
        this.vehicle.increaseSpeed(value);
    }

    public void stop() {
        this.vehicle.stop();
    }

    public int getSpeed() {
        return this.vehicle.getSpeed();
    }

    public String getSpeedResultText() {
        return String.format("speed : %d", this.vehicle.getSpeed());
    }
}
