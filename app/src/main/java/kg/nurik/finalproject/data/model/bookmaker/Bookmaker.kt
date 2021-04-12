package kg.nurik.finalproject.data.model.bookmaker

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Bookmaker(
    @PrimaryKey
    var bookmaker_id: Int?,
    val name: String?,
    val img: String?
) : Parcelable