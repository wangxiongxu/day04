package com.example.myapplication.base;


import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class BaseModel {
   /* public static <T> void getRXok(){

    }*/
    public static <T> void getRXok(final BasecallBack<T> callBack, Observable<T> observable, Function<T, ObservableSource<T>> function){
        observable.flatMap(function).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(T t) {
                        callBack.onSuccess(t);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("tagg", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
