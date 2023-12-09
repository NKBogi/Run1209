package hu.gde.food

import android.app.Application
import hu.gde.food.locator.ServiceLocator

class FoodApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ServiceLocator.provide(this)
    }
}