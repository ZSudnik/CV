package com.example.cv.db.doa

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.cv.db.DBConstans
import com.example.cv.db.entity.UserEnt

@Dao
interface UserDAO {

    @get:Query("SELECT * FROM " + DBConstans.TABLE_User + " ORDER BY " + DBConstans.COLUMN_ID + " ASC")
    val all: List<UserEnt?>?

    @Query("SELECT * FROM "+ DBConstans.TABLE_User + " ORDER BY " + DBConstans.COLUMN_ID + " ASC")
    fun allList(): DataSource.Factory<Int, UserEnt>

    @Query("SELECT * FROM "+ DBConstans.TABLE_User + " ORDER BY " + DBConstans.COLUMN_ID + " ASC")
    fun getAllLiveData() : LiveData<List<UserEnt>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOne(userEnt: UserEnt?): Long

    @Delete
    fun delete(userEnt: UserEnt?)
}