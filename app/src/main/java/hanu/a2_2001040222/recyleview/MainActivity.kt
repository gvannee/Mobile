package hanu.a2_2001040222.recyleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import hanu.a2_2001040222.recyleview.adapter.FoodAdapter
import hanu.a2_2001040222.recyleview.appDatabase.AppDatabase
import hanu.a2_2001040222.recyleview.model.Food
import hanu.a2_2001040222.recyleview.viewModel.MainViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "db"
        ).build()
        val appDao = db.appDao()
        val viewModel = MainViewModel(appDao)

        val list = mutableListOf<Food>(
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
            viewModel.insertFood(Food(name = "Com chay", price = 60002))

//            foodAdapter.notifyItemInserted(list.size - 1)
//            foodAdapter.notifyItemChanged(2)
        }

        foodAdapter.onItemClick = { food ->
            Toast.makeText(this, "$food", Toast.LENGTH_LONG).show()
            val intent = Intent(this, DetailActivity::class.java)

            intent.putExtra("name", food)
            startActivity(intent)
        }


        viewModel.listFood.observe(this) {
            val foodsAdapter = FoodAdapter(it ?: emptyList())
            rcvFood.adapter = foodsAdapter
        }

        viewModel.fetchListFood()


//        lifecycleScope.launch(Dispatchers.Default) {
//            appDao.addFood(Food(id = 1, name = "Com rang", price = 28000))
//            val listFood = appDao.getAllFood()
//            withContext(Dispatchers.Main) {
//                Toast.makeText(this@MainActivity, "Add successfully", Toast.LENGTH_LONG).show()
//                val foodsAdapter =  FoodAdapter(listFood?: emptyList())
//                rcvFood.adapter = foodsAdapter
//            }
//        }

    }
}