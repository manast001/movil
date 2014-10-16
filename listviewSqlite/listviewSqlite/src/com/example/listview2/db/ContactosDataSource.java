package com.example.listview2.db;

import java.util.ArrayList;
import java.util.List;

import com.example.listview2.Contacto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactosDataSource {

	private static final String LOGTAG = "DB";
	private static final String TABLE_NAME="contacto";
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

	public void agregarContacto(Contacto contacto){
		ContentValues datosTabla=new ContentValues();

		datosTabla.put("nombre",contacto.getNombre());
		datosTabla.put("apellido",contacto.getApellido());
		datosTabla.put("foto",contacto.getFoto());
		datosTabla.put("telefono",contacto.getTelefono());
		this.database.insert(TABLE_NAME,null, datosTabla);

	}

}
