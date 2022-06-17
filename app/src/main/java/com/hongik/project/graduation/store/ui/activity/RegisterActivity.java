package com.hongik.project.graduation.store.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseIntArray;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.hongik.project.graduation.store.R;
import com.hongik.project.graduation.store.application.service.UserService;
import com.hongik.project.graduation.store.ui.network.request.UserLoginRequest;
import com.hongik.project.graduation.store.ui.network.request.UserSignUpRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "RegisterActivity";

    private EditText edittextID;
    private EditText edittextPassword;
    private EditText edittextName;
    private EditText edittextEmail;
    private EditText edittextGender;
    private EditText edittextAge;
    private EditText edittextImage;

    private Button signUp;
    private UserService userService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edittextID = findViewById(R.id.id_input);
        edittextPassword = findViewById(R.id.password_input);
        edittextName = findViewById(R.id.name_input);
        edittextEmail = findViewById(R.id.email_input);
        edittextGender = findViewById(R.id.gender_input);
        edittextAge = findViewById(R.id.age_input);
        edittextImage = findViewById(R.id.image_input);

        signUp = findViewById(R.id.signup_button);


        signUp.setOnClickListener(view -> {
            String id = edittextID.getText().toString();
            String password = edittextPassword.getText().toString();
            String name = edittextName.getText().toString();
            String email = edittextEmail.getText().toString();
            String gender = edittextGender.getText().toString();
            Integer age = Integer.parseInt(edittextAge.getText().toString());
            Integer image = Integer.parseInt(edittextImage.getText().toString());

            register(id, password, name, email, gender, age, image);
        });

    }

    /*
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
        */
    private void register(String id, String password, String name, String email, String gender, Integer age, Integer image) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://34.234.228.90:7777/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);

        Call<UserSignUpRequest> userSignup = userService.userSignUp(id, password, name, email, gender, age, image);
        userSignup.enqueue(new Callback<UserSignUpRequest>() {
            @Override
            public void onResponse(Call<UserSignUpRequest> call, Response<UserSignUpRequest> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "회원가입 성공 : \t 결과 : \n" + response.body().toString());
                    Toast.makeText(getApplicationContext(),"회원가입에 성공하였습니다.",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
                else{
                    Log.d(TAG, "회원가입 실패\n 결과 : "+ response.toString());
                    showAlert();
                }
            }

            @Override
            public void onFailure(Call<UserSignUpRequest> call, Throwable t) {
                Log.d(TAG, "onFailure");
                showAlert();
            }

            private void showAlert() {
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(RegisterActivity.this);
                myAlertBuilder.setTitle("Alert");
                myAlertBuilder.setMessage("회원가입에 실패하였습니다.");
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
