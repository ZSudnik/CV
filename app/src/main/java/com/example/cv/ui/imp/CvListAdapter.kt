package com.example.cv.ui.imp

import android.app.Activity
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cv.R
import com.example.cv.db.RoomDB
import com.example.cv.db.entity.UserEnt
import com.example.cv.ui.ShowFull
import kotlinx.android.synthetic.main.layout_full_cv.view.*


class CvListAdapter( val activity: Activity, val showFull: ShowFull ):
    PagedListAdapter<UserEnt, CvListAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val defList = getItem(position)

            // we need to check if the item is null, because the tem can be null
            when(defList != null){
                true -> holder.bind( defList,  activity, showFull)
                false -> holder.bind( UserEnt(),  activity, showFull)
            }
    }

    fun notifyChange(){
        notifyDataSetChanged()
    }


 class MyViewHolder
    private constructor(itemView: View, var popupView: View): RecyclerView.ViewHolder( itemView) {

        val iconTreeDot: ImageView = itemView.findViewById(R.id.icon_treedot)
        val txtNema: TextView = itemView.findViewById(R.id.txt_name)
        val txtSurname: TextView = itemView.findViewById(R.id.txt_surname)
        val picture: ImageView = itemView.findViewById(R.id.picture)


     fun bind(item: UserEnt, app: Activity, showFull: ShowFull ) {
            with(itemView) {
                txtNema.text = item.mName
                txtSurname.text = item.mSurname
                if( item.mPicture != null ) {
                    val bitmap =
                        BitmapFactory.decodeByteArray(item.mPicture, 0, item.mPicture!!.size)
                    picture.setImageBitmap(bitmap)
                }


                iconTreeDot.setOnClickListener(View.OnClickListener {
                    var popUp: PopupWindow = PopupWindow()
                    popUp.setFocusable(true)
                    popUp.setOutsideTouchable(true)
                    popUp.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT)//2* screenWidth /3);
                    popUp.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                    popupView.layoutParams = ViewGroup.LayoutParams(260, ViewGroup.LayoutParams.WRAP_CONTENT)
                    popUp.setContentView(popupView)
                    val offx = itemView.width - 255
                    popUp.showAsDropDown(itemView, offx, -itemView.height + 5)
                    val txtRename: TextView = popupView.findViewById(R.id.update)
                    val txtDelete: TextView = popupView.findViewById(R.id.delete)
                    txtRename.setOnClickListener(View.OnClickListener {
//                        NameListDialog(itemView.context).updateName(
//                                R.layout.def_new_dialog, item)
                        if (popUp.isShowing) popUp.dismiss()
                    })
                    txtDelete.setOnClickListener(View.OnClickListener {
                        RoomDB.getAppDatabase( app)?.userDAO()?.delete(item)
                        if (popUp.isShowing) popUp.dismiss()
                    })
                })
                itemView.setOnClickListener(View.OnClickListener {
                    showFull.showFull(item)
                })
            }
        }


        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                        .inflate(R.layout.one_title_cv, parent, false)
                var popupView = layoutInflater
                        .inflate(R.layout.popup_view, parent, false)
                return MyViewHolder(view, popupView)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<UserEnt>(){

            override fun areItemsTheSame(oldItem: UserEnt, newItem: UserEnt): Boolean =
                    (oldItem._id == newItem._id  )

            override fun areContentsTheSame(oldItem: UserEnt,   newItem: UserEnt): Boolean =
                    (oldItem.mName.equals( newItem.mName, true) &&
                            oldItem.mSurname.equals( newItem.mSurname, true) )
        }
    }


}

