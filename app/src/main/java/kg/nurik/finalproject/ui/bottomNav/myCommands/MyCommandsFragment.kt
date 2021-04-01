package kg.nurik.finalproject.ui.bottomNav.myCommands

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.FragmentLeaguesToCommandsBinding
import kg.nurik.finalproject.databinding.FragmentMyCommandsBinding
import kg.nurik.finalproject.ui.leaguesToCommands.LeaguesToCommandAdapter
import kg.nurik.finalproject.ui.leaguesToCommands.LeaguesToCommandViewModel
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyCommandsFragment : Fragment(R.layout.fragment_my_commands) {

    private val binding by viewBinding(FragmentMyCommandsBinding::bind)
    private val vm by viewModel<MyCommandsViewModel>()
    private val adapter by lazy { MyCommandsAdapter(vm) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerviewMyCommands.adapter = adapter
        setupViewModel()
        setupViews()
    }

    private fun setupViewModel() {
        binding.progressBarMyCommands.visibility = ProgressBar.VISIBLE
        vm.getAllFavouriteCommands().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
            binding.progressBarMyCommands.visibility = ProgressBar.INVISIBLE
        })
    }

    private fun setupViews() {

    }

}