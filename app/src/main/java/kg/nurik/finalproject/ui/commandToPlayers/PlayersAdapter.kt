package kg.nurik.finalproject.ui.commandToPlayers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.players.Players
import kotlinx.android.synthetic.main.item_news.view.*

class PlayersAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val list = arrayListOf<Players>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
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
        itemView.tv_commands.text = point?.firstname
        itemView.tv_short_code.text = point?.lastname
//        Picasso.get().load(point?.img).into(itemView.image_logo)
    }
}