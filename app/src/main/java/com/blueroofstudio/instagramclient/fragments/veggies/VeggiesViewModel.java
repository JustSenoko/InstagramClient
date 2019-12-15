package com.blueroofstudio.instagramclient.fragments.veggies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.blueroofstudio.instagramclient.R;

public class VeggiesViewModel extends ViewModel {

    private MutableLiveData<Integer> mDrawableResource;
    private MutableLiveData<Integer> mText;

    public VeggiesViewModel() {
        mDrawableResource = new MutableLiveData<>();
        mDrawableResource.setValue(R.drawable.veggies);
        mText = new MutableLiveData<>();
        mText.setValue(R.string.veggies_list);
    }

    LiveData<Integer> getDrawableResource() {
        return mDrawableResource;
    }

    LiveData<Integer> getText() {
        return mText;
    }
}