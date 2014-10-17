package com.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
	
	private static final String LOGTAG="DB";
	private static final String DATABASE_NAME="contact.db";
	private static final int DATABASE_VERSION=1;
	
	private static final String CREATE_CONTACT_TABLE="CREATE TABLE contact(contact_id INTEGER PRIMARY KEY autoincrement,name TEXT, lastname TEXT ,phone TEXT,photo TEXT);";
	
	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_CONTACT_TABLE);
		Log.i(LOGTAG,"Se creo la wea");

	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
