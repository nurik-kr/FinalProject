package kg.nurik.finalproject.ui.bottomNav.allGames

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.databinding.FragmentAllGamesBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class AllGamesFragment : Fragment(R.layout.fragment_all_games) {

    private val vm by viewModel<AllGamesViewModel>()
    private val binding by viewBinding(FragmentAllGamesBinding::bind)

    private val adapter = AllCountryAdapter() {
        navigateToDetails(it)
    }
    private val adapterFavourite = AllCountryAdapter() {
        navigateToDetails(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewOthers.adapter = adapter
        binding.RecyclerviewFavourite.adapter = adapterFavourite
        setupViews()
    }

    private fun setupViews() {
        binding.progressBarAllGames.visibility = ProgressBar.VISIBLE
        vm.getAllGames().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
            binding.progressBarAllGames.visibility = ProgressBar.INVISIBLE
            vm.getFavouriteFiveContinent(it)
        })

        vm.data.observe(viewLifecycleOwner, Observer {
            adapterFavourite.update(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        val actionSearch = menu.findItem(R.id.menu_action_search)
        actionSearch.actionView.findNavController()
    }

    private fun navigateToDetails(data: Data) {
        val direction =
            data.continent?.let {
                AllGamesFragmentDirections.actionNavigationAllGamesToCountryDetailsFragment2(it)
            }
        findNavController().navigate(direction!!)
    }
}