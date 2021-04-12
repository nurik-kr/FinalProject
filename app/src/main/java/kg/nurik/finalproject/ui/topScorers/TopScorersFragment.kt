package kg.nurik.finalproject.ui.topScorers

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.FragmentGamesSeasonBinding
import kg.nurik.finalproject.databinding.FragmentTopScorersBinding
import kg.nurik.finalproject.ui.gamesToSeason.GamesSeasonAdapter
import kg.nurik.finalproject.ui.gamesToSeason.GamesSeasonViewModel
import kg.nurik.finalproject.utils.viewBinding
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopScorersFragment : Fragment(R.layout.fragment_top_scorers) {

    private val vm by viewModel<TopScoresViewModel>()
    private val binding by viewBinding(FragmentTopScorersBinding::bind)
    private val adapter by lazy { TopScoresAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewTopScores.adapter = adapter
        setupViews()
    }

    private fun setupViews() {
        binding.progressBarTopScores.visibility = ProgressBar.VISIBLE
        vm.getTopScores().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
        vm.progress.observe(viewLifecycleOwner, Observer {
            binding.progressBarTopScores.isVisible = it
        })
    }

}