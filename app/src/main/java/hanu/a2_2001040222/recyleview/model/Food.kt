package hanu.a2_2001040222.recyleview.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Food")
data class Food(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Int,
    val type: FoodType = FoodType.monHan
) : java.io.Serializable

enum class FoodType {
    monChay, monMan, monViet, monHan
}