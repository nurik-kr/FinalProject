package kg.nurik.finalproject.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.utils.DiffUtils
import kotlinx.android.synthetic.main.item_all_games.view.*

class SearchAdapter() : ListAdapter<Data, SearchViewHolder>(DiffUtils.diffUtilSearch) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_all_games, parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(point: Data) {
        itemView.tv_name.text = point.name
    }
}