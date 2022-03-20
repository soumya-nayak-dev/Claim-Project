package com.mobisy.claimapp.model;

import com.google.gson.annotations.SerializedName;

public class ClaimTypeDetail {
    @SerializedName("claimfield_id")
    private String claimFieldId;
    @SerializedName("id")
    private String id;
    @SerializedName("claimtype_id")
    private String claimTypeId;
    @SerializedName("Claimfield")
    ClaimField claimField;

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

    public String getClaimTypeId() {
        return claimTypeId;
    }

    public void setClaimTypeId(String claimTypeId) {
        this.claimTypeId = claimTypeId;
    }

    public ClaimField getClaimField() {
        return claimField;
    }

    public void setClaimField(ClaimField claimField) {
        this.claimField = claimField;
    }
}
