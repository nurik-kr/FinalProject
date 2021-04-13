package kg.nurik.finalproject.ui.bottomNav.allGames

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.databinding.FragmentAllGamesBinding
import kg.nurik.finalproject.utils.ConnectionUtils
import kg.nurik.finalproject.utils.viewBinding
import kotlinx.android.synthetic.main.fragment_all_games.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllGamesFragment : Fragment(R.layout.fragment_all_games) {

    private val vm by viewModel<AllGamesViewModel>()
    private val binding by viewBinding(FragmentAllGamesBinding::bind)

    private val adapter = AllCountryAdapter() {
        navigateToDetails(it)
    }
    private val adapterFavourite = AllCountryAdapter() {
        navigateToDetails(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewOthers.adapter = adapter
        binding.RecyclerviewFavourite.adapter = adapterFavourite
        checkIsInternet()
        setupViews()
        clickListenersMenu()
    }

    private fun checkIsInternet() {
        val isHasNetwork = ConnectionUtils.isNetworkAvailable(requireContext())
        if (!isHasNetwork) {
            val snack = Snackbar.make(parentLayout, "Проверьте наличие интернета",
                Snackbar.LENGTH_INDEFINITE
            )
                .setAction("Обновить") {
                    if (!ConnectionUtils.isNetworkAvailable(requireContext()))
                        checkIsInternet()
                }
            snack.setTextColor(Color.parseColor("#FF000000"))
            snack.setActionTextColor(Color.parseColor("#FF000000"))
            snack.show()
        }
    }

    private fun clickListenersMenu() {
        binding.menuSearch.setOnClickListener {
            findNavController()
                .navigate(R.id.action_navigation_all_games_to_searchFragment)
        }
    }

    private fun setupViews() {
        binding.progressBarAllGames.visibility = ProgressBar.VISIBLE
        vm.getAllGames().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
            binding.progressBarAllGames.visibility = ProgressBar.INVISIBLE
            vm.getFavouriteFiveContinent(it)
        })
        vm.data.observe(viewLifecycleOwner, Observer {
            adapterFavourite.update(it)
        })
    }

    private fun navigateToDetails(data: Data) {
        val direction =
            data.continent?.let {
                AllGamesFragmentDirections.actionNavigationAllGamesToCountryDetailsFragment2(it)
            }
        findNavController().navigate(direction!!)
    }
}