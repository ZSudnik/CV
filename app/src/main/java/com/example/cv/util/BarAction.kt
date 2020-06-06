package com.example.cv.util


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatDelegate
import android.view.WindowManager
import android.app.Activity
import android.content.Context


fun createPart(resLayoutCustom: Int, activity: Activity, delegate: AppCompatDelegate):View{
    var customActionBarView: View
    val inflater = LayoutInflater.from( activity)
    customActionBarView = inflater!!.inflate(resLayoutCustom, null)
    // Show the custom action bar view and hide the normal Home icon and title.
    val actionBar = delegate.supportActionBar
    actionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM,
            ActionBar.DISPLAY_SHOW_CUSTOM or ActionBar.DISPLAY_SHOW_HOME)//DISPLAY_SHOW_TITLE
    actionBar?.setCustomView(customActionBarView,
            ActionBar.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT))

//    actionBar?.setElevation(4f)
//    val styledAttributes = context.theme.obtainStyledAttributes(
//            intArrayOf(android.R.attr.actionBarSize))
//    val heightActionBar = styledAttributes.getDimension(0, 0f).toInt()
//        }

//        alarmIcon = customActionBarView.findViewById(R.id.alarm_icon)
//        alarmIcon.setOnClickListener(View.OnClickListener {
//            popupWindow = popupDisplay()  // initialize in onCreate()
//            refreshPopUpWindows()
//        })
//        alarmIconColor = customActionBarView.findViewById(R.id.alarm_icon_color)

    val window = activity.getWindow()

// clear FLAG_TRANSLUCENT_STATUS flag:
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

    return customActionBarView
}

