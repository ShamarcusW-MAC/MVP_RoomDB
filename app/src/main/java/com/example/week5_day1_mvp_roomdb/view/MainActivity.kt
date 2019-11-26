package com.example.week5_day1_mvp_roomdb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.week5_day1_mvp_roomdb.R
import com.example.week5_day1_mvp_roomdb.database.GuestDatabase
import com.example.week5_day1_mvp_roomdb.database.GuestEntity
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    companion object {

        lateinit var guestDB: GuestDatabase
    }


    val nameFragment = Name_Fragment()
    val priceFragment = Price_Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        guestDB = Room.databaseBuilder(
            this,
            GuestDatabase::class.java,
            "Guests.db"
        )
            .allowMainThreadQueries()
            .build()
        displayFragment()
        add_button.setOnClickListener {


            val name = name_edittext.text.toString()
            val price = Integer.parseInt(price_edittext.text.toString())
            val guestEntity = GuestEntity(name, price)
            guestDB.guestDAO().addNewGuest(guestEntity)
//            EventBus.getDefault().post(GuestEntity(name, price))
//            EventBus.getDefault().post(GuestEntity(name, price))
            EventBus.getDefault().post(guestDB)
            EventBus.getDefault().post(guestDB)
            clearFields()
        }



    }


    private fun displayFragment(){

        supportFragmentManager.beginTransaction()
            .add(R.id.name_fragment, nameFragment)
            .addToBackStack(nameFragment.tag)
            .commit()


        val priceFragment = Price_Fragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.price_fragment, priceFragment)
            .addToBackStack(priceFragment.tag)
            .commit()


    }

    private fun clearFields(){
        name_edittext.text.clear()
        price_edittext.text.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}
