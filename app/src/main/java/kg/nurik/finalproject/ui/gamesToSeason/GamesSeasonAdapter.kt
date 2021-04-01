package kg.nurik.finalproject.ui.gamesToSeason

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.season.DataSeason
import kotlinx.android.synthetic.main.item_games_season.view.*

class GamesSeasonAdapter(private val listener: (item: DataSeason) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {

    private val list = arrayListOf<DataSeason>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_games_season, parent, false)
        return ViewHolder(view, listener)
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

class ViewHolder(view: View, private val listener: (item: DataSeason) -> Unit) :
    RecyclerView.ViewHolder(view) {

    fun bind(point: DataSeason) {

        itemView.tv_home_team_name.text = point.homeTeam?.name
        itemView.tv_away_team_name.text = point.awayTeam?.name
        itemView.tv_date.text = point.match_start

        Picasso.get().load(point.homeTeam?.logo).into(itemView.logo_home)
        Picasso.get().load(point.awayTeam?.logo).into(itemView.logo_away)

        itemView.setOnClickListener {
            listener.invoke(point)
        }
    }
}