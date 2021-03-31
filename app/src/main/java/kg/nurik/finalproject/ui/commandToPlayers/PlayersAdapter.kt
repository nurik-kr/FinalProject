package kg.nurik.finalproject.ui.commandToPlayers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.players.Players
import kotlinx.android.synthetic.main.item_players.view.*

class PlayersAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val list = arrayListOf<Players>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_players, parent, false)
        return ViewHolder(view)
    }

    fun update(list: List<Players>?) {
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

    fun bind(point: Players?) {
        itemView.tv_firstName.text = point?.firstname
        itemView.tv_lastName.text = point?.lastname

        if (!point?.img.isNullOrEmpty()) {
            Picasso.get()
                .load(point?.img)
                .placeholder(R.drawable.logo_teams)
                .error(R.drawable.logo_teams)
                .into(itemView.image_player)
        }
    }
}