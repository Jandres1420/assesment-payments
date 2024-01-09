package com.pico.mvvm.credibanco.domain.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyOpenHelper constructor(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "credibanco.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("CREATE TABLE IF NOT EXISTS payment (_id TEXT PRIMARY KEY, amount TEXT, receiptId TEXT," +
                     "rrn TEXT, statusDescription TEXT, statusCode TEXT)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}