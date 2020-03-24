/**
 * @author Teodora Nikolaeva
 * @Group Grupo 2
 * @Date 9/3/2020
 */
package laPacaLee;

import java.util.Scanner;

public class Login {
	
	Scanner sc=new Scanner(System.in);
	//booleano que identifica si el usuario que ha iniciado sesion es administrador o no
	private boolean isAdmin=false;
	private UsuarioNormal usuarioDevuelto;
	
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public UsuarioNormal getUsuarioDevuelto() {
		return usuarioDevuelto;
	}
	
	//menu que se imprime al empezaar el login
	public void menu(Biblioteca biblio) {
		//a es una flag para controlar el bucle
		int a=2;
		while (a<3) {
			System.out.println("MENU, ELIGE UNA OPCION.");
			System.out.println("\t1.Crear Usuario");
			System.out.println("\t2.Inciciar Sesion");
			System.out.println("\tCualquier otra tecla para salir");
			String opcion=sc.nextLine();
			if (opcion.equals("1")) {
				//se utiliza la funcion crear de la clase Usuario
				biblio.getU().crear();
				//se añaden los valores creados a un nuevo UsuarioNormal en la lista 
				biblio.getUsers().add(new UsuarioNormal(biblio.getU().getCorreo(),biblio.getU().getContrasena(), biblio.getU().getNombre(),biblio.getU().getApellidos(),biblio.getU().getDni()));
				System.out.println("¡Enhorabuena!, ya puedes iniciar sesion");
			}
			else if (opcion.equals("2")) a=inicioSesion(a,biblio);
			else a=4;
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}	
	
	//funcion para iniciar sesion, se le pasa la variable a
	private int inicioSesion(int a, Biblioteca biblio) {
		//contador es una variable que informa de la existencia de un correo en la lista
		//c es otra flag de control
		int contador, c=0; 
		System.out.println("~~~~~Inicio de sesion~~~~~~~~");
		System.out.println("Correo electronico:");
		String correo=sc.nextLine();
		while (c==0) {
			//si el correo es igual al del administrador, se crea un acceso al administrador
			if (correo.equals(biblio.getAdmin().getCorreo())) {
				//se utiliza la funcion de accesoUsuario para el usuario administrador
				accesoUsuario(biblio.getAdmin(),biblio);
				//se controlan los bucles mediante las flags
				c=1;
				a=4;
			}
			//si el correo no es igual al de administrador, se comprueba en la lista de usuarios
			else {
				//contador se inicializa a 0 para prevenir errores
				contador=0;
				for (int i=0; i<biblio.getUsers().size();i++) {
					//si el correo coincide con alguno de la lista, se crea un acceso de usuario
					if (biblio.getUsers().get(i).comprobarCorreo(correo)==true) {
						//se utiliza la misma funcion pero para cada uno de los usuarios de la lista
						accesoUsuario(biblio.getUsers().get(i),biblio);
						//se controlan los bucles mediante las flags
						c=1;
						a=4;
					}
					//si no se ha detectado ningun usuario con ese correo, el contador suma 1
					else 
						contador+=1;
				}
				//si el valor final del contador es igual al numero de usuarios, significa que no existe tal correo
				if (contador==biblio.getUsers().size()) {
					System.out.println("*no existe*");
					//se vuelve a pedir el correo y vuelve al inicio
					correo=sc.nextLine();
				}
			}
		}
		//se devuelve la variable de control
		return a;
	}
	
	//método que comprueba la contraseña hasta que sea introducida correctamente y 
	//además identifica el tipo de usuario que ha iniciado sesión
	private void accesoUsuario(Usuario u, Biblioteca biblio){
		System.out.println("Contrasena:");
		String contrasena=sc.nextLine();	
		do {			
			if (u.comprobarContrasena(contrasena)==false){
				System.out.println("*incorrecto*");
				contrasena=sc.nextLine();
			}
		}while (u.comprobarContrasena(contrasena)==false);

		if(u==biblio.getAdmin()) {
			System.out.println("*valido*");
			//System.out.println("Eres administrador.");
			isAdmin=true;
			}
		else {
			System.out.println("*valido*");
			//System.out.println("Eres usuario.");
			isAdmin=false;
			//encontramos cual es el numero de posicion del usuario que se ha loggeado en la lista de usuarios
			int indice=biblio.getUsers().indexOf(u);
			//asignamos el usuario de la lista con el usuario que se va a devolver 
			usuarioDevuelto=biblio.getUsers().get(indice);
			
		}
	}
}
