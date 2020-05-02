package control;

import java.util.Scanner;

import model.Usuario;

public class Ventana {

	private Buscador bus;

	Scanner sc=new Scanner(System.in);

	public Ventana() {
		bus=new Buscador();
	}

	public void user (Usuario user) {
		if (user.isBloqueado()==true) {
			System.out.println("Lo sentimos, no esta autorizado para acceder a los servicios.");
			System.out.println("Para mas informacion, contacte al personal.");
		}
		else {
			System.out.println("Usuario: "+user.getNombre()+" "+user.getApellidos());
			System.out.println("¿Que desea hacer?");
			System.out.println("\t1. Buscar libro");//contiene la informacion del libro y notificar incidencia
			System.out.println("\t2. Devolver libro");//contiene consultar el estado del libro y devolverlo
			System.out.println("\t3. Ver perfil");//contiene editar perfil y darse de baja
			int opcion=sc.nextInt();
			switch (opcion) {
			case 1: bus.menu();
			break;
			case 2: //devolver libro
				break;
			case 3: 
				break;
			default: System.out.println("Se ha producido un error");
			break;
			}
		}
	}
	public void admin (Usuario admin) {
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
		case 2: bus.menu();
			break;
		case 3: {
		}
			break;
		case 4: //gestionar incidencias
		default: System.out.println("Se ha producido un error");
		break;
		}
	}

}
