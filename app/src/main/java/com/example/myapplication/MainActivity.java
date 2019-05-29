package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.bean.Bean;
import com.example.myapplication.contract.Contract;
import com.example.myapplication.presenter.Presenter;

import java.util.List;

public class MainActivity extends BaseActivity implements Contract.View {
    private RecyclerView mRec;

    //王旭 1810A
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRec = (RecyclerView) findViewById(R.id.rec);
        mRec.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        setPresenter(new Presenter());
    }

    @Override
    public void getIfVIew(Bean bean) {
        List<Bean.ResultsBean> results = bean.getResults();
        AdAp adAp = new AdAp(results);
        mRec.setAdapter(adAp);
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
            presenter.attachView(this);
    }

    @Override
    public Context getContextObject() {
        return MainActivity.this;
    }
}
