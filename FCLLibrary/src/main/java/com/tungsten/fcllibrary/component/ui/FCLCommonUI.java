package com.tungsten.fcllibrary.component.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import com.tungsten.fcllibrary.R;
import com.tungsten.fcllibrary.anim.DisplayAnimUtils;
import com.tungsten.fcllibrary.component.view.FCLUILayout;

public abstract class FCLCommonUI extends FCLBaseUI {

    private final FCLUILayout parent;

    public FCLCommonUI(Context context, FCLUILayout parent, @LayoutRes int id) {
        super(context);
        setContentView(id);
        this.parent = parent;
        onCreate();
    }

    @Override
    public boolean isShowing() {
        return getContentView().getVisibility() == View.VISIBLE;
    }

    @Override
    public abstract void refresh();

    @Override
    public void onCreate() {
        super.onCreate();
        getContentView().setVisibility(View.GONE);
        parent.addView(getContentView(), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void onStart() {
        super.onStart();
        DisplayAnimUtils.showViewWithAnim(getContentView(), R.anim.ui_show);
    }

    @Override
    public void onStop() {
        super.onStop();
        DisplayAnimUtils.hideViewWithAnim(getContentView(), R.anim.ui_hide);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        parent.removeView(getContentView());
    }
}