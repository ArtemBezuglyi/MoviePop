package ru.artbez.moviepop.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.artbez.moviepop.models.MovieItemModel

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movieItemModel: MovieItemModel)

    @Delete
    suspend fun delete(movieItemModel: MovieItemModel)

    @Query("SELECT * from movie_table")
    fun getAllPopMovies(): LiveData<List<MovieItemModel>>

}