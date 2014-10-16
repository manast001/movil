package com.example.listview2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class AgregarContactoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregarcontacto);

//		imageview.setImageURI(uri);
	}

	public void onClickButton(View v)
	{
		TextView nombre=(TextView) findViewById(R.id.txtNombre),telefono=(TextView) findViewById(R.id.txtTelefono);

		if(nombre.getText().toString().isEmpty() || telefono.getText().toString().isEmpty())
		{
			Toast toast=new Toast(this);
			toast.makeText(this, "Debes llenar todos los campos", 1000);

		}else
		{
			Contacto contacto=new Contacto();
			contacto.setNombre(nombre.getText().toString().substring(0,nombre.getText().toString().indexOf(" ")));
			contacto.setNombre(nombre.getText().toString().substring(nombre.getText().toString().indexOf(" ")+1,nombre.getText().toString().length()));
		}

	}

}
