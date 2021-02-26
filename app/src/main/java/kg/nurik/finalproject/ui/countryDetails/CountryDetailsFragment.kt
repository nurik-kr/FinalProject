package kg.nurik.finalproject.ui.countryDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.FragmentCountryDetailsBinding
import kg.nurik.finalproject.utils.viewBinding

class CountryDetailsFragment : Fragment(R.layout.fragment_country_details) {

    private val args: CountryDetailsFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentCountryDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        vm.load(args.countryName)
    }
}