package com.example.week5_day1_mvp_roomdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.week5_day1_mvp_roomdb.R
import com.example.week5_day1_mvp_roomdb.database.GuestEntity

class PriceAdapter(private val currentGuests: List<GuestEntity>, private val priceAdapterDelegate: FragmentActivity?) :
    RecyclerView.Adapter<PriceAdapter.GuestViewHolder>() {

    interface PriceAdapterDelegate{
        fun deleteGuest(guest: GuestEntity)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PriceAdapter.GuestViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.price_item_layout,
                parent,
                false)

        return GuestViewHolder(view)
    }

    override fun getItemCount(): Int {

        return currentGuests.size
    }

    override fun onBindViewHolder(holder: PriceAdapter.GuestViewHolder, position: Int) {

        holder.apply {
            guestPrice.text = currentGuests[position].guestPrice.toDollar()
        }

    }

    private fun Int.toDollar() : String {
        return "$$this.00"
    }

    inner class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val guestPrice : TextView = itemView.findViewById(R.id.pricelist_textview)

    }

}