package kg.nurik.finalproject.ui.bottomNav.allGames

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.databinding.FragmentAllGamesBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        val actionSearch: MenuItem = menu.findItem(R.id.menu_action_search)

        val searchViewEditText: SearchView = actionSearch.actionView as SearchView

        searchViewEditText.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(requireContext(),query,Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Toast.makeText(requireContext(),newText,Toast.LENGTH_SHORT).show()
                return false
            }
        })
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

    private fun navigateToDetails(data: Data) {
        val direction =
            data.continent?.let {
                AllGamesFragmentDirections.actionNavigationAllGamesToCountryDetailsFragment2(it)
            }
        findNavController().navigate(direction!!)
    }
}