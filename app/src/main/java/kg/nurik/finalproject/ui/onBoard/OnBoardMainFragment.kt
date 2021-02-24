package kg.nurik.finalproject.ui.onBoard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.onBoard.OnBoardModel
import kg.nurik.finalproject.data.local.PreferenceHelper
import kotlinx.android.synthetic.main.activity_on_board.*

class OnBoardMainFragment : Fragment(R.layout.activity_on_board) {

    private val list = arrayListOf<Fragment>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        setupListeners()
    }

    private fun setupListeners() {
        onBoardViewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (isLastPage(position)) {
                    tvNext.text = getString(R.string.start)
                } else {
                    tvNext.text = getString(R.string.proceed)
                }
            }
        })

        tvNext.setOnClickListener {
            if (isLastPage(onBoardViewPager.currentItem)) {
                PreferenceHelper.setIsFirstLaunch()
                findNavController().navigate(R.id.action_onBoardMainFragment_to_mainActivity)
            } else {
                onBoardViewPager.currentItem += 1
            }
        }
        tvSkip.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardMainFragment_to_mainActivity)
        }
        tvBack.setOnClickListener {
            onBoardViewPager.currentItem -= 1
        }
    }

    private fun setupViewPager() {
        val adapter = OnBoardAdapter(childFragmentManager)
        onBoardViewPager.adapter = adapter
        list.add(
            OnBoardFragment.getInstance(
                OnBoardModel(
                    getString(R.string.first_title),
                    R.drawable.ic_launcher_foreground
                )
            )
        )
        list.add(
            OnBoardFragment.getInstance(
                OnBoardModel(
                    getString(R.string.second_title),
                    R.drawable.ic_launcher_foreground
                )
            )
        )
        list.add(
            OnBoardFragment.getInstance(
                OnBoardModel(
                    getString(R.string.third_title),
                    R.drawable.ic_launcher_background
                )
            )
        )

        adapter.update(list)
        onBoardTabLayout.setupWithViewPager(onBoardViewPager)
    }
    private fun isLastPage(position: Int) = position == list.size - 1
}