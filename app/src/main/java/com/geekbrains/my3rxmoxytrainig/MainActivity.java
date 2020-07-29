package com.geekbrains.my3rxmoxytrainig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.geekbrains.my3rxmoxytrainig.model.GlideLoader;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    //Переменные
    Button btn;
    ImageView imageView;
    GlideLoader glideLoader;


    @InjectPresenter
    Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        glideLoader = new GlideLoader(this);
    }

    @Override
    public void setImage(String url) {
        glideLoader.loadImage(url, imageView);
    }

    public void onClick(View view) {
        presenter.changeImage();
    }

    private void init(){
        imageView = findViewById(R.id.imageView);
        btn = findViewById(R.id.button);
    }
}