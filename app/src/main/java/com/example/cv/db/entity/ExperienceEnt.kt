package com.example.cv.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.cv.db.DBConstans

@Entity(tableName = DBConstans.TABLE_Experience)
class ExperienceEnt : DBConstans {

    constructor() {
    }

    @ColumnInfo(name = DBConstans.COLUMN_ID)
    @PrimaryKey(autoGenerate = true)
    var _id: Int = 0

    @ColumnInfo(name = DBConstans.COLUMN_ID_CV)
    var _idCV: Int = 0

    @ColumnInfo(name = DBConstans.COLUMN_DateStart)
    var mDateStart = 0L

    @ColumnInfo(name = DBConstans.COLUMN_DateEnd)
    var mDateEnd = 0L

    @ColumnInfo(name = DBConstans.COLUMN_Company)
    var mCompanyName: String = ""

    @ColumnInfo(name = DBConstans.COLUMN_Position)
    var mPosition: String = ""

    @ColumnInfo(name = DBConstans.COLUMN_Description)
    var mDescription: String = ""


//    @Ignore
//    constructor( resultEntity: ResultEntity) {
//        mDate = resultEntity.mDate
//        mNumber_1 = resultEntity.mNumber_1
//        mNumber_2 = resultEntity.mNumber_2
//        mNumber_3 = resultEntity.mNumber_3
//        mNumber_4 = resultEntity.mNumber_4
//        mNumber_5 = resultEntity.mNumber_5
//        mLuck_1 = resultEntity.mLuck_1
//        mLuck_2 = resultEntity.mLuck_2
//    }

//    @Ignore
//    constructor(id: Int, data: Long, n_1: Int, n_2: Int, n_3: Int, n_4: Int,
//                n_5: Int, l_1: Int, l_2: Int) {
//        ID = id
//        mDate = data
//        mNumber_1 = n_1
//        mNumber_2 = n_2
//        mNumber_3 = n_3
//        mNumber_4 = n_4
//        mNumber_5 = n_5
//        mLuck_1 = l_1
//        mLuck_2 = l_2
////        mJackpot = jackpot
////        mWins = wins
//    }

//    @Ignore
//    public fun getId(): Int{
//        return ID
//    }
}