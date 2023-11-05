package com.example.ecommerceapp;

public class ModelClass {
    int flagImg;
    String Description,NameP,RemaingP;

    public ModelClass(int flagImg, String description, String nameP, String remaingP) {
        this.flagImg = flagImg;
        Description = description;
        NameP = nameP;
        RemaingP = remaingP;
    }

    public int getFlagImg() {
        return flagImg;
    }

    public String getDescription() {
        return Description;
    }

    public String getNameP() {
        return NameP;
    }

    public String getRemaingP() {
        return RemaingP;
    }
}
