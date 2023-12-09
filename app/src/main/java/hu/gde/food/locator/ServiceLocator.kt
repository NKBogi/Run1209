package hu.gde.food.locator

import android.content.Context
import hu.gde.food.db.FoodDao
import hu.gde.food.db.FoodDatabase
import hu.gde.food.network.Api
import hu.gde.food.network.Network

object ServiceLocator {

    private lateinit var db: FoodDatabase

//    private val foodProvider: FoodProvider by lazy { FoodProvider() }

    private val foodDao: FoodDao by lazy { db.foodDao() }

    private val api: Api by lazy { Network().api() }

    fun provideFoodDao() = foodDao

//    fun provideFoods() = foodProvider

    fun provideApi() = api

    fun provide(context: Context) {
        db = FoodDatabase.buildDatabase(context)
    }
}