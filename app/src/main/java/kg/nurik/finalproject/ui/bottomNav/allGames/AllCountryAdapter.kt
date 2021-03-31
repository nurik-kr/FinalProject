package kg.nurik.finalproject.ui.bottomNav.allGames

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.allGames.Data
import kotlinx.android.synthetic.main.item_all_games.view.*

class AllCountryAdapter(private val listener: (item: Data) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {

    val list = arrayListOf<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_all_games, parent, false)
        return ViewHolder(view, listener)
    }

    fun update(list: List<Data>?) {
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

class ViewHolder(view: View, private val listener: (item: Data) -> Unit) :
    RecyclerView.ViewHolder(view) {

    fun bind(point: Data?) {
        itemView.tv_name.text = point?.name
//        itemView.tv_count.text =

        itemView.setOnClickListener {
            point?.let { it1 -> listener.invoke(it1) }
        }
    }
}