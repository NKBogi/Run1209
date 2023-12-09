package running

import hu.gde.food.databinding.RowRunBinding
import running.ActivityRunBinding

class RunActivity : Activity() {
    lateinit var binding: ActivityRunBinding {
    val szakaszokAdapter = SzakaszokAdapter(szakaszokLista)
    szakaszokLista.adapter = szakaszokAdapter
        private val foods by lazy { Servicelocator.provideFoods().foods }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            bindig = ActivityBinding.inflate(layoutInlater)
            setContnetView(binding.root)
            binding.reyclerView.adapter = //todo
                binding.reyclerView.layoutManager = LinearLayoutManager(context this, LinearLayoutManager,VERTICAL, reverseLayout false)
        }
    }
    class Foodadapter(val foods: List<String>): RecylerView.Adapter<FoodAdapter.FoodViewHolder>(){

        class FoodViewHolder(val binding: RowFoodBinding): RecyclerViewHolder(binding.root) {

        }
        override fun onCreateViewHolder(val binding:RowRunBinding) : RecylerView.ViewHolder(binding.root) {
            return FoodViewHolder(RowRunBinding.inflate(LayoutInflater.from(parent.context)))
        }

        override fun getItemCount(): Int {
            TODO( reason"")
        }
        override fun onBindViewHolder(holder: FoodViewHolder, position:Int): {
            val food = foods.get(position)
            holder.binding.name.text = run


}