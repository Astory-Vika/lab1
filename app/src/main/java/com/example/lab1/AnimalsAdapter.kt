package com.example.lab1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalsAdapter(
    private val dataSet: Array<Animal>, private val onDetailsClick: (Animal) -> Unit
) : RecyclerView.Adapter<AnimalsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val descriptionTextView: TextView
        val imageView: ImageView
        val detailsButton: Button

        init {
            nameTextView = view.findViewById(R.id.nameTextView)
            descriptionTextView = view.findViewById(R.id.descriptionTextView)
            imageView = view.findViewById(R.id.imageView)
            detailsButton = view.findViewById(R.id.detailsButton)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.animal_row_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.nameTextView.text = dataSet[position].name
        viewHolder.descriptionTextView.text = dataSet[position].description
        viewHolder.imageView.setImageResource(dataSet[position].imageResource)
        viewHolder.detailsButton.setOnClickListener {
            onDetailsClick(dataSet[position])
        }
    }

    override fun getItemCount() = dataSet.size
}