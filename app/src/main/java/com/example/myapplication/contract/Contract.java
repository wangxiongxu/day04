package com.example.myapplication.contract;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.base.BasecallBack;
import com.example.myapplication.bean.Bean;

public interface Contract {
    interface Model {
        void getModel(BasecallBack<Bean> beanBasecallBack);
    }

    interface View extends BaseView<Presenter> {
        void getIfVIew(Bean bean);
    }

    interface Presenter extends BasePresenter<View> {
    }
}
