package kg.nurik.finalproject.ui.leaguesToCommands

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.databinding.FragmentLeaguesToCommandsBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LeaguesToCommandsFragment : Fragment(R.layout.fragment_leagues_to_commands) {

    private val args: LeaguesToCommandsFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentLeaguesToCommandsBinding::bind)
    private val vm by viewModel<LeaguesToCommandViewModel>()
    private val adapter by lazy {
        LeaguesToCommandAdapter {
            navigateCommandsToPlayers(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerviewCommandToLeagues.adapter = adapter
        setupViewModel()
        setupViews()
        setupListener()
    }

    private fun setupViewModel() {
        binding.progressBarLeaguesToCommands.visibility = ProgressBar.VISIBLE
        vm.dataCommands.observe(viewLifecycleOwner, Observer {
            adapter.update(it.data)
            binding.progressBarLeaguesToCommands.visibility = ProgressBar.INVISIBLE
        })
    }

    private fun setupViews() {
        val countryId = args.leaguesToCommands
        countryId.let { vm.loadCommands(it) }
        Log.d("Error", "message")
    }

    private fun setupListener() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun navigateCommandsToPlayers(data: Data?) {
        val direction =
            data?.let {
                LeaguesToCommandsFragmentDirections.actionLeaguesToCommandsFragmentToPlayersFragment(
                    it
                )
            }
        direction?.let { findNavController().navigate(it) }
    }
}