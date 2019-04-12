package com.example.narim.nova;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignInResult {

    @SerializedName("token")
    @Expose
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
