package hu.gde.food.network

data class FoodDto(
    val id: Long,
    val name: String,
    val duration: Int,
    val difficulty: String,
    val ingredients: List<String>,
    val description: String,
)