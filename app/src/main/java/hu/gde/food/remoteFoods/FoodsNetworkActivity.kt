package hu.gde.food.remoteFoods

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import hu.gde.food.databinding.ActivityFoodsBinding
import hu.gde.food.db.FoodEntity
import hu.gde.food.detail.FoodDetailActivity
import hu.gde.food.localFoods.FoodAdapter
import hu.gde.food.network.FoodDto

class FoodsNetworkActivity : Activity(), IFoodNetworkView {

    private lateinit var binding: ActivityFoodsBinding
    private lateinit var adapter: FoodAdapter

    private var presenter: IFoodsNetworkPresenter = FoodsNetworkPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            foodName.isEnabled = false
            kcal.isEnabled = false
            add.isEnabled = false
        }

        binding.recyclerView.adapter = FoodAdapter(
            onItemClicked = {
                startActivity(Intent(this, FoodDetailActivity::class.java).apply {
                    putExtra("food_id", it)
                })
            },
            onItemDelete = {
//                deleteFood(it)
            },
            showDelete = false
        ).also {
            adapter = it
            presenter.getFoods()
        }

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onStart() {
        super.onStart()
        presenter.view = this
    }

    override fun onStop() {
        super.onStop()
        presenter.view = null
    }

    override fun showError(msg: String) {
        binding.recyclerView.visibility = View.GONE
        binding.error.text = msg
        binding.error.visibility = View.VISIBLE
    }

    override fun submitList(list: List<FoodEntity>) {
        adapter.submitList(list)
    }
}

fun FoodDto.convertToEntity(): FoodEntity {
    return FoodEntity(id, name, duration, description)
}