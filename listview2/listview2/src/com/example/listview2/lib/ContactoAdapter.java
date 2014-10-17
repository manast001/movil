package com.example.listview2.lib;

import java.util.List;

import com.example.listview2.Contacto;

import com.example.listview2.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ContactoAdapter extends ArrayAdapter<Contacto> {
	
	private Context context;
	private List<Contacto> objects;

	public ContactoAdapter(Context context, int textViewResourceId,
			List<Contacto> objects) {
		super(context, textViewResourceId, objects);
		
		this.context = context;
		this.objects = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Contacto contacto =objects.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.detallecontacto_item, null);
		
		TextView tvNombre = (TextView) view.findViewById(R.id.tvNombreItem);
		tvNombre.setText(contacto.getNombre());
		
		TextView tvApellido = (TextView) view.findViewById(R.id.tvApellidoItem);
		tvApellido.setText(contacto.getApellido());
		
		return view;
	}

	

}
