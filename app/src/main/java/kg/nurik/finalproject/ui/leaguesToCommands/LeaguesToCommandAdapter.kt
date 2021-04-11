package kg.nurik.finalproject.ui.leaguesToCommands

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.model.command.FavouriteCommands
import kotlinx.android.synthetic.main.item_news.view.*

class LeaguesToCommandAdapter(
    private val viewModel: LeaguesToCommandViewModel,
    private val listener: (item: Data?) -> Unit
) :
    RecyclerView.Adapter<ViewHolder>() {

    private val list = arrayListOf<Commands>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view, listener, viewModel)
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

class ViewHolder(
    view: View,
    private val listener: (item: Data?) -> Unit,
    private val viewModel: LeaguesToCommandViewModel
) :
    RecyclerView.ViewHolder(view) {

    fun bind(point: Commands) {
        itemView.tv_commands.text = point.name
        itemView.tv_short_code.text = point.shortCode

        if (!point.logo.isNullOrEmpty()) {
            Picasso.get()
                .load(point.logo)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(itemView.image_logo)
        }
        itemView.setOnClickListener {
            listener.invoke(point.country)
        }

        val scaleAnimation = ScaleAnimation(
            0.7f, 1.0f, 0.7f, 1.0f,
            Animation.RELATIVE_TO_SELF, 0.7f, Animation.RELATIVE_TO_SELF, 0.7f
        )
        scaleAnimation.duration = 500
        val bounceInterpolator = BounceInterpolator()
        scaleAnimation.interpolator = bounceInterpolator

        itemView.checkbox.setOnClickListener {
            point.isChecked = !point.isChecked
            viewModel.update(point)
            itemView.checkbox.startAnimation(scaleAnimation)
        }
        itemView.checkbox.isChecked = point.isChecked

    }
}