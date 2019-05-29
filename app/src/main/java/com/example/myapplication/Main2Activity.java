package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mVp;
    private int intExtra;
    /**
     * 46
     */
    private TextView mTv;
    private List<Bean.ResultsBean> beans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTv = (TextView) findViewById(R.id.tv);
        Intent intent = getIntent();
        //http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg
        beans = (List<Bean.ResultsBean>) intent.getSerializableExtra("1");
        intExtra = intent.getIntExtra("2", 0);
        List<View> views = new ArrayList<>();
        for (int i = 0; i < beans.size(); i++) {
            View inflate = LayoutInflater.from(Main2Activity.this).inflate(R.layout.layout_op, null);
            ImageView iv = inflate.findViewById(R.id.iv);
            Glide.with(Main2Activity.this).load(beans.get(i).getUrl()).into(iv);
            views.add(inflate);
        }
        Vpadap vpadap = new Vpadap(views);
        mVp.setAdapter(vpadap);
        mVp.setCurrentItem(intExtra);
        mTv.setText(intExtra+"/"+beans.size());
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mTv.setText(i+"/"+beans.size());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });



    }
}
