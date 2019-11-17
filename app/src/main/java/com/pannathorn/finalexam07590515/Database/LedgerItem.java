package com.pannathorn.finalexam07590515.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "ledger")
public class LedgerItem {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    public int id;

    @ColumnInfo(name = "FName")
    @SerializedName("FName")
    public String FName;

    @ColumnInfo(name = "UName")
    @SerializedName("UName")
    public String UName;

    @ColumnInfo(name = "PW")
    @SerializedName("PW")
    public String PW;

    public LedgerItem(int id, String FName, String UName , String PW) {
        this.id = id;
        this.FName = FName;
        this.UName = UName;
        this.PW = PW;
    }
}
