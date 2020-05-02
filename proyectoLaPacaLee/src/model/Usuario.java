/**
 * @author Teodora Nikolaeva
 * @Group Grupo 2
 * @Date 9/3/2020
 * Clase principal de usuarios, contiene todos los atributos y funciones comunes a todos los usuarios
 */
package model;

public class Usuario {
	
	//atributos
	private String correo;
	private String contrasena;	
	private String dni;
	private String nombre;
	private String apellidos;
	private boolean bloqueado;
	private boolean admin;
	
	//constructor
	public Usuario(String dni, String correo, String contrasena, String nombre, String apellidos, boolean bloqueado, boolean admin) {
		
		this.correo = correo;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.bloqueado = bloqueado;
		this.admin = admin;
		
	}
	
	//funciones
	public void bloquear(Usuario a) {
		if (admin==true) {
			a.setBloqueado(true);
		}
	}
	
	
	//getters y setters
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	
	public boolean isBloqueado() {
		return bloqueado;
	}

	
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
}
