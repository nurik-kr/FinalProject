package kg.nurik.finalproject.ui.commandToPlayers

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.FragmentPlayersBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayersFragment : Fragment(R.layout.fragment_players) {

    private val args: PlayersFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentPlayersBinding::bind)
    private val vm by viewModel<PlayersViewModel>()
    private val adapter by lazy { PlayersAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewPlayers.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.RecyclerviewPlayers.adapter = adapter
        setupViewModel()
        setupViews()
        setupListener()
    }

    private fun setupViewModel() {
        binding.progressBarPlayers.visibility = ProgressBar.VISIBLE
        vm.progress.observe(viewLifecycleOwner, Observer {
            binding.progressBarPlayers.isVisible = it
            binding.RecyclerviewPlayers.isVisible = !it
        })
        vm.getAllPlayers().observe(viewLifecycleOwner, Observer {
            Handler(Looper.getMainLooper()).postDelayed({
                binding.emptyView.isVisible = it.isEmpty()
            }, 500)
            adapter.update(it)
        })
    }

    private fun setupViews() {
        val countryId = args.countryId.countryId
        countryId.let { vm.loadPlayers(it) }
    }

    private fun setupListener() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}