package com.example.cv.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.cv.db.DBConstans


@Entity(tableName = DBConstans.TABLE_User)
class UserEnt {

    constructor() {}

    @ColumnInfo(name = DBConstans.COLUMN_ID)
    @PrimaryKey(autoGenerate = false)
    var _id: Int = 1

    @ColumnInfo(name = DBConstans.COLUMN_Date)
    var mDate: Long = 0L

    @ColumnInfo(name = DBConstans.COLUMN_Name)
    var mName: String = ""

    @ColumnInfo(name = DBConstans.COLUMN_SurName)
    var mSurname: String = ""

    @ColumnInfo(name = DBConstans.COLUMN_Picture, typeAffinity = ColumnInfo.BLOB)
    var mPicture: ByteArray? = null

//    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
//    var mImage: ByteArray? = null

    @Ignore
    constructor( name: String, surname: String){
        mName = name
        mSurname = surname
        mDate = System.currentTimeMillis()
    }

    @Ignore
    constructor( name: String, surname: String, picture: ByteArray){
        mName = name
        mSurname = surname
        mPicture = picture
        mDate = System.currentTimeMillis()
    }


}