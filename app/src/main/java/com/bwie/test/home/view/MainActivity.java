package com.bwie.test.home.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.test.R;
import com.bwie.test.home.model.ConfigResponse;
import com.bwie.test.home.presenter.HomePresenter;

public class MainActivity extends AppCompatActivity implements IHomeView {

    private TextView chongxinjiazia;
    private ProgressBar progressbar;
    private TextView hellooooo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        HomePresenter homePresenter = new HomePresenter(this);
        homePresenter.loadConfig("xy");

    }


    @Override
    public void showOrHideloading(boolean flag) {
        if (flag) {
            progressbar.setVisibility(View.VISIBLE);
        } else {
            progressbar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showOrHideErrorView(boolean flag) {
        if (flag) {
            chongxinjiazia.setVisibility(View.VISIBLE);
        } else {
            chongxinjiazia.setVisibility(View.GONE);
        }
    }

    @Override
    public void refreshView(ConfigResponse configResponse) {

        Toast.makeText(MainActivity.this, configResponse.ucTabString, Toast.LENGTH_LONG).show();
        hellooooo.setText(configResponse.androidDes);
    }

    private void initView() {
        chongxinjiazia = (TextView) findViewById(R.id.chongxinjiazia);
        progressbar = (ProgressBar) findViewById(R.id.progressbar);
        hellooooo = (TextView) findViewById(R.id.hellooooo);
    }
}
