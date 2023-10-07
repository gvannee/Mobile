package hanu.a2_2001040222.recyleview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hanu.a2_2001040222.recyleview.R
import hanu.a2_2001040222.recyleview.model.Food


class FoodAdapter(private val list: List<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    var onItemClick : (Food) -> Unit = {

    }
    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvPrice = view.findViewById<TextView>(R.id.tvPrice)
        private val tvName = view.findViewById<TextView>(R.id.tvPho)

        init {
            view.rootView.setOnClickListener {
                onItemClick.invoke(list[layoutPosition])
            }
        }
        fun onBind(food: Food) {
            tvPrice.text = food.price.toString()
            tvName.text = food.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}