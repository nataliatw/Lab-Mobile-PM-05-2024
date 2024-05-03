package com.example.praktikumenamapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProfileResponse {
    @SerializedName("data")
    private UserResponse data;

    public UserResponse getData(){
        return data;
    }
}
