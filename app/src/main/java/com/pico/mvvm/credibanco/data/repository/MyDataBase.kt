package com.pico.mvvm.credibanco.data.repository

import android.annotation.SuppressLint
import android.content.ContentValues
import com.pico.mvvm.credibanco.domain.model.Payment
import com.pico.mvvm.credibanco.domain.repository.MyOpenHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyDatabase @Inject constructor(private val dbHelper: MyOpenHelper) {

    fun insertData(data: Payment) {
        val contentValues = ContentValues().apply {
            put("_id", data.id)
            put("amount", data.amount)
            put("receiptId",data.receiptId)
            put("rrn",data.rrn)
            put("statusDescription",data.statusDescription)
            put("statusCode",data.statusCode)
            // Añade más columnas según tu modelo de datos
        }

        dbHelper.writableDatabase.insert("payment", null, contentValues)
    }

    @SuppressLint("Range")
    fun getAllData(condition: String? = null): List<Payment> {
        val dataList = mutableListOf<Payment>()
        val cursor = if (condition != null) {
            dbHelper.readableDatabase.query("payment", null, condition, null, null, null, null)
        } else {
            dbHelper.readableDatabase.query("payment", null, null, null, null, null, null)
        }
        cursor.use {
            while (cursor.moveToNext()) {
                val id = cursor.getString(cursor.getColumnIndex("_id"))
                val amount = cursor.getString(cursor.getColumnIndex("amount"))
                val rrn = cursor.getString(cursor.getColumnIndex("rrn"))
                val statusCode = cursor.getString(cursor.getColumnIndex("statusCode"))
                val statusDescription = cursor.getString(cursor.getColumnIndex("statusDescription"))
                val receiptId = cursor.getString(cursor.getColumnIndex("receiptId"))

                val data = Payment(id = id, amount = amount, rrn = rrn,
                    statusCode = statusCode, statusDescription = statusDescription, receiptId = receiptId )
                dataList.add(data)
            }
        }
        return dataList
    }

    fun annulmentPayment(id: String, statusDescription: String) {
        val contentValues = ContentValues()
        contentValues.put("statusDescription", statusDescription)
        dbHelper.writableDatabase.update(
            "payment",
            contentValues,
            "_id = ?",
            arrayOf(id)
        )
    }
}