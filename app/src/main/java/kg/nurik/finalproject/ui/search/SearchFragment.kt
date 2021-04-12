package kg.nurik.finalproject.ui.search

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.FragmentSearchBinding
import kg.nurik.finalproject.utils.viewBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val vm by viewModel<SearchViewModel>()
    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val searchAdapter by lazy { SearchAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchRecycler.adapter = searchAdapter
        setupSearch()
        setupRV()
    }

    private fun setupRV() {
        vm.search.observe(viewLifecycleOwner, Observer {
            searchAdapter.submitList(listOf(it))
        })
    }

    private fun setupSearch() {
        binding.etSearch.doAfterTextChanged {
            if (it?.isNotEmpty()!!) {
                search(it.toString())
            }
        }
    }

    private fun search(query: String) {
        lifecycleScope.launch {
            vm.startSearch(query)
//            binding?.imagemain?.visibility = View.VISIBLE
//            binding?.textNotFound?.visibility = View.VISIBLE
        }
    }
}
