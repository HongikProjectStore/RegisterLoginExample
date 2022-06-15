package com.hongik.project.graduation.store.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.hongik.project.graduation.store.R;
import com.hongik.project.graduation.store.application.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";

    private TextView edittextID;
    private TextView edittextPassword;
    /*
    private TextView findID;
    private TextView findPassword;
    private TextView signUp;
    */
    private Button loginButton;

    private LoginViewModel loginViewModel;

    public LoginActivity() {
        this.edittextID = null;
        this.edittextPassword = null;
        this.loginButton = null;

        this.loginViewModel = null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle savedInstanceState) called");
        setContentView(R.layout.activity_login);

        loginViewModel = LoginViewModel.getInstance();
        Log.d(TAG, "GOT a LoginViewModel: $loginViewModel");

        edittextID = findViewById(R.id.edittext_id);
        edittextPassword = findViewById(R.id.edittext_password);
        loginButton = findViewById(R.id.signin_button);

        loginButton.setOnClickListener(view -> {
            String userID = loginViewModel.getEdittextID();
            String userPassword = loginViewModel.getEdittextPassword();

            login(userID, userPassword);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");

        TextWatcher edittextIDWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence sequence, int start, int before, int count) {
                loginViewModel.setEdittextID(sequence.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        TextWatcher edittextPasswordWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence sequence, int start, int before, int count) {
                loginViewModel.setEdittextPassword(sequence.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        edittextID.addTextChangedListener(edittextIDWatcher);
        edittextPassword.addTextChangedListener(edittextPasswordWatcher);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");

    }

    private void login(String userID, String userPassword){


    }
}
