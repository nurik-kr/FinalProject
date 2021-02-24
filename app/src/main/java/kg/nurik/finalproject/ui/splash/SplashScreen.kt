package kg.nurik.finalproject.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kg.nurik.finalproject.R
import kg.nurik.finalproject.ui.main.MainActivity
import kg.nurik.finalproject.data.local.PreferenceHelper

class SplashScreen : Fragment(R.layout.fragment_splash_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            selectFragment()
        }, 3000)
    }

    private fun selectFragment() {
        if (PreferenceHelper.getIsFirstLaunch()) {
            findNavController().navigate(R.id.action_splashScreen2_to_onBoardMainFragment)
        } else {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            activity?.onBackPressed()
        }
    }
}