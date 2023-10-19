package hanu.a2_2001040222.recyleview.appDAO

import androidx.room.*
import hanu.a2_2001040222.recyleview.model.Food

@Dao
interface AppDAO {
    @Query("SELECT * FROM Food")
    fun getAllFood() : List<Food>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFood(food: Food)

    @Insert
    fun addListFood(list: List<Food>)

    @Query("UPDATE Food SET name= :name WHERE id= :id")
    fun updateFood(name: String, id: Int)

    @Delete
    fun deleteFood(food: Food)
}