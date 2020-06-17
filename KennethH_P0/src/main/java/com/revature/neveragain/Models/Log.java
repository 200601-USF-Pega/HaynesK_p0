package com.revature.neveragain.Models;

import java.io.Serializable;

public class Log implements Serializable {

    private String restaurantName;
    private String category;
    private String address;
    private String city;
    private int rank;
    private String comment;

    public Log() {
    }

    public Log(String restaurantName, String category, String address, String city, int rank, String comment) {
        this.restaurantName = restaurantName;
        this.category = category;
        this.address = address;
        this.city = city;
        this.rank = rank;
        this.comment = comment;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) { this.category = category; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Log{" +
                "restaurantName='" + restaurantName + '\'' +
                ", category='" + category + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", rank=" + rank +
                ", comment='" + comment + '\'' +
                '}';
    }
}
