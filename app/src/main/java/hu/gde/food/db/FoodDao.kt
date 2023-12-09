package hu.gde.food.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg data: FoodEntity)

    @Query("SELECT * FROM foods ORDER BY duration DESC")
    fun getAll(): List<FoodEntity>

    @Query("SELECT * FROM foods WHERE id = :id LIMIT 1")
    fun get(id: Long): FoodEntity?

    @Delete
    fun remove(data: FoodEntity)
}