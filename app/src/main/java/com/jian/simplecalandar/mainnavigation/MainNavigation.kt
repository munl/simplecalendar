package com.jian.simplecalandar.mainnavigation

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import com.jian.simplecalandar.calendar.view.CalendarFragment

class MainNavigation(
    private val fragmentManager: FragmentManager,
    @IdRes private val containerId: Int
) {
    fun navigateToFragment(fragmentType: FragmentType, addToBackStack: Boolean? = false) {
        val fragment = when (fragmentType) {
            FragmentType.Calendar -> CalendarFragment()
        }

        fragmentManager.beginTransaction().apply {
            if(addToBackStack == true) addToBackStack(null)
            replace(containerId, fragment)
            commit()
        }

    }
}

enum class FragmentType {
    Calendar
}