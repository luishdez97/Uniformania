package com.uni.uniformania.ui.precios;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PreciosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PreciosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Precios fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}