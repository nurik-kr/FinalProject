package kg.nurik.finalproject.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTime {

    private const val US_DATE_FORMAT = "yyyy-MM-dd"

    fun datePickerTo(year: Int, monthOfYear: Int, dayOfMonth: Int): String {
        var cal = Calendar.getInstance()

        cal.set(Calendar.YEAR, year)
        cal.set(Calendar.MONTH, monthOfYear)
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        return formatDate(US_DATE_FORMAT, cal.time)
    }

    private fun formatDate(format: String, date: Date): String {
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        return sdf.format(date)
    }

}