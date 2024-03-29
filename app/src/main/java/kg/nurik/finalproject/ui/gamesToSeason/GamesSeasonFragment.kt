package kg.nurik.finalproject.ui.gamesToSeason

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.season.DataSeason
import kg.nurik.finalproject.databinding.FragmentGamesSeasonBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GamesSeasonFragment(private val listener: (data: DataSeason) -> Unit) :
    Fragment(R.layout.fragment_games_season) {

    private val vm by viewModel<GamesSeasonViewModel>()
    private val binding by viewBinding(FragmentGamesSeasonBinding::bind)
    private val adapter = GamesSeasonAdapter { listener.invoke(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewTournament.adapter = adapter
        setupViews()
    }

    private fun setupViews() {
        binding.progressBarTournaments.visibility = ProgressBar.VISIBLE
        vm.getAllSeason().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
        vm.progress.observe(viewLifecycleOwner, Observer {
            binding.progressBarTournaments.isVisible = it
        })
    }
}