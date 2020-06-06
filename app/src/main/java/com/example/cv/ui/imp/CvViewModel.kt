package com.example.cv.ui.imp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.cv.db.RoomDB
import com.example.cv.db.entity.UserEnt
import com.example.cv.ui.CvModel

class CvViewModel(app: Application): AndroidViewModel(app), CvModel {

    private val database = RoomDB.getAppDatabase( app)
    private val userCV = database?.userDAO()


    val userCvLiveData: LiveData<PagedList<UserEnt>> =
            LivePagedListBuilder(userCV!!.allList(), 10)
                    .setBoundaryCallback(object: PagedList.BoundaryCallback<UserEnt>(){
                        override fun onItemAtEndLoaded(itemAtEnd: UserEnt) {
                            System.out.println("onItemAtEndLoaded UserEnt")
//TODO
                        }

                        override fun onZeroItemsLoaded() {
                            System.out.println("onZeroItemsLoaded UserEnt")
                        }

                        override fun onItemAtFrontLoaded(itemAtFront: UserEnt) {
                            System.out.println("onItemAtFrontLoaded UserEnt")
//TODO
                        }
                    })
                    .build()

    companion object {
        private const val TAG = "ListViewModel"
    }

    override fun loadCV() {

    }
}