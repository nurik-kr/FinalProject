package kg.nurik.finalproject.ui.bottomNav.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {

    private val list = arrayListOf<Fragment>()

    fun addFragment(fragment: Fragment){
        list.add(fragment)
        notifyDataSetChanged()
    }

    override fun getItem(position: Int) = list[position]

    override fun getCount() = list.size
}