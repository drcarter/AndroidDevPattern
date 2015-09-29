package com.drarter.android.dev.pattern.view;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.drarter.android.dev.pattern.R;
import com.drarter.android.dev.pattern.model.Motor;
import com.drarter.android.dev.pattern.model.Vehicle;

import butterknife.Bind;
import butterknife.OnClick;

public class MainView extends BaseView {

    @Bind(R.id.text_result_speed)
    TextView textResultSpeed;

    private Vehicle vehicle;

    public MainView(@NonNull Activity activity) {
        super(activity);

        this.vehicle = new Vehicle(new Motor());

        this.textResultSpeed.setText("speed : " + 0);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_increase_speed)
    public void onIncreaseButtonClick() {
        this.vehicle.increaseSpeed(10);
        this.textResultSpeed.setText("speed : " + this.vehicle.getSpeed());
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_stop)
    public void onStopClick() {
        this.vehicle.stop();
        this.textResultSpeed.setText("speed : " + this.vehicle.getSpeed());
    }
}
