package com.foo.coderswagn.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.foo.coderswagn.Model.Category
import com.foo.coderswagn.R

/**
 * Created by David Chhetri on 23,November,2021
 */
class CategoryAdapter(context: Context, categories: List<Category>): BaseAdapter() {

    val context = context
    val categories = categories

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View

        //here we have extracted ImageView and TextView from the layout file
        categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
        val categoryImage : ImageView = categoryView.findViewById(R.id.categoryImage)
        val categoryName : TextView = categoryView.findViewById(R.id.categoryName)

        println("Heavy Computing")

        //here we set the image and text that is extracted from the provided List to the
        //ImageView and TextView extracted earlier from layout
        val category = categories[position]
        //get resourceID from name of the image from category list
        val resourceId = context.resources.getIdentifier(category.image, "drawable",context.packageName)
        categoryImage.setImageResource(resourceId)

        println(resourceId)

        categoryName.text = category.title

        return  categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return  categories.count()
    }


}