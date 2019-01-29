package com.tanveershafeeprottoy.keyframeanimationdemo

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {
    private var detailShown = false
    private lateinit var constraintSet: ConstraintSet
    private lateinit var parentConstraintLayout: ConstraintLayout
    private lateinit var imgViewMain: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        parentConstraintLayout = root.findViewById(R.id.parentLayout)
        imgViewMain = root.findViewById(R.id.fragmentMainImgView)
        imgViewMain.setOnClickListener(imgOcl)
        return root
    }

    private fun showDetail() {
        detailShown = true
        constraintSet = ConstraintSet()
        constraintSet.clone(activity, R.layout.fragment_main_detail)
        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200
        TransitionManager.beginDelayedTransition(parentConstraintLayout, transition)
        constraintSet.applyTo(parentConstraintLayout)
    }

    private fun hideDetail() {
        detailShown = false
        val constraintSet = ConstraintSet()
        constraintSet.clone(context, R.layout.fragment_main)
        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200
        TransitionManager.beginDelayedTransition(parentConstraintLayout, transition)
        constraintSet.applyTo(parentConstraintLayout)
    }

    private val imgOcl = View.OnClickListener {
        if(detailShown) {
            hideDetail()
        }
        else {
            showDetail()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
