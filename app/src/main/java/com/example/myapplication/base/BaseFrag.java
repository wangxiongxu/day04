package com.example.myapplication.base;

/*import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.trello.rxlifecycle2.components.RxFragment;*/

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.trello.rxlifecycle2.components.support.RxFragment;


public class BaseFrag extends RxFragment {
    private BaseActivity mBaseactivity;
    public void onAttach(Activity activity){
        super.onAttach(activity);
        if (activity instanceof BaseActivity) {
            mBaseactivity=(BaseActivity) activity;
        }
    }
    protected void addFragment(FragmentManager manager, Class<? extends BaseFrag> aClass, int containerId, Bundle args) {
        if (mBaseactivity != null) {
            mBaseactivity.addFragment(manager,aClass,containerId,args);
        }
    }
}
