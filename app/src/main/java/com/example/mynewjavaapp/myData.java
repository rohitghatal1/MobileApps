package com.example.mynewjavaapp;

public class myData {
    private String name;
    private String address;
    private int image;

    public myData(String name, String address, int image){
        this.name = name;
        this.address = address;
        this.image = image;
    }

    public String getName (){
        return name;
    }

    public String getAddress () {
        return address;
    }

    public int getImage () {
        return  image;
    }
}
