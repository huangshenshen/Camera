package com.cninter.camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import java.io.File;
import java.io.FileOutputStream;

public class PopWindow extends AppCompatActivity implements View.OnClickListener{
    Button start,bt1,bt2,btn_cancal;
    ImageView imageView;
    PopupWindow window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_window);
        start = (Button) findViewById(R.id.start);
        imageView = (ImageView) findViewById(R.id.imageView);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                showPopWindows();
            }
        });

    }
    public  void showPopWindows(){
        //利用LayoutInfalter 获得View
        //首先获得填充器
       LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.pop_window,null);
        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable drawable = new ColorDrawable(0xb0000000);
        window.setBackgroundDrawable(drawable);
        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypop_window_anim_style);
        window.showAtLocation(PopWindow.this.findViewById(R.id.start), Gravity.BOTTOM,0,0);
        bt1 = (Button) view.findViewById(R.id.btn1);
        bt2 = (Button) view.findViewById(R.id.btn2);
        btn_cancal = (Button) view.findViewById(R.id.btn_cancal);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        btn_cancal.setOnClickListener(this);
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Log.i("aaa","popWindow消失了");
                window.dismiss();
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                //打开摄像头
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,100);

                Log.i("aaa","btn1");
                break;
            case R.id.btn2:
                Intent intent1 = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //剪裁
                intent1.putExtra("crop","true");//开始剪裁
                intent1.putExtra("aspectX",2);//设置剪裁的比例
                intent1.putExtra("aspectY",1);
                intent1.putExtra("outputX",200);//设置剪裁后的图片大小
                intent1.putExtra("outputY",100);
                intent1.putExtra("result-data",true);
                startActivityForResult(intent1,200);
                Log.i("aaa","btn2");
                break;
            case R.id.btn_cancal:
                window.dismiss();

                Log.i("aaa","btn_cancal");
                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode==100&&resultCode==RESULT_OK){
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            SaveImagSD(bitmap, Environment.getExternalStorageDirectory().getAbsolutePath(),"myphoto.png");
            imageView.setImageBitmap(bitmap);

        }
        if(requestCode==200&&resultCode==RESULT_OK){
            Bundle bundle =  data.getExtras();
            Bitmap bitmap = bundle.getParcelable("data");
            imageView.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
    public static  void SaveImagSD(Bitmap bitmap ,String path,String filname){
        String filepath = path+ File.separator+filname;
        File file = new File(filepath);
        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
