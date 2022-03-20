package com.mobisy.claimapp.model;

import com.google.gson.annotations.SerializedName;

public class ClaimFieldOption {
    @SerializedName("name")
    private String name;
    @SerializedName("label")
    private String label;
    @SerializedName("belongsto")
    private String belongsto;
    @SerializedName("hasmany")
    private String hasmany;
    @SerializedName("claimfield_id")
    private String claimFieldId;
    @SerializedName("id")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBelongsto() {
        return belongsto;
    }

    public void setBelongsto(String belongsto) {
        this.belongsto = belongsto;
    }

    public String getHasmany() {
        return hasmany;
    }

    public void setHasmany(String hasmany) {
        this.hasmany = hasmany;
    }

    public String getClaimFieldId() {
        return claimFieldId;
    }

    public void setClaimFieldId(String claimFieldId) {
        this.claimFieldId = claimFieldId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
