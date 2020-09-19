package com.example.plobal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.plobal.Model.Data
import com.example.plobal.Model.Json4Kotlin_Base
import com.example.plobal.Model.apps

class MainActivity : AppCompatActivity() {

    private  val userList: MutableList<apps> = mutableListOf()
    private lateinit var customAdapter:CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customAdapter = CustomAdapter(userList)


        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        recyclerView.adapter = customAdapter
       // fbtnSortBy.setOnClickListener(View.OnClickListener { Toast.makeText(this,"Displayed",LENGTH_LONG).show() })

        //setup Android networking
        AndroidNetworking.initialize(this)

        AndroidNetworking.get("https://plobalapps.s3-ap-southeast-1.amazonaws.com/dummy-app-data.json")
            .build()
            .getAsObject(Json4Kotlin_Base::class.java,object : ParsedRequestListener<Json4Kotlin_Base> {
                override fun onResponse(response: Json4Kotlin_Base) {

                    Log.d("Response", "Success")

                    userList.addAll(response.apps)
                    customAdapter.notifyDataSetChanged()
                }

                override fun onError(anError: ANError?) {

                    Log.d("Response", "Fail")

                }

            })
    }
   // fbtnSortBy.setOnClickListener(View.OnClickListener { Toast.makeText(this,"Displayed",LENGTH_LONG).show() })

}