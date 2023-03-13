package com.example.intentrequest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class WaitIntnet extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        
        Toast.makeText(context, "Пришёл ответ на запрос Title = " +
                        intent.getStringExtra("TITLE_NO_THANKS"),
                Toast.LENGTH_LONG).show();

    }
}