package com.sashka.carsproj;

import java.io.Serializable;

class CategoryInfo implements Serializable {

    public Integer idImageView;
    public String prodName;
    public String storeName;
    public String phoneNumber;
    public String km;
    public String hours;

    public CategoryInfo(Integer idImageView, String prodName, String storeName, String phoneNumber, String km, String hours) {

        this.idImageView = idImageView;
        this.prodName = prodName;
        this.storeName = storeName;
        this.phoneNumber = phoneNumber;
        this.km = km;
        this.hours = hours;
    }


}
