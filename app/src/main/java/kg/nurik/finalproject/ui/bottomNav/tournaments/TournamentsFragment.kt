package kg.nurik.finalproject.ui.bottomNav.tournaments

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.season.DataSeason
import kg.nurik.finalproject.databinding.FragmentTournamentsBinding
import kg.nurik.finalproject.ui.bottomNav.tournaments.datePicker.DatePickerFragment
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TournamentsFragment : Fragment(R.layout.fragment_tournaments) {

    private val vm by viewModel<TournamentsViewModel>()
    private val binding by viewBinding(FragmentTournamentsBinding::bind)
    private val adapter = TournamentsAdapter { navigateToStats(it) }
//    private val calendar = DatePickerFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewTournament.adapter = adapter
        setupViews()
    }

    private fun setupViews() {
        binding.progressBarTournaments.visibility = ProgressBar.VISIBLE
        vm.getAllSeason().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
            binding.progressBarTournaments.visibility = ProgressBar.INVISIBLE
        })
    }

    private fun navigateToStats(data: DataSeason) {
        val directions =
            TournamentsFragmentDirections.actionNavigationTournamentsToSeasonDetailsFragment(data)
        findNavController().navigate(directions)
    }
}