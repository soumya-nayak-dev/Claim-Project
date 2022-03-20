package com.mobisy.claimapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Claims {
    @SerializedName("Claimtype")
    ClaimType claimType;
    @SerializedName("Claimtypedetail")
    List<ClaimTypeDetail> claimTypeDetailList;

    public ClaimType getClaimType() {
        return claimType;
    }

    public void setClaimType(ClaimType claimType) {
        this.claimType = claimType;
    }

    public List<ClaimTypeDetail> getClaimTypeDetailList() {
        if (claimTypeDetailList == null) {
            claimTypeDetailList = new ArrayList<>();
            return claimTypeDetailList;
        }
        return claimTypeDetailList;
    }

    public void setClaimTypeDetailList(List<ClaimTypeDetail> claimTypeDetailList) {
        this.claimTypeDetailList = claimTypeDetailList;
    }
}
