package com.foo.coderswagn.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foo.coderswagn.Adapters.CategoryAdapter
import com.foo.coderswagn.Adapters.CategoryRecycleAdapter
import com.foo.coderswagn.Model.Category
import com.foo.coderswagn.R
import com.foo.coderswagn.Services.DataService
import com.foo.coderswagn.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories){
            category ->

        //println(category.title)
        val  productIntent = Intent(this, ProductsActivity::class.java)
        productIntent.putExtra(EXTRA_CATEGORY, category.title)
        startActivity(productIntent)

        }


        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)


    }
}
