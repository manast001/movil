package com.example.listview2;

import java.util.ArrayList;
import java.util.List;

import com.example.db.ContactDataSource;
import com.example.listview2.lib.ContactoAdapter;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Build;

public class MainActivity extends ListActivity {
	private ContactDataSource data;
	List<Contacto> contactos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.data=new ContactDataSource(this);
		this.data.openDB();
								
		contactos = this.data.getAllContacts();
		ContactoAdapter adapter = new ContactoAdapter(this, R.layout.detallecontacto_item, contactos);
		setListAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.addContact) {
			Intent addContactView=new Intent(MainActivity.this,AddContactActivity.class);
			startActivity(addContactView);
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		Contacto contacto = contactos.get(position);
		
		Intent intent = new Intent(this, DetalleActivity.class);
		intent.putExtra("nombre", contacto.getNombre());
		intent.putExtra("apellido", contacto.getApellido());
		intent.putExtra("telefono", contacto.getTelefono());
		intent.putExtra("foto", contacto.getFoto());
		
		startActivity(intent);
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		this.data.openDB();
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		this.data.closeDB();
	}
}
