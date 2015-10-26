package com.drarter.android.dev.pattern.base.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.drarter.android.dev.pattern.presenter.Presenter;
import com.drarter.android.dev.pattern.presenter.ViewListener;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getContentViewResource();

    protected abstract void onInit();

    protected abstract Presenter getViewListener();

    protected ViewListener viewListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResource());
        ButterKnife.bind(this);
        onInit();

        this.viewListener = getViewListener();

        if (this.viewListener != null) {
            this.viewListener.onCreate();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (this.viewListener != null) {
            this.viewListener.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (this.viewListener != null) {
            this.viewListener.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (this.viewListener != null) {
            this.viewListener.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();

        if (this.viewListener != null) {
            this.viewListener.onDestroy();
        }
    }
}
