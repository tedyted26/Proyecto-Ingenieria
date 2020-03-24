/**
 * @author Teodora Nikolaeva
 * @Group Grupo 2
 * @Date 9/3/2020
 * Clase que también hereda atributos y funciones de la clase Usuario,
 * pero se diferencia de la clase administrador
 */
package laPacaLee;

import java.util.Vector;

public class UsuarioNormal extends Usuario {
	
	//atributos
	boolean bloqueado=false;

	//constructor
	public UsuarioNormal(String correo, String contrasena, String nombre, String apellidos, String dni) {
		super(correo, contrasena, nombre, apellidos, dni);
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
}
