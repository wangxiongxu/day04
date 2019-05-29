package com.example.myapplication;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.bean.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdAp extends RecyclerView.Adapter<AdAp.ViewH> {
    List<Bean.ResultsBean> results;

    public AdAp(List<Bean.ResultsBean> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public ViewH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.imag, null);
        ViewH viewH = new ViewH(inflate);
        return viewH;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewH viewH, final int i) {
        Glide.with(viewH.iv.getContext()).load(results.get(i).getUrl()).into(viewH.iv);
        viewH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewH.iv.getContext(), Main2Activity.class);
                /*List<String> strings = new ArrayList<>();
                for (int j = 0; j < results.size(); j++) {
                    strings.add(results.get(i).get)
                }*/
                intent.putExtra("1", (Serializable) results);
                intent.putExtra("2",i);
                viewH.iv.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewH extends RecyclerView.ViewHolder {
            ImageView iv;
        public ViewH(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
        }
    }
}
