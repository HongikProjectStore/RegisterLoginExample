package com.hongik.project.graduation.store.application.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;


public class LoginViewModel extends ViewModel {
    public static final String TAG = "LoginViewModel";

    private String edittextID;
    private String edittextPassword;

    private LoginViewModel(){
        Log.d(TAG, "ViewModel instance created!");
        this.edittextID=null;
        this.edittextPassword=null;
    }

    private static class LazyHolder {
        public static final LoginViewModel INSTANCE = new LoginViewModel();
    }

    public static LoginViewModel getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "ViewModel instance about to be destroyed");
    }

    public String getEdittextID() {
        return edittextID;
    }

    public void setEdittextID(String edittextID) {
        this.edittextID = edittextID;
    }

    public String getEdittextPassword() {
        return edittextPassword;
    }

    public void setEdittextPassword(String edittextPassword) {
        this.edittextPassword = edittextPassword;
    }
}
