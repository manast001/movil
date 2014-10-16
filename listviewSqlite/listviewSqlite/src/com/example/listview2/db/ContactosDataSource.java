package com.example.listview2.db;

import java.util.ArrayList;
import java.util.List;

import com.example.listview2.Contacto;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactosDataSource {
	
	private static final String LOGTAG = "DB";
	SQLiteOpenHelper dbhelper; 
	SQLiteDatabase database;
	
	public ContactosDataSource(Context context){
		dbhelper = new ContactosDBOpenHelper(context);
	}
	
	public void openDB(){
		Log.i(LOGTAG, "DB open");
		database = dbhelper.getWritableDatabase();
	}

	public void closeDB(){
		Log.i(LOGTAG, "DB close");
		dbhelper.close();
	}
	
	public List<Contacto> obtenerContactos(){
		List<Contacto> contactos = new ArrayList<Contacto>();
		
		String query = "SELECT * FROM contacto";
		Cursor cursor = database.rawQuery(query, null);
		
		if (cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				Contacto contacto = new Contacto();
				contacto.setId(cursor.getLong(cursor.getColumnIndex("id")));
				contacto.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
				contacto.setApellido(cursor.getString(cursor.getColumnIndex("apellido")));
				contacto.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
				contacto.setFoto(cursor.getString(cursor.getColumnIndex("foto")));	
				contactos.add(contacto);
			}
			
		}
		return contactos;
		
	}

}
