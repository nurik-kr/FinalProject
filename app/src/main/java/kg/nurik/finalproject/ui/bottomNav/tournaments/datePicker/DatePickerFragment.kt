package kg.nurik.finalproject.ui.bottomNav.tournaments.datePicker

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

class DatePickerFragment : Fragment() {

    private var cal = Calendar.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setonCLick()
    }

    private fun setonCLick() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }

//        button.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
//        }

    }

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
//        text_view!!.text = sdf.format(cal.time)
    }
}