package com.blueroofstudio.instagramclient.fragments.nature;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.blueroofstudio.instagramclient.R;

public class NatureViewModel extends ViewModel {

    private MutableLiveData<Integer> mDrawableResource;

    public NatureViewModel() {
        mDrawableResource = new MutableLiveData<>();
        mDrawableResource.setValue(R.drawable.nature);
    }

    LiveData<Integer> getDrawableResource() {
        return mDrawableResource;
    }
}