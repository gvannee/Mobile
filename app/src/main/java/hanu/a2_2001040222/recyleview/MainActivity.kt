package hanu.a2_2001040222.recyleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import hanu.a2_2001040222.recyleview.adapter.FoodAdapter
import hanu.a2_2001040222.recyleview.model.Food

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf <Food>(
            Food(name = "bun", price = 10000),
            Food(name = "mi tom", price = 20000),
            Food(name = "com", price = 15000),
            Food(name = "mien", price = 100000)
        )

        val rcvFood = findViewById<RecyclerView>(R.id.rcvFood)
        val btnAdd = findViewById<Button>(R.id.btnClick)

        val foodAdapter = FoodAdapter(list)
        btnAdd.setOnClickListener {
//            list.add(Food("hu tiu 2", 200000))
//            list.removeAt(2)
            list[2] = Food("hu tiu 2", 200000)

//            foodAdapter.notifyItemInserted(list.size - 1)
            foodAdapter.notifyItemChanged(2)
        }

        foodAdapter.onItemClick = {food ->
            Toast.makeText(this, "$food", Toast.LENGTH_LONG).show()
            val intent = Intent(this, DetailActivity::class.java)

            intent.putExtra("name", food)
            startActivity(intent)
        }
        rcvFood.adapter = foodAdapter


    }
}