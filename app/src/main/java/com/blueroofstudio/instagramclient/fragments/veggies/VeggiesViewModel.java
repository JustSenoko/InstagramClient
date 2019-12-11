package com.blueroofstudio.instagramclient.fragments.veggies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.blueroofstudio.instagramclient.R;

public class VeggiesViewModel extends ViewModel {

    private MutableLiveData<Integer> mDrawableResource;

    public VeggiesViewModel() {
        mDrawableResource = new MutableLiveData<>();
        mDrawableResource.setValue(R.drawable.veggies);
    }

    LiveData<Integer> getDrawableResource() {
        return mDrawableResource;
    }
}