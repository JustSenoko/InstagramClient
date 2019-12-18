package com.blueroofstudio.instagramclient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blueroofstudio.instagramclient.R;
import com.blueroofstudio.instagramclient.adapters.RVAdapter;
import com.blueroofstudio.instagramclient.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListFragment extends Fragment {

    private ListViewModel fruitsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fruitsViewModel =
                ViewModelProviders.of(this).get(ListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_list, container, false);

        String listType = "fruits";
        if (getArguments() != null) {
            listType = Objects.requireNonNull(getArguments().get("type")).toString();
        }
        initRecyclerView(root, listType);

        return root;
    }

    private void initRecyclerView(View root, String listType) {
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        final RVAdapter adapter = new RVAdapter(new ArrayList<Item>());
        recyclerView.setAdapter(adapter);

        fruitsViewModel.getItemList(listType).observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                adapter.update(items);
            }
        });
    }
}