package com.blueroofstudio.instagramclient.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.blueroofstudio.instagramclient.R;
import com.blueroofstudio.instagramclient.models.Item;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {

    private MutableLiveData<List<Item>> mFruitsList;
    private List<Item> fruits;
    private MutableLiveData<List<Item>> mVeggiesList;
    private List<Item> veggies;
    private MutableLiveData<List<Item>> mNatureList;
    private List<Item> nature;

    public ListViewModel() {
        initLists();
        mFruitsList = new MutableLiveData<>();
        mFruitsList.setValue(fruits);
        mVeggiesList = new MutableLiveData<>();
        mVeggiesList.setValue(veggies);
        mNatureList = new MutableLiveData<>();
        mNatureList.setValue(nature);
    }

    private void initLists() {
        initFruits();
        initVeggies();
        initNature();
    }

    private void initFruits() {
        fruits = new ArrayList<>();
        fruits.add(new Item("Клубника", R.drawable.strawberry));
        fruits.add(new Item("Малина", R.drawable.raspberry));
        fruits.add(new Item("Лимон", R.drawable.lemon));
        fruits.add(new Item("Апельсин", R.drawable.orange));
        fruits.add(new Item("Мандарин", R.drawable.tangerine));
        fruits.add(new Item("Киви", R.drawable.kiwi));
        fruits.add(new Item("Голубика", R.drawable.blueberry));
        fruits.add(new Item("Ананас", R.drawable.pineapple));
        fruits.add(new Item("Манго", R.drawable.mango));
        fruits.add(new Item("Арбуз", R.drawable.watermelon));
    }

    private void initVeggies() {
        veggies = new ArrayList<>();
        veggies.add(new Item("Картошка", R.drawable.potato));
        veggies.add(new Item("Морковь", R.drawable.carrot));
        veggies.add(new Item("Капуста", R.drawable.cabbage));
    }

    private void initNature() {
        nature = new ArrayList<>();
        nature.add(new Item("Горы", R.drawable.mountain));
        nature.add(new Item("Море", R.drawable.sea));
        nature.add(new Item("Пустыня", R.drawable.desert));
    }

    LiveData<List<Item>> getItemList(String listType) {
        switch (listType) {
            case "veggies": return mVeggiesList;
            case "nature": return mNatureList;
            default: return mFruitsList;
        }
    }
}