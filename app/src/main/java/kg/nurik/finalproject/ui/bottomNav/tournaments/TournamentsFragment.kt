package kg.nurik.finalproject.ui.bottomNav.tournaments

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.ViewPagerModel
import kg.nurik.finalproject.data.model.season.DataSeason
import kg.nurik.finalproject.databinding.FragmentTournamentsBinding
import kg.nurik.finalproject.ui.gamesToSeason.GamesSeasonFragment
import kg.nurik.finalproject.ui.gamesToSeason.GamesSeasonViewModel
import kg.nurik.finalproject.ui.topScorers.TopScorersFragment
import kg.nurik.finalproject.ui.topScorers.TopScoresViewModel
import kg.nurik.finalproject.utils.viewBinding
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class TournamentsFragment : Fragment(R.layout.fragment_tournaments) {

    private val binding by viewBinding(FragmentTournamentsBinding::bind)
    private var adapter: PagerAdapter? = null
    private val vmSeason by viewModel<GamesSeasonViewModel>()
    private val vmTopScores by viewModel<TopScoresViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickMenu()
        setupViewPager()
        setupViewModel()
    }

    private fun setupViewModel() {
        vmSeason.progress.observe(viewLifecycleOwner, Observer {
            binding.progressBarViewPager.isVisible = it
            binding.viewPager.isVisible = !it
        })
    }

    private fun clickMenu() {
        binding.toolbarCustom.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.one_season -> {
                    vmSeason.loadSeason(496)
                    it.isChecked = true
                    vmTopScores.loadTopScores(496)
                    true
                }
                R.id.two_season -> {
                    vmSeason.loadSeason(503)
                    it.isChecked = true
                    vmTopScores.loadTopScores(503)
                    true
                }
                R.id.three_season -> {
                    vmSeason.loadSeason(509)
                    it.isChecked = true
                    vmTopScores.loadTopScores(509)
                    true
                }
                else -> false
            }
        }
    }

    private fun setupViewPager() {
        adapter = PagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = false
        TabLayoutMediator(binding.tableLayout, binding.viewPager) { tab, pos ->
            tab.text = adapter?.getCurrentItem(pos)?.title
        }.attach()
        adapter?.update(getDataForPager())
        binding.toolbarCustom.overflowIcon =
            ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_date_range_24)
    }

    private fun getDataForPager(): ArrayList<ViewPagerModel> {
        val list = arrayListOf<ViewPagerModel>()
        list.add(ViewPagerModel(GamesSeasonFragment() {
            navigateToStats(it)
        }, "Игры по сезонам"))
        list.add(ViewPagerModel(TopScorersFragment(), "Лучшие бомбардиры"))
        return list
    }

    private fun navigateToStats(data: DataSeason) {
        val directions =
            TournamentsFragmentDirections.actionTournamentsFragmentToSeasonDetailsFragment(data)
        findNavController().navigate(directions)
    }
}