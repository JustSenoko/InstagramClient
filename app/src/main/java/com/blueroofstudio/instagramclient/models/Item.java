package com.blueroofstudio.instagramclient.models;

public class Item {
    private String name;
    private Integer imgSource;

    public Item(String name, Integer imgSource) {
        this.name = name;
        this.imgSource = imgSource;
    }

    public String getName() {
        return name;
    }

    public Integer getImgSource() {
        return imgSource;
    }
}
