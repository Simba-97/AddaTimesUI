package com.simba.addatimes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simba.addatimes.data.models.Item
import com.simba.addatimes.databinding.ItemSeriesEpisodesLayoutBinding
import com.simba.addatimes.utils.BindingUtils

class EpisodesAdapter(private var list: List<Item>) :
    RecyclerView.Adapter<EpisodesAdapter.ItemViewHolder>() {

    var onItemClick: ((Item) -> Unit)? = null

    inner class ItemViewHolder(val binding: ItemSeriesEpisodesLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ItemSeriesEpisodesLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                BindingUtils.loadAndBindImage(
                    binding.ivEpisodes,
                    this.vertical_image
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