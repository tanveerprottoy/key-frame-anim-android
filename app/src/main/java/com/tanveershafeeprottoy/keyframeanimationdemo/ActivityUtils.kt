package com.tanveershafeeprottoy.keyframeanimationdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

object ActivityUtils {
    private var fragmentTransaction: FragmentTransaction? = null

    fun addFragmentOnActivity(fragmentManager: FragmentManager?,
                              fragment: Fragment, frameId: Int) {
        fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.add(frameId, fragment)
        fragmentTransaction?.commit()
    }

    fun replaceFragmentOnActivity(fragmentManager: FragmentManager?,
                                  fragment: Fragment, frameId: Int, name: String = "") {
        fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(frameId, fragment)
        if(name != "") {
            fragmentTransaction?.addToBackStack(name)
        }
        fragmentTransaction?.commit()
    }
}