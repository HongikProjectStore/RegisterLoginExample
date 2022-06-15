package com.hongik.project.graduation.store.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hongik.project.graduation.store.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText id;
    private EditText password;
    private EditText name;
    private EditText email;
    private EditText gender;
    private EditText age;
    private EditText image;

    private Button signUp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        id = findViewById(R.id.id_input);
        password = findViewById(R.id.password_input);
        name = findViewById(R.id.name_input);
        email = findViewById(R.id.email_input);
        gender = findViewById(R.id.gender_input);
        age = findViewById(R.id.age_input);
        image = findViewById(R.id.image_input);

        signUp = findViewById(R.id.signup_button);


        signUp.setOnClickListener(view -> {

        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        TextWatcher idTextWatcher = new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        TextWatcher passwordTextWatcher = new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

    }
}
