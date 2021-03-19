package kg.nurik.finalproject.ui.countryDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.databinding.FragmentCountryDetailsBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountryDetailsFragment : Fragment(R.layout.fragment_country_details) {

    private val args: CountryDetailsFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentCountryDetailsBinding::bind)
    private val vm by viewModel<CountryDetailsViewModel>()
    private val adapter = DetailsCountryAdapter() {
        navigateToLeagues(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewDetailsCountry.adapter = adapter
        setupViews()
        setupViewModel()
        setupListener()
    }

    private fun setupViewModel() {
        vm.dataCountry.observe(viewLifecycleOwner, Observer {
            adapter.update(it.data)
        })
    }

    private fun setupViews() {
        val categoryId = args.collections
        categoryId.let { vm.loadCountry(it) }
    }

    private fun navigateToLeagues(data: Data) {
        val direction =
            data?.countryId?.let {
                CountryDetailsFragmentDirections.actionCountryDetailsFragment2ToCountryLeaguesFragment(
                    it
                )
            }
        findNavController().navigate(direction!!)
    }

    private fun setupListener() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
