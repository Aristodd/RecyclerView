package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.recyclerview.databinding.ActivityDetailSuperheroBinding

class DetailSuperheroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSuperheroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val superhero = intent.getParcelableExtra<Superhero>(MainActivity.INTENT_PARCELABLE)

        binding.imgItemPhoto.setImageResource(superhero?.imgSuperhero!!)
        binding.tvItemName.text = superhero.nameSuperhero
        binding.tvItemDescription.text = superhero.descSuperhero

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}