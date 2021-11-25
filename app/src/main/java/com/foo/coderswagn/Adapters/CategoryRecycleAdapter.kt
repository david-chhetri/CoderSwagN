package com.foo.coderswagn.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.foo.coderswagn.Model.Category
import com.foo.coderswagn.R

/**
 * Created by David Chhetri on 23,November,2021
 */
class CategoryRecycleAdapter(val context: Context, val categories: List<Category>) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindCategory(categories[position], context)

    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        //here we inflate
        val view = LayoutInflater.from(context)
            .inflate(R.layout.category_list_item, parent,false)

        return Holder(view)

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //bindings happens in the Holder class
        //get reference to the UI element and then we bind the data
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        //this function is needed to be called from fun onBindViewHolder()
        fun bindCategory(category: Category, context: Context){
            val  resourceId = context.resources.getIdentifier(category.image, "drawable",context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title
        }

    }


}