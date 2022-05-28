package com.example.registerloginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterFinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_finish);
        
        //=================================================================
        // decline 버튼 누르면 로그인 화면으로 전환 -> 로그인이 맞을까
        Button btn_decline = findViewById(R.id.btn_decline);
        btn_decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(RegisterFinishActivity.this, LoginActivity.class);
                startActivity(intent1);

            }
        });
        //==============================================================


    }





}


