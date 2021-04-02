package kg.nurik.finalproject.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTime {

    private const val US_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
    private const val OUT_DATE_FORMAT = "dd-MM-yyyy HH:mm:ss"

    private fun formatDate(format: String): SimpleDateFormat {
        val sdf = SimpleDateFormat(US_DATE_FORMAT, Locale.getDefault())
        val outSdf = SimpleDateFormat(OUT_DATE_FORMAT, Locale.getDefault())
        val date = sdf.parse("2020-09-18 18:30:00")
        date?.let { val current = outSdf.format(it) }
        return outSdf
    }
}