package com.documentary.home_feature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.documentary.data.entities.CountryEntity
import com.documentary.home_feature.databinding.ItemCountryRowBinding

class CountriesAdapter(
    private val onCountryItem: (countryEntity: CountryEntity) -> Unit
) : ListAdapter<CountryEntity, CountriesAdapter.CountryViewHolder>(object :
    DiffUtil.ItemCallback<CountryEntity>() {
    override fun areItemsTheSame(oldItem: CountryEntity, newItem: CountryEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CountryEntity, newItem: CountryEntity): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}) {

    inner class CountryViewHolder(private val dataBinding: ItemCountryRowBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {

        init {
            dataBinding.countryName.setOnClickListener {
                onCountryItem(getItem(adapterPosition))
            }
        }

        fun bind(country: CountryEntity) {
            itemView.apply {
                dataBinding.countryData = country
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            ItemCountryRowBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}