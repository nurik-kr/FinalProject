package kg.nurik.finalproject.ui.bottomNav.viewPager

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager : ViewPager {
    private var isPageScrollEnabled = false

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return isPageScrollEnabled && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return isPageScrollEnabled && super.onInterceptTouchEvent(event)
    }

    fun setPageScrollEnabled(isPageScrollEnabled: Boolean) {
        this.isPageScrollEnabled = isPageScrollEnabled
    }
}