package com.blueroofstudio.instagramclient.fragments.tabs;

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
import androidx.viewpager.widget.ViewPager;

import com.blueroofstudio.instagramclient.R;
import com.blueroofstudio.instagramclient.adapters.RVAdapter;
import com.blueroofstudio.instagramclient.adapters.TabAdapter;
import com.blueroofstudio.instagramclient.fragments.list.ListFragment;
import com.blueroofstudio.instagramclient.fragments.list.ListViewModel;
import com.blueroofstudio.instagramclient.models.Item;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TabsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tabs, container, false);

        initTabs(root);
        return root;
    }

    private void initTabs(View view) {
        Fragment fragment1 = ListFragment.newInstance("fruits");
        Fragment fragment2 = ListFragment.newInstance("veggies");
        Fragment fragment3 = ListFragment.newInstance("nature");

        TabAdapter adapter = new TabAdapter(getChildFragmentManager());
        adapter.addFragment(fragment1, "veg1");
        adapter.addFragment(fragment2, "veg2");
        adapter.addFragment(fragment3, "veg3");

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

}