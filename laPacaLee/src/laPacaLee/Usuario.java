/**
 * @author Teodora Nikolaeva
 * @Group Grupo 2
 * @Date 9/3/2020
 * Clase principal de usuarios, contiene todos los atributos y funciones comunes a todos los usuarios
 */
package laPacaLee;

import java.util.Scanner;
import java.util.Vector;

public class Usuario {
	Scanner sc=new Scanner(System.in);
	
	//atributos
	private String correo;
	private String contrasena;
	private Vector<Incidencia> vectorIncidencias;
	
	private String dni="";
	private String nombre="";
	private String apellidos="";
	
	
	//constructor
	public Usuario(String correo, String contrasena, String nombre, String apellidos, String dni) {
		super();
		this.correo = correo;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
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

	public Vector<Incidencia> getVectorIncidencias() {
		return vectorIncidencias;
	}

	public void setVectorIncidencias(Vector<Incidencia> vectorIncidencias) {
		this.vectorIncidencias = vectorIncidencias;
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

	//funciones
	//menu de creacion de usuario
	public void crear() {
		System.out.println("~~~~~Creacion de Usuario~~~~~");
		System.out.println("Nombre:");
		this.nombre=sc.nextLine();
		System.out.println("Apellidos: ");
		this.apellidos=sc.nextLine();
		System.out.println("DNI: ");
		this.dni=sc.nextLine();
		System.out.println("Correo electrónico:");
		this.correo=sc.nextLine();
		System.out.println("Contrasena:");
		this.contrasena=sc.nextLine();		
	}
	
	//menu de eliminacion de usuario
	public void eliminar() {
	}
	
	//comprobacion del correo
	public boolean comprobarCorreo(String correo) {

		if (this.correo.equals(correo)) {
			return true;
		}
		else return false;
	}
	
	//comprobacion de la contraseña
	public boolean comprobarContrasena(String contrasena) {
		if (this.contrasena.equals(contrasena)) {
			return true;
		}
		else return false;
	}
	
}
