package kg.nurik.finalproject.ui.onBoard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kg.nurik.finalproject.R

class OneFragmentActivity : AppCompatActivity() {

    private var host: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_fragment)
        host = Navigation.findNavController(this, R.id.fragment)
    }
}