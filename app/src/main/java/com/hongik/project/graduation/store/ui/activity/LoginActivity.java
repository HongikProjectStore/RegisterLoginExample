package com.hongik.project.graduation.store.ui.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hongik.project.graduation.store.R;
import com.hongik.project.graduation.store.application.service.ProductService;
import com.hongik.project.graduation.store.application.service.UserService;
import com.hongik.project.graduation.store.application.viewmodel.LoginViewModel;
import com.hongik.project.graduation.store.ui.network.request.UserLoginRequest;
import com.hongik.project.graduation.store.ui.network.response.ProductDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";

    private TextView edittextID;
    private TextView edittextPassword;
    /*
    private TextView findID;
    private TextView findPassword;

    */
    private TextView edittextSignUp;

    private Button loginButton;

    private LoginViewModel loginViewModel;
    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle savedInstanceState) called");
        setContentView(R.layout.activity_login);

        loginViewModel = LoginViewModel.getInstance();
        Log.d(TAG, "GOT a LoginViewModel: $loginViewModel");

        edittextID = findViewById(R.id.edittext_id);
        edittextPassword = findViewById(R.id.edittext_password);
        edittextSignUp = findViewById(R.id.signup_button);
        loginButton = findViewById(R.id.signin_button);

        loginButton.setOnClickListener(view -> {
            //String userID = loginViewModel.getEdittextID();
            //String userPassword = loginViewModel.getEdittextPassword();

            String userID = edittextID.getText().toString();
            String userPassword = edittextPassword.getText().toString();
            login(userID, userPassword);
        });

        edittextSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });
    }
    /*
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

     */
    private void login(String userID, String userPassword){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://34.234.228.90:7777/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);

        Call <UserLoginRequest> userLogin = userService.userLogin(userID, userPassword);
        userLogin.enqueue(new Callback<UserLoginRequest>() {
            @Override
            public void onResponse(Call<UserLoginRequest> call, Response<UserLoginRequest> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "Login 성공 : \t 결과 : \n" + response.body().toString());
                    Toast.makeText(getApplicationContext(),"로그인에 성공하였습니다.",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Log.d(TAG, "Login 실패\n 결과 : "+ response.toString());
                    showAlert();
                }
            }

            @Override
            public void onFailure(Call<UserLoginRequest> call, Throwable t) {
                Log.d(TAG, "onFailure");
                showAlert();
            }

            private void showAlert() {
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(LoginActivity.this);
                myAlertBuilder.setTitle("Alert");
                myAlertBuilder.setMessage("로그인에 실패하였습니다.");
                myAlertBuilder.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        // OK 버튼을 눌렸을 경우
                    }
                });
                myAlertBuilder.show();
            }
        });


    }
}
