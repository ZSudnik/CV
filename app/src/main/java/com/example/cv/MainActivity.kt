package com.example.cv

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders.of
import com.example.cv.db.DBConstans.Companion.DATABASE_VERSION
import com.example.cv.db.DBConstans.Companion.DB_NAME
import com.example.cv.ui.CvPresenter
import com.example.cv.ui.CvView
import com.example.cv.ui.CvViewFull
import com.example.cv.ui.imp.CvListAdapter
import com.example.cv.ui.imp.CvViewFullImpl
import com.example.cv.ui.imp.CvViewImpl
import com.example.cv.ui.imp.CvViewModel
import com.example.cv.util.configure
import kotlinx.android.synthetic.main.layout_start.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var view: CvView
    private lateinit var viewFull: CvViewFull
    private lateinit var presenter: CvPresenter
    private lateinit var model: CvViewModel
    private lateinit var adapter: CvListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DB
        checkDB_andGoToNext()


        model = of(this).get(CvViewModel::class.java)
        presenter = CvPresenter(model)
        adapter = CvListAdapter( this, presenter)
        view = CvViewImpl(this, adapter)
        viewFull = CvViewFullImpl(this, presenter)
        presenter.setViews(view, viewFull)

        presenter.configure(this, adapter, model, view)
        presenter.onCreated(savedInstanceState == null)
//        hideToolBar( this)
        button_add_cv.setOnClickListener( this)
        button_show_cv.setOnClickListener( this)

    }


    override fun onClick(v: View?) {
        when( v?.id){
            button_add_cv.id->{
                Toast.makeText( this, resources.getString(R.string.str_under_const),Toast.LENGTH_LONG).show()
            }
            button_show_cv.id ->{
                presenter.onLoaded()
            }
        }
    }



    ////////// DataBase
    private fun checkDB_andGoToNext() {
        ////////// copy DB
        val mContext: Context = this.applicationContext
        val fileLoc = mContext.applicationInfo.dataDir + File.separator + "databases" + File.separator

        val dbPath = fileLoc + DB_NAME
        val dbFile = File(dbPath)
        //check if egsisting DB on pathDB if no copy
        val pathFolder = File(fileLoc)

        if (!pathFolder.isDirectory) {
            copyAll( mContext, fileLoc, DB_NAME)
        }else if (!dbFile.isFile) {
            copyAll( mContext, fileLoc, DB_NAME)
        }else{
            val sqlDB_R: SQLiteDatabase = SQLiteDatabase.openDatabase( dbPath, null, SQLiteDatabase.OPEN_READONLY);
            val oldVer_DATABASE = sqlDB_R.getVersion()
            sqlDB_R.close()
            if (oldVer_DATABASE < DATABASE_VERSION) {
                copyAll( mContext, fileLoc, DB_NAME)
            }
        }
    }

    private fun copyAll(mContext: Context, fileLoc: String, fileName: String){
        if( copyDBfromResources(mContext, fileLoc, fileName, true) ){
            // Write new ver of DB
            var sqlDB_RW: SQLiteDatabase = SQLiteDatabase.openDatabase(  fileLoc + fileName, null, SQLiteDatabase.OPEN_READWRITE);
            sqlDB_RW.setVersion(DATABASE_VERSION)
            sqlDB_RW.close()
        }

    }


    private fun copyDBfromResources(context: Context, fileLoc: String,
                                    fileName: String, overCopy: Boolean): Boolean {
        val dbPath = fileLoc + fileName
        val dbFile = File(dbPath)
        if (!overCopy && dbFile.exists()) return false

        try {
            val path = File(fileLoc)
            if (!path.isDirectory) {
                path.mkdirs()
            }
            //Open your local db as the input stream
            val input: InputStream = context.assets.open(fileName)

            dbFile.createNewFile()
            val output = FileOutputStream(dbFile)

            // transfer byte to inputfile to outputfile
            val buffer = ByteArray(1024)

            while (input.read(buffer) > 0) {
                output.write(buffer)
            }
            //Close the streams
            output.flush()
            output.close()
            input.close()
        } catch (ioe: IOException) {
            ioe.printStackTrace()
            return false
        }
        return true
    }


}