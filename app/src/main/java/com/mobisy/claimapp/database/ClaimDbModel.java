package com.mobisy.claimapp.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "claim_table")
public class ClaimDbModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String results;
    private String reasons;
    private List<com.mobisy.claimapp.model.Claims> claimsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<com.mobisy.claimapp.model.Claims> getClaimsList() {
        if (claimsList == null) {
            claimsList = new ArrayList<>();
            return claimsList;
        }
        return claimsList;
    }

    public void setClaimsList(List<com.mobisy.claimapp.model.Claims> claimsList) {
        this.claimsList = claimsList;
    }
}
