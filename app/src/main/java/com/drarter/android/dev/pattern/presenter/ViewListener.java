package com.drarter.android.dev.pattern.presenter;

public interface ViewListener {

    void onCreate();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

}
