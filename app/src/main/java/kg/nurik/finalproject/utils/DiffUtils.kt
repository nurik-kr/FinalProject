package kg.nurik.finalproject.utils

import androidx.recyclerview.widget.DiffUtil
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.command.FavouriteCommands

object DiffUtils {
    val diffUtilItems = object : DiffUtil.ItemCallback<FavouriteCommands>() {
        override fun areItemsTheSame(
            oldItem: FavouriteCommands,
            newItem: FavouriteCommands
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: FavouriteCommands,
            newItem: FavouriteCommands
        ): Boolean {
            return oldItem.isChecked == newItem.isChecked &&
                    oldItem.teamId == newItem.teamId &&
                    oldItem.country == newItem.country &&
                    oldItem.name == newItem.name
        }
    }

    val diffUtilSearch = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.countryId == newItem.countryId &&
                    oldItem.name == newItem.name &&
                    oldItem.countryCode == newItem.countryCode &&
                    oldItem.continent == newItem.continent
        }
    }
}