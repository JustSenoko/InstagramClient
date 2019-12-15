package com.blueroofstudio.instagramclient.fragments.fruits;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.blueroofstudio.instagramclient.R;

public class FruitsViewModel extends ViewModel {

    private MutableLiveData<Integer> mDrawableResource;
    private MutableLiveData<Integer> mText;

    public FruitsViewModel() {
        mDrawableResource = new MutableLiveData<>();
        mDrawableResource.setValue(R.drawable.fruits);
        mText = new MutableLiveData<>();
        mText.setValue(R.string.fruits_list);
    }

    LiveData<Integer> getDrawableResource() {
        return mDrawableResource;
    }

    LiveData<Integer> getText() {
        return mText;
    }
}