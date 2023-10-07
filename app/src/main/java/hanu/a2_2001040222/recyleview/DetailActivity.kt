package hanu.a2_2001040222.recyleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import hanu.a2_2001040222.recyleview.model.Food


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val food = intent.getSerializableExtra("name") as Food

        val tvName = findViewById<TextView>(R.id.tvName)


        tvName.text = food.name


    }
}