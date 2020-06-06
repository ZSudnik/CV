package com.example.cv.ui

import com.example.cv.db.entity.UserEnt

class CvPresenter(val model: CvModel): ShowFull {

    lateinit var view: CvView
    lateinit var viewFull: CvViewFull

    fun setViews(  view: CvView,  viewFull: CvViewFull){
        this.view = view
        this.viewFull = viewFull
    }
//    private val listener: ListaItemViewModel.ListaItemListener? = null

    fun onCreated(init: Boolean) {
        // If this is the first time we loaded,
        // then load the first greeting
        if (init) {
            model.loadCV()
        }
    }

    fun onLoaded() {
        view.updateRecycleView()
        view.showListCv()
    }

    fun showListCv(){
        view.showListCv()
    }

    override fun showFull( item: UserEnt){
        viewFull.showFullCv(  item)
    }

}
