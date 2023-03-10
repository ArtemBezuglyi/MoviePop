package ru.artbez.moviepop.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.artbez.moviepop.data.room.dao.MoviesDao
import ru.artbez.moviepop.models.MovieItemModel

@Database(entities = [MovieItemModel::class], version = 1)
abstract class MoviesRoomDatabase: RoomDatabase() {

    abstract fun getMovieDao(): MoviesDao

    companion object{
        private var database: MoviesRoomDatabase ?= null

        fun getInstance(context: Context): MoviesRoomDatabase{
            return if (database == null) {
                database = Room
                    .databaseBuilder(context, MoviesRoomDatabase::class.java, "db ")
                    .build()
                database as MoviesRoomDatabase
            } else {
                database as MoviesRoomDatabase
            }
        }

    }

}