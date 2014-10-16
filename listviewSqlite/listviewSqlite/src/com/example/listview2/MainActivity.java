package com.example.listview2;

import java.util.ArrayList;
import java.util.List;

import com.example.listview2.db.ContactosDataSource;
import com.example.listview2.lib.ContactoAdapter;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends ListActivity {

	List<Contacto> contactos;
	ContactosDataSource datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		datasource = new ContactosDataSource(this);
		datasource.openDB();
		contactos = datasource.obtenerContactos();

		ContactoAdapter adapter = new ContactoAdapter(this, R.layout.detallecontacto_item, contactos);
		setListAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.addcontacto:
	        	Intent ventanaAgregar=new Intent(MainActivity.this,AgregarContactoActivity.class);
	        	startActivity(ventanaAgregar);
	        	return true;
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
	protected void onResume() {
		super.onResume();
		datasource.openDB();
	}

	@Override
	protected void onPause() {
		super.onPause();
		datasource.closeDB();
	}




}
