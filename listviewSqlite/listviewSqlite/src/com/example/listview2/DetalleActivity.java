package com.example.listview2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle);
		
		Intent intent = getIntent();
		String nombre = intent.getStringExtra("nombre");
		String apellido = intent.getStringExtra("apellido");
		String telefono = intent.getStringExtra("telefono");
		String foto = intent.getStringExtra("foto");
		
		int resId = getResources().getIdentifier(foto, "drawable", getPackageName());
		Uri uri = Uri.parse("android.resource://com.example.listview2/drawable/"+foto);
	
		
		
		TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
		tvNombre.setText(nombre+" "+apellido);
		
		TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
		tvTelefono.setText(telefono);
		
		ImageView imageview = (ImageView) findViewById(R.id.imageView1);
		
		imageview.setImageResource(resId);
//		imageview.setImageURI(uri);
	}

}
