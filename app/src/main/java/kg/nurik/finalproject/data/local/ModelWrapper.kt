package kg.nurik.finalproject.data.local

import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.model.command.FavouriteCommands

object ModelWrapper {
    fun commandsToFavouriteCommand(item: Commands) =
        FavouriteCommands(
            teamId = item.teamId,
            name = item.name,
            shortCode = item.shortCode,
            logo = item.logo,
            country = item.country,
            isChecked = item.isChecked
        )


    fun favouriteCommandToCommands(item: FavouriteCommands) =
        Commands(
            teamId = item.teamId,
            name = item.name,
            shortCode = item.shortCode,
            logo = item.logo,
            country = item.country,
            isChecked = item.isChecked
        )
}
