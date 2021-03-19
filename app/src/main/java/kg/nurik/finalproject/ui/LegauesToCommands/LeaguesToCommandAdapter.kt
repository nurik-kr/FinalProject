package kg.nurik.finalproject.ui.LegauesToCommands

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.command.Commands
import kotlinx.android.synthetic.main.item_all_games.view.*
import kotlinx.android.synthetic.main.item_news.view.*

class LeaguesToCommandAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val list = arrayListOf<Commands>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    fun update(list: List<Commands>?) {
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

    fun bind(point: Commands) {
        itemView.tv_commands.text = point.name
        itemView.tv_short_code.text = point.shortCode
        Picasso.get().load(point.logo).into(itemView.image_logo)

    }
}