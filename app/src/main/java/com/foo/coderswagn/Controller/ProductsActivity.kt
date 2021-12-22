package com.foo.coderswagn.Controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import com.foo.coderswagn.Adapters.ProductsAdapter
import com.foo.coderswagn.R
import com.foo.coderswagn.Services.DataService
import com.foo.coderswagn.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val intent = this.intent

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if(screenSize>720){
            spanCount = 4
        }

        val layoutManager = GridLayoutManager(this,spanCount)
        productsListView.adapter = adapter
        productsListView.layoutManager = layoutManager
        productsListView.setHasFixedSize(true)



    }
}
