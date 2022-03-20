package com.mobisy.claimapp.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobisy.claimapp.model.Claims;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class ClaimDataConverter implements Serializable {
    @TypeConverter
    public String fromOptionValuesList(List<com.mobisy.claimapp.model.Claims> claimsList) {
        if (claimsList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<com.mobisy.claimapp.model.Claims>>() {
        }.getType();
        String json = gson.toJson(claimsList, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<com.mobisy.claimapp.model.Claims> toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<com.mobisy.claimapp.model.Claims>>() {
        }.getType();
        List<com.mobisy.claimapp.model.Claims> productCategoriesList = gson.fromJson(optionValuesString, type);
        return productCategoriesList;
    }
}
