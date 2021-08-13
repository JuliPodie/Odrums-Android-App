package com.example.myapplication.ui.level;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class levelViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public levelViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is level fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}