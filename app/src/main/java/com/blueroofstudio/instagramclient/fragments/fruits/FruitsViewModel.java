package com.blueroofstudio.instagramclient.fragments.fruits;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.blueroofstudio.instagramclient.R;

public class FruitsViewModel extends ViewModel {

    private MutableLiveData<Integer> mDrawableResource;

    public FruitsViewModel() {
        mDrawableResource = new MutableLiveData<>();
        mDrawableResource.setValue(R.drawable.fruits);
    }

    LiveData<Integer> getDrawableResource() {
        return mDrawableResource;
    }
}