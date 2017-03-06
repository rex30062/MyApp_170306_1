package com.cclz.myapp_170306_1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    final int REQUEST_CODE_CAMERA =123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CODE_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_CAMERA){
            if(resultCode == RESULT_OK) {
                if (data != null) { //可能尚未指定intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    //返回有缩略图
                    if (data.hasExtra("data")) {
                        Bitmap thumbnail = data.getParcelableExtra("data");
                        //得到bitmap后的操作
                        ImageView img=(ImageView) findViewById(R.id.imageView);
                        img.setImageBitmap(thumbnail);
                    }
                } else {
                    //由于指定了目标uri，存储在目标uri，intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    // 通过目标uri，找到图片
                    // 对图片的缩放处理
                    // 操作
                }
            }
        }
    }
}
