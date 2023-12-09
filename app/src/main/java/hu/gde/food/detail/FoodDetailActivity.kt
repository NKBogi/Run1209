package hu.gde.food.detail

import android.app.Activity
import android.os.Bundle
import hu.gde.food.databinding.ActivityFoodDetailBinding
import hu.gde.food.db.durationString
import hu.gde.food.locator.ServiceLocator

class FoodDetailActivity : Activity() {

    lateinit var binding: ActivityFoodDetailBinding

    val dao by lazy { ServiceLocator.provideFoodDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val foodId = intent.getLongExtra("food_id", -1)
        dao.get(foodId)?.let {
            binding.name.text = it.name
            binding.kcal.text = it.durationString
            binding.desc.text = it.description
        } ?: kotlin.run {
            binding.name.text = "food not found"
        }
    }
}
