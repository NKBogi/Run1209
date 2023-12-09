package hu.gde.food.localFoods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hu.gde.food.databinding.RowFoodBinding
import hu.gde.food.db.FoodEntity
import hu.gde.food.db.durationString

class FoodAdapter(
    val onItemClicked: (Long) -> Unit,
    val onItemDelete: (Long) -> Unit,
    val showDelete: Boolean = true
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private var foods: List<FoodEntity> = listOf()

    class FoodViewHolder(val binding: RowFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(
            RowFoodBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = foods.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foods[position]
        holder.binding.name.text = food.name
        holder.binding.kcal.text = food.durationString
        holder.binding.delete.visible(showDelete)
        holder.binding.delete.setOnClickListener {
            onItemDelete.invoke(food.id)
        }
        holder.binding.root.setOnClickListener {
            onItemClicked(food.id)
        }
    }

    fun submitList(data: List<FoodEntity>) {
        this.foods = data
        notifyDataSetChanged()
    }

    fun View.visible(visible: Boolean) {
        visibility = if (visible) View.VISIBLE else View.GONE
    }
}