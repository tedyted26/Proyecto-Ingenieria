/**
 * @author Teodora Nikolaeva
 * @Group Grupo 2
 * @Date 9/3/2020
 * Clase que hereda los atributos y funcionalidades de la clase Usuario
 * pero además tiene las de un usuario administrador
 */
package laPacaLee;

import java.util.Vector;

public class UsuarioAdmin extends Usuario{

	//constructor
	public UsuarioAdmin(String correo, String contrasena, String nombre, String apellidos, String dni) {
		super(correo, contrasena, nombre, apellidos, dni);
	}
	
	//funciones
	public void bloquear(UsuarioNormal a) {
		a.setBloqueado(true);
	}
	
}
