package com.example.task03;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    //SubClass of LiveData
    private MutableLiveData<CharSequence> text = new MutableLiveData<>();
    /**
     * SettingValue using .setValue Method
     * This is used for UI threads for updating value
     */
    public void setText(CharSequence input){
        text.setValue(input);
    }
    // return type LiveData method used for providing data to UI
    public LiveData<CharSequence> getText(){
        return text;
    }
}
