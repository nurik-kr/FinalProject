package kg.nurik.finalproject.utils

import androidx.recyclerview.widget.DiffUtil
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
}