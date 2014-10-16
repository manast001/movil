package com.example.listview2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactosDBOpenHelper extends SQLiteOpenHelper {
	
	private static final String LOGTAG = "DB";
	private static final String DATABASE_NAME = "contacto.db";
	private static final int DATABASE_VERSION = 1;
	
	private static final String CREAR_TABLA_CONTACTO = "CREATE TABLE contacto (" +
			"id INTEGER PRIMARY KEY autoincrement, " +
			"nombre TEXT, " +
			"apellido TEXT, " +
			"telefono TEXT, " +
			"foto TEXT)";
	
	private static final String INSERTAR_CONTACTO1 = "INSERT INTO contacto " +
			"(nombre, apellido, telefono, foto) VALUES (" +
			"'Loreto','López Pino', '+56968080339', 'beagle')";
	
	private static final String INSERTAR_CONTACTO2 = "INSERT INTO contacto " +
			"(nombre, apellido, telefono, foto) VALUES (" +
			"'Juan','Perez', '+56965200339', 'akita')";
	
	private static final String INSERTAR_CONTACTO3 = "INSERT INTO contacto " +
			"(nombre, apellido, telefono, foto) VALUES (" +
			"'Pedro','Canales', '+56965200456', 'akita')";
	
	
	public ContactosDBOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREAR_TABLA_CONTACTO);
		Log.i(LOGTAG, "se creo la tabla contacto");
		
		db.execSQL(INSERTAR_CONTACTO1);
		Log.i(LOGTAG, "se insertó contacto1");
		
		db.execSQL(INSERTAR_CONTACTO2);
		Log.i(LOGTAG, "se insertó contacto2");
		
		db.execSQL(INSERTAR_CONTACTO3);
		Log.i(LOGTAG, "se insertó contacto3");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
