package com.example.listview2;

import java.util.ArrayList;
import java.util.List;

import com.example.listview2.db.ContactosDataSource;
import com.example.listview2.lib.ContactoAdapter;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	List<Contacto> contactos;
	ContactosDataSource datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		contactos = new ArrayList<Contacto>();
		
//		Contacto contacto1 = new Contacto();
//		contacto1.setNombre("Loreto");
//		contacto1.setApellido("López");
//		contacto1.setTelefono("+56978090339");
//		contacto1.setFoto("beagle");
//		contactos.add(contacto1);
//		
//		Contacto contacto2 = new Contacto();
//		contacto2.setNombre("Pedro");
//		contacto2.setApellido("Perez");
//		contacto2.setTelefono("+56978090229");
//		contacto2.setFoto("akita");
//		contactos.add(contacto2);
//		
//		Contacto contacto3 = new Contacto();
//		contacto3.setNombre("Pablo");
//		contacto3.setApellido("Perez");
//		contacto3.setTelefono("+56978045339");
//		contacto3.setFoto("beagle");
//		contactos.add(contacto3);
		
		datasource = new ContactosDataSource(this);
		datasource.openDB();
		contactos = datasource.obtenerContactos();
		
		
		//ArrayAdapter<Contacto> adapter = new ArrayAdapter<Contacto>(this, android.R.layout.simple_list_item_1, contactos);
//		setListAdapter(adapter);
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
