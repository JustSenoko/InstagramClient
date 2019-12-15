package com.blueroofstudio.instagramclient.fragments.nature;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.blueroofstudio.instagramclient.R;
import com.blueroofstudio.instagramclient.fragments.fruits.FruitsViewModel;

public class NatureFragment extends Fragment {

    private NatureViewModel natureViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        natureViewModel =
                ViewModelProviders.of(this).get(NatureViewModel.class);
        View root = inflater.inflate(R.layout.fragment_image, container, false);

        final ImageView imageView = root.findViewById(R.id.imageView);
        natureViewModel.getDrawableResource().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer s) {
                imageView.setImageResource(s);
            }
        });

        final TextView textView = root.findViewById(R.id.textView);
        natureViewModel.getText().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer s) {
                textView.setText(s);
            }
        });

        return root;
    }
}