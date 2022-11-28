package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemSuperheroBinding

class SuperheroAdapter (private val context: Context, private val superhero: List<Superhero>, val listener: (Superhero) -> Unit): RecyclerView.Adapter<SuperheroAdapter.SuperheroViewHolder>(){

    class SuperheroViewHolder(val binding: ItemSuperheroBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindView(superhero: Superhero, listener: (Superhero) -> Unit){
            binding.imgItemPhoto.setImageResource(superhero.imgSuperhero)
            binding.tvItemName.text = superhero.nameSuperhero
            binding.tvItemDescription.text = superhero.descSuperhero
            itemView.setOnClickListener {
                listener(superhero)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val binding = ItemSuperheroBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SuperheroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bindView(superhero[position], listener)
    }

    override fun getItemCount(): Int = superhero.size

}