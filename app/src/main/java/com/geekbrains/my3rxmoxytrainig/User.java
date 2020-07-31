package com.geekbrains.my3rxmoxytrainig;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    @SerializedName("login")
    public String login;

    @Expose
    @SerializedName("avatar_url")
    public String avatar;
}
