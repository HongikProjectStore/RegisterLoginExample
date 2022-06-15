package com.hongik.project.graduation.store.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.hongik.project.graduation.store.R;

public class LogoutActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";

    private Button acceptButton;
    private Button declineButton;

    public LogoutActivity(){
        this.acceptButton = null;
        this.declineButton = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle savedInstanceState) called");
        setContentView(R.layout.activity_logout);

        acceptButton.findViewById(R.id.logout_accept);
        declineButton.findViewById(R.id.logout_decline);

        acceptButton.setOnClickListener(view -> {

        });

        declineButton.setOnClickListener(view -> {

        });
    }
}