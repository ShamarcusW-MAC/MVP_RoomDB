package com.example.week5_day1_mvp_roomdb.presenter


class GuestPresenter: Contract.Presenter {

    private lateinit var myView: Contract.View

    override fun displayName(name: String) {


        myView.displayName(name)

    }

    override fun displayPrice(price: Int) {

        myView.displayCash(Integer.parseInt(price.toString()))
    }

    override fun setView(myView: Contract.View) {

        this.myView = myView

    }


}