package com.augusto.bigball.presentation.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.augusto.bigball.presentation.extensions.toast
//import kotlinx.android.synthetic.main.toolbar.*
//import kotlinx.android.synthetic.main.toolbar.view.*

open class BaseFragment(@LayoutRes val layoutFragment: Int): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutFragment, container, false)
    }
    
    fun observerBaseViewModel(baseViewModel: BaseViewModel) {
        baseViewModel.error.observe(this, {
            if (it != null) {
                toast(it.error.message)
                baseViewModel.error.value = null
            }
        })
    }

    fun initToolbar(@StringRes title: Int) {
//        activity?.setActionBar(toolbar)
//        toolbar.toolbar_title.setText(title)
//        toolbar.toolbar_back.setOnClickListener {
//            activity?.onBackPressed()
//        }
    }
}