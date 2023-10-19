package hanu.a2_2001040222.recyleview.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hanu.a2_2001040222.recyleview.appDAO.AppDAO
import hanu.a2_2001040222.recyleview.model.Food
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel (val dao: AppDAO) : ViewModel() {
    val listFood: MutableLiveData<List<Food>?> = MutableLiveData()

    fun fetchListFood() {
        viewModelScope.launch (Dispatchers.Default) {
            val list = dao.getAllFood()
            withContext(Dispatchers.Main) {
                listFood.value = list
            }
        }
    }

    fun insertFood(food: Food) {
        viewModelScope.launch (Dispatchers.Default) {
            dao.addFood(food)
            withContext(Dispatchers.Main) {
                fetchListFood()
            }
        }
    }
}