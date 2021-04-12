package kg.nurik.finalproject.ui.bottomNav.bookmaker

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.FragmentBookmakerBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmakerFragment : Fragment(R.layout.fragment_bookmaker) {

    private val vm by viewModel<BookmakerViewModel>()
    private val binding by viewBinding(FragmentBookmakerBinding::bind)
    private val adapter by lazy { BookmakerAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewBookmaker.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewBookmaker.adapter = adapter
        setupViews()
    }

    private fun setupViews() {
        binding.progressBarBookmaker.visibility = ProgressBar.VISIBLE
        vm.getAllBookmaker().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
            binding.progressBarBookmaker.visibility = ProgressBar.INVISIBLE
        })
    }
}