package hu.gde.food.remoteFoods

import hu.gde.food.db.FoodEntity

interface IFoodsNetworkPresenter {
    var view: IFoodNetworkView?
    fun getFoods()
}

interface IFoodNetworkView {

    fun showError(msg: String)
    fun submitList(list: List<FoodEntity>)
}
