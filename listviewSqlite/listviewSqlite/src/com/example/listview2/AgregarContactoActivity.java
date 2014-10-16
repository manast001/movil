package com.example.listview2;

import com.example.listview2.db.ContactosDataSource;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class AgregarContactoActivity extends Activity {
	private ContactosDataSource data;

	private int []imagenes=new int[]{R.drawable.akita,R.drawable.beagle};
	private String []fotos=new String[]{"akita","beagle"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregarcontacto);

		this.data=new ContactosDataSource(this);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setDisplayShowHomeEnabled(true);




//		imageview.setImageURI(uri);
	}

	public void onClickButton(View v)
	{
		TextView nombre=(TextView) findViewById(R.id.txtNombre),telefono=(TextView) findViewById(R.id.txtTelefono);

		if(nombre.getText().toString().isEmpty() || telefono.getText().toString().isEmpty())
		{
			Toast toast=new Toast(this);
			toast.makeText(this, "Debes llenar todos los campos", 1000);
			toast.show();

		}else
		{
			Contacto contacto=new Contacto();
			contacto.setNombre(nombre.getText().toString().substring(0,nombre.getText().toString().indexOf(" ")));
			contacto.setApellido(nombre.getText().toString().substring(nombre.getText().toString().indexOf(" ")+1,nombre.getText().toString().length()));
			contacto.setTelefono(telefono.getText().toString());
			//contacto.setFoto(AGREGEWEAAQUI);
			this.data.openDB();

			this.data.agregarContacto(contacto);

			this.data.closeDB();

			nombre.setText("");
			telefono.setText("");
		}

	}

	public void cambiarImagen(View v)
	{
		ImageView imagen = (ImageView) findViewById(R.id.imageView1);
	}

}
