package hanu.a2_2001040222.recyleview.model

data class Food (val name: String, val price: Int, val type: FoodType = FoodType.monHan) : java.io.Serializable

enum class FoodType{
    monChay, monMan, monViet, monHan
}