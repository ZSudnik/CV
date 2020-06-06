package com.example.cv.db.doa

import androidx.room.*
import com.example.cv.db.DBConstans
import com.example.cv.db.entity.ExperienceEnt

@Dao
interface ExperienceDAO {
    @Query("SELECT * FROM " + DBConstans.TABLE_Experience + " WHERE " + DBConstans.COLUMN_ID_CV + " = :idCV  ORDER BY " + DBConstans.COLUMN_ID + " ASC")
    fun getAll(idCV: Int): List<ExperienceEnt>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArr(vararg experienceEnts: ExperienceEnt?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOne(experience_ent: ExperienceEnt?): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(experienceEntList: List<ExperienceEnt?>?)

    @Delete
    fun delete(experienceEnt: ExperienceEnt?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateOne(experienceEnt: ExperienceEnt?)
}