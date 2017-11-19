package com.example.handler;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author：Admin
 * date：2017/11/1911:13
 * 编程使我快乐
 */

public class HandlerActivity extends AppCompatActivity implements View.OnClickListener {

    private static final java.lang.String TAG = HandlerActivity.class.getSimpleName();
    private TextView statusText;
    private Button btnDownload;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                 LogUtils.d(TAG,"handler thread id:"+Thread.currentThread().getId());
                 statusText.setText("文件下载完成！");
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        statusText = findViewById(R.id.statusText);
        btnDownload = findViewById(R.id.downLoad);
        btnDownload.setOnClickListener(this);
        LogUtils.d(TAG, "Main thread id :" + Thread.currentThread().getId());
    }

    @Override
    public void onClick(View v) {

        DownloadThread downloadThread=new DownloadThread();
        downloadThread.start();


    }


    class DownloadThread extends Thread {

        @Override
        public void run() {
            super.run();
            try {
                LogUtils.d(TAG,"downloadThread id:"+Thread.currentThread().getId());
                LogUtils.d(TAG,"开始下载");
                Thread.sleep(1000);
                LogUtils.d(TAG,"文件下载完成");
                Message msg=Message.obtain();
                msg.what=1;
                handler.sendMessage(msg);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
