package com.example.cv.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cv.db.doa.ExperienceDAO
import com.example.cv.db.doa.UserDAO
import com.example.cv.db.entity.ExperienceEnt
import com.example.cv.db.entity.UserEnt

@Database(
    entities = [ExperienceEnt::class, UserEnt::class],
    version = DBConstans.DATABASE_VERSION,
    exportSchema = false
)
abstract class RoomDB : RoomDatabase() {
    abstract fun experienceDAO(): ExperienceDAO?
    abstract fun userDAO(): UserDAO?

    companion object {
        private var INSTANCE: RoomDB? = null
        private var context: Context? = null
        @JvmStatic
        fun getAppDatabase(mContext: Context?): RoomDB? {
            context = mContext
            if (INSTANCE == null) {
                synchronized(RoomDB::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            mContext!!,
                            RoomDB::class.java,
                            DBConstans.DB_NAME
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            if (INSTANCE != null && INSTANCE!!.isOpen) {
                INSTANCE!!.close()
            }
            INSTANCE = null
        }
    }
}