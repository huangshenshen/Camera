package com.cninter.andorid5;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SnackActivity extends AppCompatActivity {
    Button button;
    FloatingActionButton float_action_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);
        float_action_button = (FloatingActionButton) findViewById(R.id.float_action_button);
        float_action_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"测试用的",Snackbar.LENGTH_SHORT).show();
            }
        });



        button  = (Button) findViewById(R.id.snackbar_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SnackBar 相当于Toast
                //Snackbar.make(view,"SnackBar",Snackbar.LENGTH_SHORT).show();
                Snackbar snackbar = Snackbar.make(view,"Anndroid",Snackbar.LENGTH_SHORT);
                //修改文字的颜色
                View view1 = snackbar.getView();
                view1.setBackgroundColor(Color.GREEN);
                snackbar.setAction("action", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i("aaa","action done");
                    }
                });
                snackbar.setActionTextColor(Color.parseColor("#ff0000"));
                snackbar.show();

            }
        });

    }
}
