package com.mobisy.claimapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {ClaimDbModel.class}, version = 2)
@TypeConverters({ClaimDataConverter.class, ClaimTypeDetailDataConverter.class, ClaimFieldDataConverter.class})
public abstract class ClaimDatabase extends RoomDatabase {
    private static ClaimDatabase instance;
    public abstract ClaimDao claimDao();

    // on below line we are getting instance for our database.
    public static synchronized ClaimDatabase getInstance(Context context) {
        // below line is to check if
        // the instance is null or not.
        if (instance == null) {
            // if the instance is null we
            // are creating a new instance
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ClaimDatabase.class, "claim-db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        // after creating an instance
        // we are returning our instance
        return instance;
    }

}
