package com.example.lab1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val name = intent.extras?.getString("name") ?: "Unknown name"
        val description = intent.extras?.getString("description") ?: "Unknown description"
        val image = intent.extras?.getInt("image") ?: R.mipmap.ic_launcher

        val animal = Animal(name, description, image)
        loadData(animal)
    }

    private fun loadData(animal: Animal) {
        val nameTextView: TextView = findViewById(R.id.detailsNameTextView)
        val descriptionTextView: TextView = findViewById(R.id.detailsDescriptionTextView)
        val imageView: ImageView = findViewById(R.id.detailsImageView)

        nameTextView.text = animal.name
        descriptionTextView.text = animal.description
        imageView.setImageResource(animal.imageResource)
    }
}