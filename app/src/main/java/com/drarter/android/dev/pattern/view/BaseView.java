package com.drarter.android.dev.pattern.view;

import android.app.Activity;
import android.support.annotation.NonNull;

import butterknife.ButterKnife;

public abstract class BaseView {

    protected Activity activity;

    public BaseView(@NonNull Activity activity) {

        this.activity = activity;
        ButterKnife.bind(this, activity);
    }
}
