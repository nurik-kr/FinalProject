package kg.nurik.finalproject.ui.bottomNav.allGames

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.databinding.FragmentAllGamesBinding
import kg.nurik.finalproject.utils.viewBinding
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllGamesFragment : Fragment(R.layout.fragment_all_games) {

    private val vm by viewModel<AllGamesViewModel>()
    private val binding by viewBinding(FragmentAllGamesBinding::bind)

    private val adapter = AllCountryAdapter() {
        navigateToDetails(it)
    }
    private val adapterFavourite = AllCountryAdapter(){
//        navigateToDetails(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewOthers.adapter = adapter
        binding.RecyclerviewFavourite.adapter = adapterFavourite
        setupViews()
    }

    private fun setupViews() {
        binding.progressBarProchie.visibility = ProgressBar.VISIBLE
        vm.getAllGames().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
            binding.progressBarProchie.visibility = ProgressBar.INVISIBLE
            vm.getFavouriteFiveContinent(it)
//            val size = it.size
//            tv_count?.text = size.toString()
        })

        vm.data.observe(viewLifecycleOwner, Observer {
            adapterFavourite.update(it)
        })
    }


    private fun navigateToDetails(data: Data) {
        val direction =
            data?.continent?.let {
                AllGamesFragmentDirections
                    .actionNavigationAllGamesToCountryDetailsFragment2(it)
            } //тут передаем значение
        findNavController().navigate(direction!!)
    }


}