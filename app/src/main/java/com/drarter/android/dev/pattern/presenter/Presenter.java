package com.drarter.android.dev.pattern.presenter;

import android.support.annotation.NonNull;

import com.drarter.android.dev.pattern.view.View;

public abstract class Presenter<V extends View> implements ViewListener {

    protected V view;

    public void bindView(@NonNull V view) {
        if (this.view != view) {
            if (this.view != null) {
                unbindView(this.view);
            }
            this.view = view;
        }
    }

    public void unbindView(@NonNull V view) {
        if (view == this.view) {
            this.view = null;
        }
    }

    protected boolean hasView() {
        return view != null;
    }

    public V getView() {
        return view;
    }
}
