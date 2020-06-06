package com.example.cv.ui.experience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cv.MainActivity
import com.example.cv.R
import com.example.cv.util.ID_UserCV
import com.example.cv.util.createPart


class ShopActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
//    lateinit var adapter: ShopListAdapter
    lateinit var addHexa: View
    //
    lateinit var iconReturn: View
    lateinit var nameDeflist: TextView
    ///////////////
    private var mIdUserCV: Int = 0

    private lateinit var sumPriceWalmart: TextView
    private lateinit var sumPriceKroger: TextView
    private lateinit var sumPriceTarget: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mIdUserCV = intent.getIntExtra(ID_UserCV, 0)


        setContentView(R.layout.shop_list)
        // top bar
        val actionBar = createPart(R.layout.actionbar_setting, this, this.delegate)
        iconReturn = actionBar.findViewById(R.id.return_icon)

        iconReturn.setOnClickListener(View.OnClickListener {
            //////////////// add all chooced product to DB
//            saveDefList_manyConnProd()
            //////////////////////
            val intentDef = Intent(this.applicationContext, MainActivity::class.java)
            intentDef.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            applicationContext.startActivity(intentDef)
        })

        // Find views
        recyclerView = findViewById(R.id.list_shop)
//        adapter = ShopListAdapter(this.application, mIdUserCV, mNameDefList)
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
//
//        addHexa = findViewById(R.id.addHexaProd_Botton)
//        addHexa.setOnClickListener(View.OnClickListener {
//            //load name too hashmap
//            val shopList = RoomDB.getDatabase(this.applicationContext).shopList().getListElementAll(mIdUserCV)
//            val mpTitle = DBHelper.getInstance(this.application).mpTitle
//            for (oneShop in shopList) {
//                mpTitle.put(oneShop.mIdLevelProduct, oneShop.mNameProduct)
//            }
//            /////////////////// go to next screen
//            val intentProdHx = Intent(this, SearchProd::class.java)
//            intentProdHx.putExtra(ID_DefList, mIdUserCV)
//            intentProdHx.putExtra(Name_DefList, mNameDefList)
//            startActivity(intentProdHx)
//        })
//        saveDefList_manyConnProd()
//
//
//        val data = RoomDB.getDatabase(this).shopList().getListElements(mIdUserCV)
//        adapter.updateL(data)
//        showSumPrices(data)
    }


//    fun saveDefList_manyConnProd() {
//        val shopListDAO = RoomDB.getDatabase(this).shopList()
//        val manyBought = shopListDAO.getBought(mIdUserCV, true)
//        val manyNoBought = shopListDAO.getBought(mIdUserCV, false)
//        val defList = RoomDB.getDatabase(this).defList().findOne(mIdUserCV)
//        defList.mManyBoughtProduct = manyBought
//        defList.mManyAllProduct = manyBought + manyNoBought
//        RoomDB.getDatabase(this).defList().insertOne(defList)
//    }
//
//
//    private fun showSumPrices(productProduct: List<ShopProductEnt>) {
//        var sumWalmart: Float = 0f
//        var nonWalmart: Boolean = false
//        var sumKroger: Float = 0f
//        var nonKroger: Boolean = false
//        var sumTarget: Float = 0f
//        var nonTarget: Boolean = false
//        for (oneData in productProduct) {
//            val mnoz = oneData.mQuantity
//            if (oneData.mPrice_1 == 0.0f) nonWalmart = true
//            sumWalmart += (oneData.mPrice_1!! * mnoz!!)
//            if (oneData.mPrice_2 == 0.0f) nonKroger = true
//            sumKroger += (oneData.mPrice_2!! * mnoz!!)
//            if (oneData.mPrice_3 == 0.0f) nonTarget = true
//            sumTarget += (oneData.mPrice_3!! * mnoz!!)
//        }
//        if (nonWalmart) {
//            sumPriceWalmart?.text = "N/A"
//        } else {
//            sumPriceWalmart?.text = "%.2f".format(sumWalmart)
//        }
//        if (nonKroger) {
//            sumPriceKroger?.text = "N/A"
//        } else {
//            sumPriceKroger?.text = "%.2f".format(sumKroger)
//        }
//        if (nonTarget) {
//            sumPriceTarget?.text = "N/A"
//        } else {
//            sumPriceTarget?.text = "%.2f".format(sumTarget)
//        }
//
//    }

    override fun onStart() {
        super.onStart()
    }

}