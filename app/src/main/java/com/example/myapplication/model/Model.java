package com.example.myapplication.model;

import com.example.myapplication.Util.DataService;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.base.BasecallBack;
import com.example.myapplication.bean.Bean;
import com.example.myapplication.contract.Contract;

import java.lang.reflect.Modifier;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class Model extends BaseModel implements Contract.Model {
    @Override
    public void getModel(BasecallBack<Bean> beanBasecallBack) {
        getRXok(beanBasecallBack, DataService.getService("http://gank.io/api/").ribaolist(), new Function<Bean, ObservableSource<Bean>>() {
            @Override
            public ObservableSource<Bean> apply(Bean bean) throws Exception {
                if (bean != null) {
                    return Observable.just(bean);
                }
                return Observable.error(new NullPointerException("返回数据为空或者异常 : " + (bean == null ? "" : bean)));

            }
        });
    }
}
