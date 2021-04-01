package kg.nurik.finalproject.ui.commandToPlayers

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.FragmentPlayersBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayersFragment : Fragment(R.layout.fragment_players) {

    private val args: PlayersFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentPlayersBinding::bind)
    private val vm by viewModel<PlayersViewModel>()
    private val adapter by lazy { PlayersAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewPlayers.adapter = adapter
        setupViewModel()
        setupViews()
        setupListener()
    }

    private fun setupViewModel() {
        vm.getAllPlayers().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
    }

    private fun setupViews() {
        val countryId = args.countryId.countryId
        countryId.let { vm.loadPlayers(it) }
        Log.d("Error", "message")
    }

    private fun setupListener() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}