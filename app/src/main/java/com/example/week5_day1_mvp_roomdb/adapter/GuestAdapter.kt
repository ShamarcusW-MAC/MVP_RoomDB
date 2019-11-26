package com.example.week5_day1_mvp_roomdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.week5_day1_mvp_roomdb.R
import com.example.week5_day1_mvp_roomdb.database.GuestEntity

class GuestAdapter(private val currentGuests: List<GuestEntity>, private val guestAdapterDelegate: FragmentActivity?) :
    RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {

    interface GuestAdapterDelegate{
        fun deleteGuest(guest: GuestEntity)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GuestAdapter.GuestViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.name_item_layout,
                parent,
                false
            )
        return GuestViewHolder(view)

    }

    override fun getItemCount(): Int {

        return currentGuests.size

    }

    override fun onBindViewHolder(holder: GuestAdapter.GuestViewHolder, position: Int) {
        holder.apply {
            guestName.text = "${currentGuests[position].guestName}"
        }

    }

    inner class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val guestName : TextView = itemView.findViewById(R.id.namelist_textview)

    }

}