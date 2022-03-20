package com.mobisy.claimapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ClaimDao {
    @Insert
    void insertClaim(ClaimDbModel claimDbModel);

    @Query("SELECT * FROM claim_table")
    LiveData<List<ClaimDbModel>> getAllClaims();


    @Query("SELECT * FROM claim_table WHERE claimsList IN (:label)" )
    List<ClaimDbModel> getAll(String label);

    @Delete
    void deleteClaimRecord(ClaimDbModel claimDbModel);

}
