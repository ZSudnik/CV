package com.example.cv.ui.imp

import android.graphics.BitmapFactory
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cv.R
import com.example.cv.db.RoomDB
import com.example.cv.db.entity.UserEnt
import com.example.cv.ui.CvPresenter
import com.example.cv.ui.CvViewFull
import com.example.cv.util.createPart
import kotlinx.android.synthetic.main.actionbar_setting.view.*
import kotlinx.android.synthetic.main.layout_full_cv.*
import kotlinx.android.synthetic.main.layout_show_cv.*
import kotlinx.android.synthetic.main.layout_start.*


class CvViewFullImpl(val activity: AppCompatActivity, val cvPresenter: CvPresenter) : CvViewFull {

    override fun showFullCv( item: UserEnt) {
        activity.start_layout.visibility = View.GONE
        activity.show_cv_layout.visibility = View.GONE
        activity.full_cv_layout.visibility = View.VISIBLE

        if( item.mPicture != null ) {
            val bitmap =
                BitmapFactory.decodeByteArray(item.mPicture, 0, item.mPicture!!.size)
            activity.picture_full.setImageBitmap(bitmap)
        }
        activity.txt_name_full.text = item.mName
        activity.txt_surname_full.text = item.mSurname

        val adapter = CvAdapterFull( activity.applicationContext)
        activity.recycler_viewfull.adapter = adapter
        val roomDB = RoomDB.getAppDatabase( activity)
        val listExperienceEnt = roomDB?.experienceDAO()?.getAll( item._id)
        if( listExperienceEnt != null) {
            adapter.addList(listExperienceEnt)
            adapter.notifyChange()
        }

        activity.full_cv_layout.invalidate()

        val actionBar: View = createPart(R.layout.actionbar_setting, activity,  activity.delegate)
        actionBar.return_icon.setOnClickListener(View.OnClickListener {
            cvPresenter.showListCv()
        })
    }


}
