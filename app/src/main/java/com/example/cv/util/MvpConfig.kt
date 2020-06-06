package com.example.cv.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.cv.ui.CvPresenter
import com.example.cv.ui.CvView
import com.example.cv.ui.imp.CvListAdapter
import com.example.cv.ui.imp.CvViewModel


fun CvPresenter.configure(lifecycle: LifecycleOwner, adapter: CvListAdapter, vm: CvViewModel, view: CvView) {

    // action flows
//    view.onShowNewGreetingButtonPressed(::onShowNewGreetingButtonPressed)

    // data flows
    vm.userCvLiveData.observe(lifecycle, Observer{data ->
        // show data
        adapter.submitList(data)
        adapter.notifyChange()
    })
}


