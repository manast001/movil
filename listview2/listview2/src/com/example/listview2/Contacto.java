package com.example.listview2;

public class Contacto {
	long id;
	String nombre;
	String apellido;
	String telefono;
	String foto;
	String sexo;
	
	public long getId()
	{
		return this.id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return nombre +" "+apellido;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public void setSexo(String sexo)
	{
		if(sexo.equals("Femenino") || sexo.substring(0, 1).equals("Masculino")){
			this.sexo=sexo;
		}else{
			this.sexo="No Definido";
		}
	}
	
	public String getSexo()
	{
		return this.sexo;
	}

}
