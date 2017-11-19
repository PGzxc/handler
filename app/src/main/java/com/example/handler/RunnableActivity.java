package com.example.handler;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author：Admin
 * date：2017/11/1915:09
 * 编程使我快乐
 */

public class RunnableActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView statusText;
    private Button downLoad;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runnable);
        statusText = findViewById(R.id.statusText);
        downLoad = findViewById(R.id.downLoad);
        downLoad.setOnClickListener(this);
        LogUtils.d("Main Thread id " + Thread.currentThread().getId());
    }

    @Override
    public void onClick(View v) {
        DownLoadThread downLoadThread = new DownLoadThread();
        downLoadThread.start();
    }

    class DownLoadThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                LogUtils.d("Download Thread id " + Thread.currentThread().getId());
                LogUtils.d("开始下载文件");
                Thread.sleep(1000);
                LogUtils.d("文件下载完成");
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        LogUtils.d("Runnalbe Thread id " + Thread.currentThread().getId());
                        LogUtils.d("文件下载完成");
                        statusText.setText("文件下载完成");
                    }
                };
                handler.post(runnable);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
