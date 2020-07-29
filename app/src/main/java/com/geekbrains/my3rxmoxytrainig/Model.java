package com.geekbrains.my3rxmoxytrainig;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class Model {
    public static final String TAG = "Model";

    private boolean flag;
    public Model(){
        flag = true;
    }

    public Observable<Boolean> changeCurrentImg() {

        Observable <Boolean> obsFlag = Observable.create(
                new ObservableOnSubscribe<Boolean>() {
                    @Override
                    public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                        flag = !flag;
                        emitter.onNext(flag);
                        emitter.onComplete();
                        Log.d(TAG, " in Thread "  + Thread.currentThread().getName());
                    }
                }).subscribeOn(Schedulers.io());
        return obsFlag;
    }
}
