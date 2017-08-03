package com.android.monkey.testalpha;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rlActionBar;
    private Button btnGoToSecond;
    private Button btnFirstChangeAlpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
    }

    private void initView() {
        rlActionBar = (RelativeLayout)findViewById(R.id.rl_action_bar);
        btnGoToSecond = (Button)findViewById(R.id.btn_go_to_second);
        btnFirstChangeAlpha = (Button)findViewById(R.id.btn_first_change_alpha);
        btnGoToSecond.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goToSecondPage();
                    }
                }
        );
        btnFirstChangeAlpha.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //firstChangeAlpha();
                        secondChangeAlpha();
                    }
                }
        );

    }

    private void secondChangeAlpha() {
        Drawable background = rlActionBar.getBackground();
        if(background!=null){
            if(background.getAlpha()<100){
                background.mutate().setAlpha(255);
            }else{
                background.mutate().setAlpha(80);
            }
        }
    }

    //android:background="@color/color_ff6c38"
    //默认情况下，所有的从同一资源（R.drawable.***等等)加载的实例都共享一个共用的状态，
    // 如果你更改一个实例的状态，其余的实例都会接收到相同的通知。

    private void firstChangeAlpha() {
        Drawable background = rlActionBar.getBackground();
        if(background!=null){
            if(background.getAlpha()<100){
                background.setAlpha(255);
            }else{
                background.setAlpha(80);
            }
        }
        //rlActionBar.setAlpha(0);
    }

    private void goToSecondPage() {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
