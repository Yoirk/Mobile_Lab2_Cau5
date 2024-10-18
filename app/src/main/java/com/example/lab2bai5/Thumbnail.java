package com.example.lab2bai5;

public enum Thumbnail {
    Thumbnail1("Thumbnail 1", R.drawable.dish_01),
    Thumbnail2("Thumbnail 2", R.drawable.dish_02),
    Thumbnail3("Thumbnail 3", R.drawable.dish_03),
    Thumbnail4("Thumbnail 4", R.drawable.dish_04);

    private String name;
    private int img;

    Thumbnail(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }
}

