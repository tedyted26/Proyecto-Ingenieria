package control;

import java.util.Scanner;

import model.Biblioteca;
import model.UsuarioAdmin;
import model.UsuarioNormal;

public class Ventana {

	private Buscador bus;
	private Biblioteca biblio;

	Scanner sc=new Scanner(System.in);

	public Ventana(Biblioteca biblio) {
		bus=new Buscador();
		this.biblio=biblio;
	}

	public void user (UsuarioNormal user) {
		
		System.out.println("Usuario: "+user.getNombre()+" "+user.getApellidos());
		System.out.println("¿Que desea hacer?");
		System.out.println("\t1. Buscar libro");//contiene la informacion del libro y notificar incidencia
		System.out.println("\t2. Devolver libro");//contiene consultar el estado del libro y devolverlo
		System.out.println("\t3. Ver perfil");//contiene editar perfil y darse de baja
		int opcion=sc.nextInt();
		switch (opcion) {
		case 1: bus.menu(biblio);
		break;
		case 2: //devolver libro
			break;
		case 3: //ver perfil
			break;
		default: System.out.println("Se ha producido un error");
		break;

		}
	}
	public void admin (UsuarioAdmin admin) {
		System.out.println("Usuario: "+admin.getNombre()+" "+admin.getApellidos());
		System.out.println("¿Que desea hacer?");
		System.out.println("\t1. Anadir libro");
		System.out.println("\t2. Buscar libro"); //contiene ademas las opciones de editar y eliminar el libro
		System.out.println("\t3. Añadir usuario");
		System.out.println("\t4. Buscar usuario");//contiene la opcion de bloquear y eliminar usuarios
		System.out.println("\t5. Gestionar incidencias");
		int opcion=sc.nextInt();
		switch (opcion) {
		case 1: //añadir libro
			break;
		case 2: bus.menu(biblio);
			break;
		case 3: //añadir usuario
			break;
		case 4: //gestionar incidencias
		default: System.out.println("Se ha producido un error");
		break;
		}
	}

}
