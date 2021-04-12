package kg.nurik.finalproject.ui.bottomNav.myCommands

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.databinding.FragmentLeaguesToCommandsBinding
import kg.nurik.finalproject.databinding.FragmentMyCommandsBinding
import kg.nurik.finalproject.ui.leaguesToCommands.LeaguesToCommandAdapter
import kg.nurik.finalproject.ui.leaguesToCommands.LeaguesToCommandViewModel
import kg.nurik.finalproject.ui.leaguesToCommands.LeaguesToCommandsFragmentDirections
import kg.nurik.finalproject.utils.ConnectionUtils
import kg.nurik.finalproject.utils.viewBinding
import kotlinx.android.synthetic.main.fragment_all_games.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyCommandsFragment : Fragment(R.layout.fragment_my_commands) {

    private val binding by viewBinding(FragmentMyCommandsBinding::bind)
    private val vm by viewModel<MyCommandsViewModel>()
    private val adapter by lazy {
        MyCommandsAdapter(vm) {
            navigateCommandsToPlayers(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerviewMyCommands.adapter = adapter
        setupViewModel()
    }

    private fun setupViewModel() {
        binding.progressBarMyCommands.visibility = ProgressBar.VISIBLE
        vm.getAllFavouriteCommands().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
            binding.emptyView.isVisible = it.isEmpty()
            binding.progressBarMyCommands.visibility = ProgressBar.INVISIBLE
        })
    }

    private fun navigateCommandsToPlayers(data: Data?) {
        val direction =
            data?.let {
                MyCommandsFragmentDirections.actionNavigationMyCommandsToPlayersFragment2(it)
            }
        direction?.let { findNavController().navigate(it) }
    }
}