package com.example.handler;

import android.content.Context;
import android.widget.Toast;

/**
 * author：Admin
 * date：2017/11/1909:04
 * 编程使我快乐
 */

public class ToastUtils {

    private static Toast toast;

    public static void toastShort(Context context, CharSequence sequence) {

        if (toast == null) {
            toast = Toast.makeText(context,sequence,Toast.LENGTH_SHORT);
        } else {
            toast.setText(sequence);
        }
        toast.show();
    }

    public static void toastShort(Context context, int msg) {
        if (toast == null) {

            toast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
    public static void toastLong(Context context, CharSequence sequence) {

        if (toast == null) {
            toast = Toast.makeText(context,sequence,Toast.LENGTH_LONG);
        } else {
            toast.setText(sequence);
        }
        toast.show();
    }

    public static void toastLong(Context context,int msg){
        if(toast==null){
            toast=new Toast(context);
        }else{
            toast.setText(msg);
        }
        toast.show();
    }

    public static  void hidden(Context context){
        if(toast!=null){
            toast.cancel();
        }

    }

}

