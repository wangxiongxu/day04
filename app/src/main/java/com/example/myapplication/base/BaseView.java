package com.example.myapplication.base;

import android.content.Context;

public interface BaseView <P extends BasePresenter>  {
        void setPresenter(P presenter);
        Context getContextObject();
        }
