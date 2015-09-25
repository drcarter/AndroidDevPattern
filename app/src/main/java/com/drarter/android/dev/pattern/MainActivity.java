package com.drarter.android.dev.pattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.drarter.android.dev.pattern.presenter.MainPresenterImpl;
import com.drarter.android.dev.pattern.view.MainView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @Bind(R.id.text_result_speed)
    TextView textResultSpeed;

    private MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenterImpl();
        presenter.bindView(this);
    }

    @Override
    protected void onDestroy() {
        presenter.unbindView(this);
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
        this.presenter.requestIncreaseSpeed();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button_stop)
    public void onStopClick() {
        this.presenter.requestStop();
    }

    @Override
    public void onUpdateSpeed(int speed) {
        this.textResultSpeed.setText("speed : " + speed);
    }
}
