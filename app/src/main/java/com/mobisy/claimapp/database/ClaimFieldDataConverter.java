package com.mobisy.claimapp.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobisy.claimapp.model.ClaimFieldOption;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class ClaimFieldDataConverter implements Serializable {
    @TypeConverter
    public String fromOptionValuesList(List<com.mobisy.claimapp.model.ClaimFieldOption> claimFieldOptionList) {
        if (claimFieldOptionList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<com.mobisy.claimapp.model.ClaimFieldOption>>() {
        }.getType();
        String json = gson.toJson(claimFieldOptionList, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<com.mobisy.claimapp.model.ClaimFieldOption> toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<com.mobisy.claimapp.model.ClaimFieldOption>>() {
        }.getType();
        List<com.mobisy.claimapp.model.ClaimFieldOption> productCategoriesList = gson.fromJson(optionValuesString, type);
        return productCategoriesList;
    }
}
