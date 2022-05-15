package com.uni.uniformania.ui.inventario;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InventarioViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InventarioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Inventario fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}