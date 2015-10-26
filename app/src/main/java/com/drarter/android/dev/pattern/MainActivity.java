package com.drarter.android.dev.pattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.drarter.android.dev.pattern.model.Motor;
import com.drarter.android.dev.pattern.model.Vehicle;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.text_result_speed)
    TextView textResultSpeed;

    private Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        vehicle = new Vehicle(new Motor());
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_increase_speed)
    public void onIncreaseButtonClick() {
        vehicle.increaseSpeed(10);
        this.textResultSpeed.setText("" + vehicle.getSpeed());
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_stop)
    public void onStopClick() {
        vehicle.stop();
        this.textResultSpeed.setText("" + vehicle.getSpeed());
    }
}
