package kg.nurik.finalproject.ui.countryLeagues

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.leagues.Leagues
import kg.nurik.finalproject.databinding.FragmentCountryLeaguesBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountryLeaguesFragment : Fragment(R.layout.fragment_country_leagues) {

    private val args: CountryLeaguesFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentCountryLeaguesBinding::bind)
    private val vm by viewModel<CountryLeaguesViewModel>()
    private val adapter by lazy {
        DetailsLeaguesAdapter {
            navigateLeaguesToCommands(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewLigaCountry.adapter = adapter
        setupViews()
        setupViewModel()
        setupListener()
    }

    private fun setupViewModel() {
        vm.dataLeagues.observe(viewLifecycleOwner, Observer {
            adapter.update(it.data)
        })
    }

    private fun setupViews() {
        val categoryId = args.leagues
        categoryId.let {
            vm.loadLeagues(it)
            Log.d("asdasdas", "asdasdassd")
        }
    }

    private fun setupListener() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun navigateLeaguesToCommands(data: Leagues?) {
        val direction =
            data?.countryId?.let {
                CountryLeaguesFragmentDirections.actionCountryLeaguesFragmentToLeaguesToCommandsFragment(
                    it
                )
            }
        direction?.let { findNavController().navigate(it) }
    }
}