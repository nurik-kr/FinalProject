package kg.nurik.finalproject.ui.bottomNav.tournaments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.season.DataSeason
import kotlinx.android.synthetic.main.item_commands.view.*

class TournamentsAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val list = arrayListOf<DataSeason>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_commands, parent, false)
        return ViewHolder(view)
    }

    fun update(list: List<DataSeason>?) {
        if (list != null) {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(point: DataSeason) {

        itemView.tv_status.text = point.status
        itemView.tv_home_team.text = point.homeTeam?.name
        itemView.tv_away_team.text = point.awayTeam?.name

    }
}