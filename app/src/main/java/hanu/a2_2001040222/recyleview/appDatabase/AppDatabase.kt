package hanu.a2_2001040222.recyleview.appDatabase

import androidx.room.Database

import androidx.room.RoomDatabase
import hanu.a2_2001040222.recyleview.appDAO.AppDAO
import hanu.a2_2001040222.recyleview.model.Food

@Database(entities = [Food::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao() : AppDAO
}