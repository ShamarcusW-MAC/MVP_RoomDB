package com.example.week5_day1_mvp_roomdb.presenter

interface Contract {
    interface Presenter{

        fun displayName(name: String)
        fun displayPrice(price: Int)

        fun setView(myView: Contract.View)
    }

    interface View{

        fun displayCash(answer: Int)

        fun displayName(answer: String)

    }
}