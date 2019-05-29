package com.example.myapplication.Util;



import com.example.myapplication.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
//http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1

public interface ApiService {

     @GET("data/%E7%A6%8F%E5%88%A9/10/1")
    Observable<Bean> ribaolist();

}
