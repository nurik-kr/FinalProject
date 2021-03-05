package kg.nurik.finalproject.ui.bottomNav.tournaments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.FragmentTournamentsBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TournamentsFragment : Fragment(R.layout.fragment_tournaments) {

    private val vm by viewModel<TournamentsViewModel>()
    private val binding by viewBinding(FragmentTournamentsBinding::bind)
    private val adapter = TournamentsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewTournament.adapter = adapter
        setupViews()
    }

    private fun setupViews() {
        vm.getAllSeason().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
    }
}