package com.example.lab1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animals = arrayOf(
            Animal(
                "Cat",
                "A cat is a playful and independent pet with sharp senses and hunting instincts.",
                R.mipmap.ic_cat_round
            ),
            Animal(
                "Dog",
                "A dog is a loyal domesticated mammal, known for sits diverse breeds and roles.",
                R.mipmap.ic_dog_round
            ),
            Animal(
                "Snake",
                "A snake is a legless reptile, varying from harmless to venomous species.",
                R.mipmap.ic_snake_round
            ),
        )
        val adapter = AnimalsAdapter(animals) {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("description", it.description)
            intent.putExtra("image", it.imageResource)
            startActivity(intent)
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
}