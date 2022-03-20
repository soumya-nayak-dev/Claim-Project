package com.mobisy.claimapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ClaimField {
    @SerializedName("id")
    private String claimTypeId;
    @SerializedName("name")
    private String name;
    @SerializedName("label")
    private String label;
    @SerializedName("type")
    private String type;
    @SerializedName("required")
    private String required;
    @SerializedName("isdependant")
    private String isDependant;
    @SerializedName("created")
    private String created;
    @SerializedName("modified")
    private String modified;
    @SerializedName("Claimfieldoption")
    List<ClaimFieldOption> claimFieldOptionList;

    public String getClaimTypeId() {
        return claimTypeId;
    }

    public void setClaimTypeId(String claimTypeId) {
        this.claimTypeId = claimTypeId;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getIsDependant() {
        return isDependant;
    }

    public void setIsDependant(String isDependant) {
        this.isDependant = isDependant;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public List<ClaimFieldOption> getClaimFieldOptionList() {
        if (claimFieldOptionList == null) {
            claimFieldOptionList = new ArrayList<>();
            return claimFieldOptionList;
        }
        return claimFieldOptionList;
    }

    public void setClaimFieldOptionList(List<ClaimFieldOption> claimFieldOptionList) {
        this.claimFieldOptionList = claimFieldOptionList;
    }
}
