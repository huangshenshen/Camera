package com.cninter.andorid5;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextInputActivity extends AppCompatActivity implements View.OnClickListener{
    TextInputLayout textInputLayout;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        textInputLayout = (TextInputLayout) findViewById(R.id.text_input_layout_til);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {

        String input =textInputLayout.getEditText().getText().toString().trim();
        Log.i("aaa","input=="+input);
        returnresult(validatacontent(input));
    }
    private void returnresult (boolean isSuccess){
        if (isSuccess){
            Log.i("aaa","验证成功");
            textInputLayout.setErrorEnabled(false);
        }else{
            Log.i("aaa","验证失败");
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError("输入错误");
        }



    }
    private  boolean validatacontent(String inputEdit){
        
        //验证只能是数字和字母的正则表达式
        String pattenText="^[A-Za-z0-9]+$";
        //让正则表达式转化为java对象
        Pattern pattern = Pattern.compile(pattenText);
        //让正则表达式与我们输入的内容相比较
        Matcher matcher = pattern.matcher(inputEdit);
        //等到比较的结果
        return matcher.matches();
    }


}
