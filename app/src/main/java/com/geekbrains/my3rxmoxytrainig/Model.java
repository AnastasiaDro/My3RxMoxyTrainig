package com.geekbrains.my3rxmoxytrainig;

import com.geekbrains.my3rxmoxytrainig.model.Retrofit.RetrofitService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {
    public static final String TAG = "Model";

    String userMe;
    String userJake;

    String currentUser;

    private boolean flag;




    public Model() {
        this.userMe = "AnastasiaDro";
        this.userJake = "jakeWharton";
        this.currentUser = userJake;
    }

    public Observable<User> changeCurrentImg() {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        RetrofitService api = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(RetrofitService.class);

        return api.getUser(currentUser).subscribeOn(Schedulers.io());
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getUserMe() {
        return userMe;
    }

    public String getUserJake() {
        return userJake;
    }
}

