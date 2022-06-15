package com.hongik.project.graduation.store.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.hongik.project.graduation.store.R;
import com.hongik.project.graduation.store.ui.activity.LoginActivity;
import com.hongik.project.graduation.store.ui.activity.RegisterActivity;

public class NaviHeaderFragment extends Fragment {

    private Button signinButton;
    private Button signupButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.navi_header_not_login_fragment, container, false);

        signinButton = view.findViewById(R.id.menu_signin_button);
        signupButton = view.findViewById(R.id.menu_signup_button);


        signinButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
        });

        signupButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), RegisterActivity.class);
            startActivity(intent);
        });



        return view;
    }
}
