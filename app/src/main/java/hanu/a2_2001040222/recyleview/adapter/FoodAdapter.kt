package hanu.a2_2001040222.recyleview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hanu.a2_2001040222.recyleview.R
import hanu.a2_2001040222.recyleview.model.Food


//class FoodAdapter(private val list: List<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
//
//    var onItemClick : (Food) -> Unit = {
//
//    }
//    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        private val tvPrice = view.findViewById<TextView>(R.id.tvPrice)
//        private val tvName = view.findViewById<TextView>(R.id.tvPho)
//
//        init {
//            view.rootView.setOnClickListener {
//                onItemClick.invoke(list[layoutPosition])
//            }
//        }
//        fun onBind(food: Food) {
//            tvPrice.text = food.price.toString()
//            tvName.text = food.name
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val itemView = inflater.inflate(R.layout.item_food, parent, false)
//        return FoodViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int = list.size
//
//
//    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
//        holder.onBind(list[position])
//    }
//}

class FoodAdapter : ListAdapter<Food, FoodAdapter.FoodViewHolder>(FoodDiffUtil()) {
    internal var onItemClick: (Food) -> Unit = {

    }
    internal var positionSelected = -1

    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvPrice = view.findViewById<TextView>(R.id.tvPrice)
        private val tvName = view.findViewById<TextView>(R.id.tvPho)

        init {
            view.rootView.setOnClickListener {
                notifyItemChanged(positionSelected)
                positionSelected = layoutPosition
                notifyItemChanged(layoutPosition)
                onItemClick.invoke(currentList[layoutPosition])
            }
        }

        fun onBind(food: Food) {
            tvPrice.text = food.price.toString()
            tvName.text = food.name
            if (layoutPosition == positionSelected) {
                itemView.setBackgroundColor(tvName.context.getColor(R.color.teal_200))
            } else {
                itemView.setBackgroundColor(tvName.context.getColor(R.color.purple_200))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}

class FoodDiffUtil : ItemCallback<Food>() {
    override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem.id == newItem.id && oldItem.name == newItem.name
    }

}