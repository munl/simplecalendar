package com.jian.simplecalandar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jian.simplecalandar.mainnavigation.FragmentType
import com.jian.simplecalandar.mainnavigation.MainNavigation

class MainActivity : AppCompatActivity() {

    private val mainNavigation: MainNavigation = MainNavigation(supportFragmentManager, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainNavigation.navigateToFragment(FragmentType.Calendar)
    }

}