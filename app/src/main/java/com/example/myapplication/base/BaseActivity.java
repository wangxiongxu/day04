package com.example.myapplication.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;

public class BaseActivity extends RxAppCompatActivity {

    protected void addFragment(FragmentManager manager, Class<? extends BaseFrag> aClass, int containerId, Bundle args){
        String tag=aClass.getName();
        //Logger.d("%s add fragment %s",TAG,aClass.getSimpleName());
        Fragment fragment = manager.findFragmentByTag(tag);
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragment == null) {
            try {
                fragment= aClass.newInstance();
                //transaction.setCustomAnimations(baseFragment.enter(),baseFragment.exit(),baseFragment.popEnter(),baseFragment.popExit());
                BaseFrag baseFragment= (BaseFrag) fragment;
                transaction.add(containerId, fragment);
                /*if (baseFragment.isNeedToAddBackStack()) {
                    transaction.addToBackStack(tag);
                }*/
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }else {
            if (fragment.isAdded()) {
                if (fragment.isHidden()) {
                    transaction.show(fragment);
                }
            }else {
                transaction.add(containerId, fragment);
            }
        }
        if (fragment != null) {
            fragment.setArguments(args);
            hideBeforeFragment(manager, transaction, fragment);
            transaction.commit();
        }

    }
    private void hideBeforeFragment(FragmentManager manager, FragmentTransaction transaction, Fragment currentFragmenFfragment){
        List<Fragment> fragments =manager.getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != currentFragmenFfragment && !fragment.isHidden()) {
                transaction.hide(fragment);
            }
        }
    }
}
