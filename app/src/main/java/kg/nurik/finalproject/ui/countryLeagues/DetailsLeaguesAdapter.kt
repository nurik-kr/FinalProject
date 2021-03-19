package kg.nurik.finalproject.ui.countryLeagues

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.leagues.Leagues
import kotlinx.android.synthetic.main.item_all_games.view.*

class DetailsLeaguesAdapter(private val listener: (item: Leagues) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {

    private val list = arrayListOf<Leagues>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_all_games, parent, false)
        return ViewHolder(view, listener)
    }

    fun update(list: List<Leagues>) {
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

class ViewHolder(view: View, private val listener: (item: Leagues) -> Unit) :
    RecyclerView.ViewHolder(view) {

    fun bind(point: Leagues?) {
        itemView.tv_name.text = point?.name

        itemView.setOnClickListener {
            listener.invoke(point!!)
        }
    }

}