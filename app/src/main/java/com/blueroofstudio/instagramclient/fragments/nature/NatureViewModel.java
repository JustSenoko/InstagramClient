package com.blueroofstudio.instagramclient.fragments.nature;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.blueroofstudio.instagramclient.R;

public class NatureViewModel extends ViewModel {

    private MutableLiveData<Integer> mDrawableResource;
    private MutableLiveData<Integer> mText;

    public NatureViewModel() {
        mDrawableResource = new MutableLiveData<>();
        mDrawableResource.setValue(R.drawable.nature);
        mText = new MutableLiveData<>();
        mText.setValue(R.string.nature_list);
    }

    LiveData<Integer> getDrawableResource() {
        return mDrawableResource;
    }

    LiveData<Integer> getText() {
        return mText;
    }
}