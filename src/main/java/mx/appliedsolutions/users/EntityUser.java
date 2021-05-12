package mx.appliedsolutions.users;

import org.springframework.data.annotation.Id;


public class EntityUser {
	@Id
	public String id;
	
	public String nombre;
	public String telefono;
	public String correo;
	public String empresa;
	
	public EntityUser() {}
	
	public EntityUser(String nombre, String telefono, String correo, String empresa) {
		this.nombre=nombre;
		this.telefono=telefono;
		this.correo=correo;
		this.empresa=empresa;
	}
	
	@Override
	public String toString() {
		return  String.format("EntityUser [id=%s, nombre=%s', telefono=%s', correo=%s', empresa=%s']",id,nombre,telefono,correo, empresa );
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	
	
	 
}
