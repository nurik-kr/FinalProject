package kg.nurik.finalproject.ui.LegauesToCommands

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.FragmentLeaguesToCommandsBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.log

class LeaguesToCommandsFragment : Fragment(R.layout.fragment_leagues_to_commands) {

    private val args: LeaguesToCommandsFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentLeaguesToCommandsBinding::bind)
    private val vm by viewModel<LeaguesToCommandViewModel>()
    private val adapter by lazy { LeaguesToCommandAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerviewCommandToLeagues.adapter = adapter
        setupViewModel()
        setupViews()
        setupListener()
    }

    private fun setupViewModel() {
        vm.dataCommands.observe(viewLifecycleOwner, Observer {
            adapter.update(it.data)
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
}