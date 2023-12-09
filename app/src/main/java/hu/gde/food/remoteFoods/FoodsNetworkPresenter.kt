package hu.gde.food.remoteFoods

import hu.gde.food.db.FoodEntity
import hu.gde.food.locator.ServiceLocator
import hu.gde.food.network.FoodDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodsNetworkPresenter : IFoodsNetworkPresenter {
    private val api by lazy { ServiceLocator.provideApi() }
    private val dao by lazy { ServiceLocator.provideFoodDao() }

    override var view: IFoodNetworkView? = null

    override fun getFoods() {
        api.loadFoods().enqueue(object : Callback<List<FoodDto>> {
            override fun onResponse(call: Call<List<FoodDto>>, response: Response<List<FoodDto>>) {
                if (response.isSuccessful) {
                    val foods = response.body()
                    val entities = foods.orEmpty().map { it.convertToEntity() }
                    saveFoodsToDb(entities)
                    view?.submitList(entities)
                } else {
                    // fail
                    view?.showError(response.message())
//                    view?.submitList(dao.getAll())
                }
            }

            override fun onFailure(call: Call<List<FoodDto>>, t: Throwable) {
                view?.showError(t.message ?: "error")
//                view?.submitList(dao.getAll())
            }

        })
    }

    private fun saveFoodsToDb(entities: List<FoodEntity>) {
        dao.insert(*entities.toTypedArray())
    }
}