package com.geekbrains.my3rxmoxytrainig;

import android.util.Log;

import com.geekbrains.my3rxmoxytrainig.model.Retrofit.Model;
import com.geekbrains.my3rxmoxytrainig.model.gson.User;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class Presenter extends MvpPresenter <MainView> {

    private static final String TAG = "MainPresenter";

    private Model model;
    private Disposable disposable;

    public Presenter(){
        Log.d(TAG, " created");
        model = new Model();
    }

    public void changeImage(){
       Observable<User> observable = model.changeCurrentImg();
       observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<User>() {
           @Override
           public void onSubscribe(Disposable d) {
               Log.d(TAG, "onSubscribe");
               Presenter.this.disposable = d;
           }

           @Override
           public void onNext(User user) {
               Log.d(TAG, " onNext boolean = " + user.login.toString());
                    Presenter.this.getViewState().setImage(user.avatar);
           }

           @Override
           public void onError(Throwable e) {
                Log.d(TAG, "OnError");
           }

           @Override
           public void onComplete() {
                Log.d(TAG, " onComplete()");
           }
       });

    }
}
