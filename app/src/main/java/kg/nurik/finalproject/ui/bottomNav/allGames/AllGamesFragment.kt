package kg.nurik.finalproject.ui.bottomNav.allGames

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kg.nurik.finalproject.R
import kg.nurik.finalproject.databinding.FragmentAllGamesBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllGamesFragment : Fragment(R.layout.fragment_all_games) {

    private val vm by viewModel<AllGamesViewModel>()
    private val adapter = AllCountryAdapter()
    private val binding by viewBinding(FragmentAllGamesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewOthers.adapter = adapter
        setupViews()
    }

    private fun setupViews() {
        vm.dataCategories.observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
    }


}