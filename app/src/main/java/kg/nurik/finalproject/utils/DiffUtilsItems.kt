package kg.nurik.finalproject.utils

import androidx.recyclerview.widget.DiffUtil
import kg.nurik.finalproject.data.model.onBoard.RowsModel

object DiffUtilsItems {

    val diffUtilItems = object : DiffUtil.ItemCallback<RowsModel>() {
        override fun areItemsTheSame(oldItem: RowsModel, newItem: RowsModel): Boolean {
            return oldItem.comments_count == newItem.comments_count
                    && oldItem.content == newItem.content
                    && oldItem.created_at == newItem.created_at
                    && oldItem.description == newItem.description
                    && oldItem.document == newItem.document
                    && oldItem.id == newItem.id
                    && oldItem.email == newItem.email
                    && oldItem.status_code == newItem.status_code
                    && oldItem.material_type == newItem.material_type
                    && oldItem.preview == newItem.preview
                    && oldItem.rank == newItem.rank
                    && oldItem.title == newItem.title
                    && oldItem.categories == newItem.categories

        }

        override fun areContentsTheSame(oldItem: RowsModel, newItem: RowsModel): Boolean {
            return oldItem == newItem
        }
    }
}