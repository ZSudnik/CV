package com.example.cv.ui.imp

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cv.R
import com.example.cv.ui.CvView
import kotlinx.android.synthetic.main.layout_full_cv.*
import kotlinx.android.synthetic.main.layout_show_cv.*
import kotlinx.android.synthetic.main.layout_start.*


class CvViewImpl(val activity: AppCompatActivity, val adapter: CvListAdapter) : CvView {

    private var recyclerView: RecyclerView = activity.findViewById(R.id.recycle_view)


    override fun updateRecycleView() {
        recyclerView.adapter = adapter
    }

    override fun showListCv() {
        activity.start_layout.visibility = View.GONE
        activity.show_cv_layout.visibility = View.VISIBLE
        activity.full_cv_layout.visibility = View.GONE
    }


}
