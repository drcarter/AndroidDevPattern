package com.drarter.android.dev.pattern.presenter;

import com.drarter.android.dev.pattern.model.Motor;
import com.drarter.android.dev.pattern.model.Vehicle;
import com.drarter.android.dev.pattern.view.MainView;

public class MainPresenterImpl extends Presenter<MainView> {

    private Vehicle vehicle;

    public MainPresenterImpl() {
        this.vehicle = new Vehicle(new Motor());
    }

    public void requestIncreaseSpeed() {
        this.vehicle.increaseSpeed(10);

        if (hasView()) {
            getView().onUpdateSpeed(this.vehicle.getSpeed());
        }
    }

    public void requestStop() {
        this.vehicle.stop();

        if (hasView()) {
            getView().onUpdateSpeed(this.vehicle.getSpeed());
        }
    }
}
