package com.mobisy.claimapp.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobisy.claimapp.model.ClaimTypeDetail;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class ClaimTypeDetailDataConverter implements Serializable {
    @TypeConverter
    public String fromOptionValuesList(List<com.mobisy.claimapp.model.ClaimTypeDetail> claimTypeDetailList) {
        if (claimTypeDetailList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<com.mobisy.claimapp.model.ClaimTypeDetail>>() {
        }.getType();
        String json = gson.toJson(claimTypeDetailList, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<com.mobisy.claimapp.model.ClaimTypeDetail> toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<com.mobisy.claimapp.model.ClaimTypeDetail>>() {
        }.getType();
        List<com.mobisy.claimapp.model.ClaimTypeDetail> productCategoriesList = gson.fromJson(optionValuesString, type);
        return productCategoriesList;
    }
}
