package hu.gde.food.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.gde.food.databinding.ActivityMainBinding
import hu.gde.food.localFoods.FoodsActivity
import hu.gde.food.locator.ServiceLocator
import hu.gde.food.remoteFoods.FoodsNetworkActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val foods by lazy { ServiceLocator.provideFoodDao().getAll() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.generate.setOnClickListener {
            binding.text.text = foods.randomOrNull()?.name ?: "list is empty"
        }
        binding.edit.setOnClickListener {
            startActivity(Intent(this, FoodsActivity::class.java))
        }

        binding.network.setOnClickListener {
            startActivity(Intent(this, FoodsNetworkActivity::class.java))
        }

//        binding.add.setOnClickListener {
//            val input = binding.input.text.toString()
//            if (!foods.contains(input)) {
//                foods.add(input)
//                binding.text.text = input
//            } else {
//                binding.text.text = "mar van ilyen"
//            }
//        }

        //        setContentView(R.layout.activity_main)

//        val hello1 = findViewById<Button>(R.id.hello1)
//        val hello2 = findViewById<View>(R.id.hello2)
    }
}

