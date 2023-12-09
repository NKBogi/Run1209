package hu.gde.food.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val duration: Int,
    val description: String,
)

val FoodEntity.durationString: String
    get() = "$duration min"