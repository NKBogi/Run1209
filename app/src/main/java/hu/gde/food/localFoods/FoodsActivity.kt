package hu.gde.food.localFoods

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import hu.gde.food.R
import hu.gde.food.databinding.ActivityFoodsBinding
import hu.gde.food.db.FoodEntity
import hu.gde.food.detail.FoodDetailActivity
import hu.gde.food.locator.ServiceLocator

class FoodsActivity : Activity() {

    private lateinit var binding: ActivityFoodsBinding
    private lateinit var adapter: FoodAdapter

    private val foodDao by lazy { ServiceLocator.provideFoodDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = FoodAdapter(
            onItemClicked = {
                startActivity(Intent(this, FoodDetailActivity::class.java).apply {
                    putExtra("food_id", it)
                })
            },
//            onItemDelete = this::deleteFood,
            onItemDelete = {
                deleteFood(it)
            }
        ).also {
            adapter = it
            adapter.submitList(foodDao.getAll())
        }

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.add.setOnClickListener {
            val name = binding.foodName.text.toString()
            val kcal = binding.kcal.text.toString()
            if (name.isEmpty()) {
                binding.foodName.error = getString(R.string.field_required)
                return@setOnClickListener
            }
            foodDao.insert(
                FoodEntity(
                    name = name,
                    duration = kcal.toIntOrNull() ?: 0,
                    description = "desc"
                )
            )
            adapter.submitList(foodDao.getAll())
        }
    }

    private fun deleteFood(id: Long) {
        val entity = foodDao.get(id)
        entity?.let {
            foodDao.remove(it)
            adapter.submitList(foodDao.getAll())
        }
    }

    fun submitList() {
        adapter.submitList(foodDao.getAll())
    }
}

