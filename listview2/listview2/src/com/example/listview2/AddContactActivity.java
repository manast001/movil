package com.example.listview2;

import com.example.db.ContactDataSource;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.TextView;
import android.widget.Toast;

public class AddContactActivity extends Activity {
	private ContactDataSource data;
	private Integer []images=new Integer[]{R.drawable.akita,R.drawable.beagle};
	private String []photos=new String[]{"akita","beagle"};
	private GalleryAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addcontact);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		this.data=new ContactDataSource(this);
		
		Gallery gallery = (Gallery) findViewById(R.id.photoGalley);
		
		this.adapter=new GalleryAdapter(this,this.images,photos);
		
		gallery.setAdapter(this.adapter);
		
		
	}
	
	public boolean validCamps(){
		return true;
	}
	
	public void onButtonClick(View vista){
		
		this.data.openDB();
		
		EditText names=(EditText) findViewById(R.id.namesText),phone=(EditText) findViewById(R.id.phoneText); 
		Gallery gallery = (Gallery) findViewById(R.id.photoGalley); 
		
		if(names.getText().toString().isEmpty() || phone.getText().toString().isEmpty()){
			Toast toast = Toast.makeText(getApplicationContext(),"Debes Llenar todos los campos",1000);
			toast.show();
		}else{
			Contacto contacto=new Contacto();
			contacto.setNombre(names.getText().toString().substring(0,names.getText().toString().indexOf(" ")));
			contacto.setApellido(names.getText().toString().substring(names.getText().toString().indexOf(" ")+1,names.getText().toString().length()));
			contacto.setTelefono(phone.getText().toString());
			
			contacto.setFoto(this.photos[gallery.getSelectedItemPosition()]);
			
			this.data.addContact(contacto);
			
			names.setText("");
			phone.setText("");
			
		}
		
		this.data.closeDB();
		
	}

	
}
