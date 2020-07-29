package com.geekbrains.my3rxmoxytrainig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    //Переменные
    Button btn;
    ImageView imageView;


    @InjectPresenter
    Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void setImage(Boolean b) {
        if (b) {
            imageView.setImageResource(R.drawable.ic_launcher_background);
        } else {
            imageView.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    public void onClick(View view) {
        presenter.changeImage();
    }

    private void init(){
        imageView = findViewById(R.id.imageView);
        btn = findViewById(R.id.button);
    }
}