package com.drarter.android.dev.pattern;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.drarter.android.dev.pattern.base.activity.BaseActivity;
import com.drarter.android.dev.pattern.presenter.MainPresenterImpl;
import com.drarter.android.dev.pattern.presenter.Presenter;
import com.drarter.android.dev.pattern.view.MainView;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainView {

    @Bind(R.id.text_result_speed)
    TextView textResultSpeed;

    private MainPresenterImpl presenter;

    @Override
    protected int getContentViewResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInit() {
        presenter = new MainPresenterImpl();
        presenter.bindView(this);
    }

    @Override
    protected Presenter getViewListener() {
        return this.presenter;
    }

    @Override
    protected void onDestroy() {
        presenter.unbindView(this);
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
