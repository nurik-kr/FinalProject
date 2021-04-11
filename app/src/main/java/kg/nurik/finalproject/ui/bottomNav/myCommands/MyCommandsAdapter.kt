package kg.nurik.finalproject.ui.bottomNav.myCommands

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.command.FavouriteCommands
import kg.nurik.finalproject.utils.DiffUtils
import kotlinx.android.synthetic.main.item_news.view.*

class MyCommandsAdapter(
    private val viewModel: MyCommandsViewModel,
    private val listener: (item: Data?) -> Unit
) : ListAdapter<FavouriteCommands, FavouriteViewHolder>(DiffUtils.diffUtilItems) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return FavouriteViewHolder(view, viewModel, listener)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class FavouriteViewHolder(
    view: View,
    private val viewModel: MyCommandsViewModel,
    private val listener: (item: Data?) -> Unit
) :
    RecyclerView.ViewHolder(view) {

    fun bind(point: FavouriteCommands) {
        itemView.tv_commands.text = point.name
        itemView.tv_short_code.text = point.shortCode
        Picasso.get().load(point.logo).into(itemView.image_logo)

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