package kg.nurik.finalproject.ui.bottomNav.tournaments

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.ViewPagerModel
import kg.nurik.finalproject.databinding.FragmentTournamentsBinding
import kg.nurik.finalproject.ui.gamesToSeason.GamesSeasonFragment
import kg.nurik.finalproject.ui.topScorers.TopScorersFragment
import kg.nurik.finalproject.utils.viewBinding

class TournamentsFragment : Fragment(R.layout.fragment_tournaments) {

    private val binding by viewBinding(FragmentTournamentsBinding::bind)
    private var adapter: PagerAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
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
        list.add(ViewPagerModel(GamesSeasonFragment(), "Игры по сезонам"))
        list.add(ViewPagerModel(TopScorersFragment(), "Лучшие бомбардиры"))
        return list
    }
}