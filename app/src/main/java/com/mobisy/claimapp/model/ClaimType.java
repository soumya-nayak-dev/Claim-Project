package com.mobisy.claimapp.model;

import com.google.gson.annotations.SerializedName;

public class ClaimType {
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
