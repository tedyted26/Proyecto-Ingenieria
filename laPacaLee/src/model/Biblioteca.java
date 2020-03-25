/**
 * @author Teodora Nikolaeva
 * @Group Grupo 2
 * @Date 9/3/2020
 * Clase principal. Es la que contiene los datos de la biblioteca. 
 * Contiene los usuarios y los libros.
 */
package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	
	//atributos: usuarios
	private ArrayList<UsuarioNormal> users;
	private UsuarioAdmin admin;
	private Usuario u;
	
	//atributos: libros
	private ArrayList <Libro> libros;
	


	//constructor
	public Biblioteca() {
		users=new ArrayList<UsuarioNormal>();
		admin=new UsuarioAdmin("admin","admin", "administrador", "de biblioteca", "*dni*");
		u=new Usuario("u","u", "u", "u", "u"); //inicializados de esta manera para poder utilizar sus métodos
		libros=new ArrayList<Libro>();
	}

	//getters y setters
	public ArrayList<UsuarioNormal> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<UsuarioNormal> users) {
		this.users = users;
	}

	public UsuarioAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(UsuarioAdmin admin) {
		this.admin = admin;
	}

	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}
	
	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

}


