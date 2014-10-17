package com.example.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.listview2.*;

public class ContactDataSource {
	private static final String LOGTAG="DB";
	private SQLiteOpenHelper dbhelper;
	private SQLiteDatabase database;
	private static final String TABLE_NAME="contact";
	private String []parameterName=new String[]{"name","lastName","photo","phone"};
	
	public ContactDataSource(Context context){
		this.dbhelper=new Database(context);
	}
	
	public void openDB()
	{
		this.database=this.dbhelper.getWritableDatabase();
		Log.i(LOGTAG,"la wea abrio");
	}
	
	public void closeDB()
	{
		this.dbhelper.close();
		Log.i(LOGTAG,"la wea cerro");
	}
	
	public void addContact(Contacto contacto)
	{
		ContentValues values=new ContentValues();
		
		values.put("name",contacto.getNombre());
		values.put("lastName",contacto.getApellido());
		values.put("photo",contacto.getFoto());
		values.put("phone",contacto.getTelefono());
		
		this.database.insert(TABLE_NAME, null, values);
	}
	
	public List<Contacto> getAllContacts(){
		List<Contacto> data=new ArrayList<Contacto>();
		Contacto contacto;
		String query="SELECT * FROM "+TABLE_NAME;
		Cursor cursor=this.database.rawQuery(query, null);
		if(cursor.getCount()>0)
		{
			while(cursor.moveToNext()){
				contacto=new Contacto();
				contacto.setId(Long.parseLong(cursor.getString(cursor.getColumnIndex("contact_id"))));
				contacto.setNombre(cursor.getString(cursor.getColumnIndex("name")));
				contacto.setApellido(cursor.getString(cursor.getColumnIndex("lastname")));
				contacto.setFoto(cursor.getString(cursor.getColumnIndex("photo")));
				contacto.setTelefono(cursor.getString(cursor.getColumnIndex("phone")));
				data.add(contacto);
			}
		}
		
		return data;
	}
	
	public void modifyContact(Contacto contacto){
		
	}
	
	public void deleteAllContacts()
	{
		String query="DELETE FROM contact";
		database.execSQL(query);
	}
	
	
}