package com.foo.coderswagn.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.foo.coderswagn.Adapters.CategoryAdapter
import com.foo.coderswagn.Adapters.CategoryRecycleAdapter
import com.foo.coderswagn.Model.Category
import com.foo.coderswagn.R
import com.foo.coderswagn.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

/*    lateinit var adapter : ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                DataService.categories)

        categoryListView.adapter = adapter
    }*/

    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this,DataService.categories)

        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)

/*        categoryListView.setOnItemClickListener{adapterView,view,i,l ->
            val category = DataService.categories[i]
            Toast.makeText(this,"You clicked on ${category.title} cell", Toast.LENGTH_SHORT).show()
        }*/
    }
}
