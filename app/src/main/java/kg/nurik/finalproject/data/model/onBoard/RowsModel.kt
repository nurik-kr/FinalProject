package kg.nurik.finalproject.data.model.onBoard

import android.os.Parcelable
import kg.nurik.finalproject.data.model.onBoard.CategoriesModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RowsModel(
    val comments_count: Int,
    val content: String,
    val created_at: String,
    val description: String,
    val document: String,
    val icon: String?,
    val duration: String,
    val id: Int,
    val email: String,
    val status_code: String,
    val material_type: String,
    val preview: String,
    val rank: Int,
    val title: String,
    val categories_list: String,
    val categories: List<CategoriesModel>,
    val updated_at: String
) : Parcelable