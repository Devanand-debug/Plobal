package com.example.plobal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plobal.Model.apps
import kotlinx.android.synthetic.main.list_layout.view.*

class CustomAdapter (val userList: MutableList<apps>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private lateinit var context: Context

    class ViewHolder (itemView: View): RecyclerView.ViewHolder (itemView) {

        // val imageView = itemView.findViewById(R.id.image_view) as ImageView
        val companyName =  itemView.findViewById(R.id.company_name) as TextView
        val currency = itemView.findViewById(R.id.currency) as TextView
        val view_Details = itemView.findViewById(R.id.view_Details) as Button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = userList[position]

        //val userDownloads = holder.itemView.Downloads

        // val userImageView = holder.itemView.image_view
        val usercompanyName = holder.itemView.company_name
        val usercurrency = holder.itemView.currency
        val userviewDetails = holder.itemView.view_Details

        holder.itemView.setOnClickListener (View.OnClickListener {
            //Toast.makeText(context, usercompanyName, Toast.LENGTH_SHORT).show()
            //holder.companyName.setText(userCompanyName)
        })




    }

}