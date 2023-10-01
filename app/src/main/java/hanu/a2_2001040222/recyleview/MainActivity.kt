package hanu.a2_2001040222.recyleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import hanu.a2_2001040222.recyleview.adapter.FoodAdapter
import hanu.a2_2001040222.recyleview.model.Food

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = mutableListOf(
            Food(name = "bun", price = 10000),
            Food(name = "mi tom", price = 20000),
            Food(name = "com", price = 15000),
            Food(name = "mien", price = 100000)
        )
        list.add(Food("hu tiu", 200000))

        val rcvFood = findViewById<RecyclerView>(R.id.rcvFood)
        val foodAdapter = FoodAdapter(list)

        rcvFood.adapter = foodAdapter
    }
}