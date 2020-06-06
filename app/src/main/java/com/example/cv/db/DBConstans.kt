package com.example.cv.db

interface DBConstans {
    companion object {
        const val DB_NAME = "cv.db"
        const val DATABASE_VERSION = 1

        const val TABLE_User = "_user"
        const val COLUMN_Name = "_name"
        const val COLUMN_SurName = "_surname"
        const val COLUMN_Date = "_date"
        const val COLUMN_Picture = "_picture"


        const val TABLE_Experience = "_experience"
        const val COLUMN_ID = "_id"
        const val COLUMN_ID_CV = "_id_cv"
        const val COLUMN_DateStart = "_date_start"
        const val COLUMN_DateEnd = "_date_end"
        const val COLUMN_Company = "_company"
        const val COLUMN_Position = "_position"
        const val COLUMN_Description = "_description"
    }
}