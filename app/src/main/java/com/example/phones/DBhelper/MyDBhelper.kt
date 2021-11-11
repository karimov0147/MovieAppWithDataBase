package com.example.phones.DBhelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.phones.models.Phone
import com.example.phones.utils.Constants

class MyDBhelper(context: Context) : SQLiteOpenHelper(context, Constants.DB_NAME , null , Constants.DB_VERSION) , DataBaseServise {
    override fun onCreate(db: SQLiteDatabase?) {
        var query = "create table ${Constants.TABLE_NAME} (${Constants.ID} integer not null primary key autoincrement unique , ${Constants.NAME} text not null , ${Constants.MODEL} text not null , ${Constants.COMMENTS} text not null) "
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists ${Constants.TABLE_NAME}")
        onCreate(db)
    }

    override fun addPhone(phone: Phone) {
        val databese = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constants.NAME , phone.name)
        contentValues.put(Constants.MODEL , phone.model)
        contentValues.put(Constants.COMMENTS , phone.comment)
        databese.insert(Constants.TABLE_NAME , null , contentValues)
        databese.close()
    }

    override fun getPhonesByModel() : ArrayList<Phone> {
        val phoneList = ArrayList<Phone>()
        val query = "select * from ${Constants.TABLE_NAME}"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query,null)
        if (cursor.moveToFirst()){
                do {
                    var id = cursor.getInt(0)
                    var name = cursor.getString(1)
                    var model = cursor.getString(2)
                    var comment = cursor.getString(3)
                    var phoneObject = Phone(id , name , model , comment)
                     phoneList.add(phoneObject)
                }while (cursor.moveToNext())
        }
            return phoneList
    }
}