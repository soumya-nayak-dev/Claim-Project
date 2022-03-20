package com.mobisy.claimapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClaimModel {
    @SerializedName("Result")
    private String results;
    @SerializedName("Reason")
    private String reasons;
    @SerializedName("Claims")
    private List<Claims> claimsList;

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public List<Claims> getClaimsList() {
        return claimsList;
    }

    public void setClaimsList(List<Claims> claimsList) {
        this.claimsList = claimsList;
    }
}
