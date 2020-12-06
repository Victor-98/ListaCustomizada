package com.example.listacustomizada.model;

import java.io.Serializable;

public class Time implements Serializable {

    private int img;
    private String name;
    private String location;
    private String titulos;


    public Time(int img, String name, String location, String titulos) {
        this.img = img;
        this.name = name;
        this.location = location;
        this.titulos = titulos;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }
}
