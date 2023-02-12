package com.simba.addatimes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simba.addatimes.data.models.Data
import com.simba.addatimes.databinding.ItemSeriesLayoutBinding

class WebSeriesAdapter(private var list: List<Data>) :
    RecyclerView.Adapter<WebSeriesAdapter.ItemViewHolder>() {

    var onItemClick: ((Data) -> Unit)? = null

    inner class ItemViewHolder(val binding: ItemSeriesLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ItemSeriesLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.title.text = this.title
                val episodesAdapter = EpisodesAdapter(this.items)
                binding.rvMinor.adapter = episodesAdapter
                episodesAdapter.onItemClick = {
                    Toast.makeText(holder.itemView.context, this.title, Toast.LENGTH_SHORT).show()
                }
                binding.rvMinor.layoutManager =
                    LinearLayoutManager(
                        holder.itemView.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
            }
            holder.itemView.setOnClickListener {
                onItemClick?.invoke(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}