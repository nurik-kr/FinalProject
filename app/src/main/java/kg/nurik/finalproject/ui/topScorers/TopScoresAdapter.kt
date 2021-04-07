package kg.nurik.finalproject.ui.topScorers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.topScores.TopScores
import kotlinx.android.synthetic.main.item_top_scores.view.*

class TopScoresAdapter() : RecyclerView.Adapter<ViewHolder>() {

    private val list = arrayListOf<TopScores>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_top_scores, parent, false)
        return ViewHolder(view)
    }

    fun update(list: List<TopScores>?) {
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
    fun bind(point: TopScores) {
        itemView.tv_count.text = point.pos.toString()
        itemView.tv_lastName.text = point.player?.player_name
        itemView.tv_count_home.text = point.goals?.home.toString()
        itemView.tv_count_away.text = point.goals?.away.toString()
        itemView.tv_count_overall.text = point.goals?.overall.toString()
    }
}