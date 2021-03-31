package com.documentary.home_feature

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.documentary.common_databinding.databinding.DataBoundListAdapter
import com.documentary.data.entities.CountryEntity
import com.documentary.home_feature.databinding.ItemCountryRowBinding

class CountriesAdapter(
) : DataBoundListAdapter<CountryEntity, ItemCountryRowBinding>(diffCallback = object :
    DiffUtil.ItemCallback<CountryEntity>() {

    override fun areItemsTheSame(oldItem: CountryEntity, newItem: CountryEntity): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: CountryEntity, newItem: CountryEntity): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}) {


    override fun createBinding(parent: ViewGroup): ItemCountryRowBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_country_row,
            parent,
            false
        )
    }

    override fun bind(binding: ItemCountryRowBinding, item: CountryEntity, position: Int) {
        binding.apply {
            countryData = item
            val that = this@CountriesAdapter
            horizontalArticleCard.setOnClickListener {
                Toast.makeText(
                    horizontalArticleCard.context,
                    "click ${item.country}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}