package com.example.handler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author admin
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button runnable;
    private Button handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runnable = findViewById(R.id.btn_runnable);
        handler = findViewById(R.id.handler);
        runnable.setOnClickListener(this);
        handler.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {

            case R.id.btn_runnable:
                intent = new Intent(MainActivity.this, RunnableActivity.class);
                startActivity(intent);
                break;
            case R.id.handler:
                intent = new Intent(MainActivity.this, HandlerActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

}
