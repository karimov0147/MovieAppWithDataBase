package com.example.phones.DBhelper

import com.example.phones.models.Phone

interface DataBaseServise {
    fun addPhone (phone : Phone)
    fun getPhonesByModel() : ArrayList<Phone>
}