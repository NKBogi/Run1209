package hu.gde.food.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @GET("udemx/hr-resources/master/recipe.json")
    fun loadFoods(): Call<List<FoodDto>>

    @GET("udemx/hr-resources/master/{id}")
    fun getFood(@Path("id") id: Long): Call<FoodDto>

    @POST("/saveFood")
    fun saveFood(@Body body: FoodDto): Call<Unit>

    @DELETE("/deleteFood/{id}")
    fun deleteFood(@Path("id") id: Long): Call<Unit>
}