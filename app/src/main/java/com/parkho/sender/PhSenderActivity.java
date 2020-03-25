package com.parkho.sender;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.parkho.ShareData;

public class PhSenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.cmd_send).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareData shareData = new ShareData();
                shareData.setName("parkho");
                shareData.setNumber(100);
                shareData.setParcelable(true);

                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.parkho.receiver", "com.parkho.receiver.PhReceiverActivity"));
                intent.putExtra("Parcelable", shareData);
                startActivity(intent);
            }
        });
    }
}