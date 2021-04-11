package kg.nurik.finalproject.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.FragmentSearchBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val vm by viewModel<SearchViewModel>()
    private val binding by viewBinding(FragmentSearchBinding::bind)
//    private val adapter by lazy { TopScoresAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}