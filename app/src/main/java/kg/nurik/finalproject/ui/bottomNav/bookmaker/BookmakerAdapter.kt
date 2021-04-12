package kg.nurik.finalproject.ui.bottomNav.bookmaker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.bookmaker.Bookmaker
import kotlinx.android.synthetic.main.item_bookmaker.view.*

class BookmakerAdapter() : RecyclerView.Adapter<ViewHolder>() {

    val list = arrayListOf<Bookmaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_bookmaker, parent, false)
        return ViewHolder(view)
    }

    fun update(list: List<Bookmaker>?) {
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
    fun bind(point: Bookmaker?) {
        itemView.tv_book_name.text = point?.name

        if (!point?.img.isNullOrEmpty()) {
            Picasso.get()
                .load(point?.img)
                .placeholder(R.drawable.placeholder_bookmaker)
                .error(R.drawable.placeholder_bookmaker)
                .into(itemView.im_bookmaker)
        }
    }
}