import java.util.ArrayList;

import control.Login;
import control.Ventana;
import model.Biblioteca;
import model.Libro;
import model.UsuarioNormal;

public class ASistema {
	
	private Login login;
	private Biblioteca biblio;
	private Ventana ventana;

	public ASistema() {
		biblio=new Biblioteca();
		login=new Login();
		ventana=new Ventana(biblio);
	}
	public static void main(String[] args) {
		ASistema s=new ASistema();
		
		ArrayList <UsuarioNormal> users=new ArrayList<UsuarioNormal>();
		
		//usuarios de prueba
		users.add(new UsuarioNormal("user0","user0","user 0","user 0","user 0"));
		users.add(new UsuarioNormal("user1","user1","user 1","user 1","user 1"));
		users.add(new UsuarioNormal("user2","user2","user 2","user 2","user 2"));
		s.biblio.setUsers(users);

		//login
		s.login.menu(s.biblio);
		
		
		ArrayList<Libro> libros=new ArrayList <Libro> ();
		
		//Libros de prueba
		libros.add(new Libro("Cien años de soledad", "Gaabriel García Márquez", "genero 1", "codigo 1") );
		libros.add(new Libro("titulo 2", "autor 1", "genero 1", "codigo 2") );
		libros.add(new Libro("titulo 3", "autor 2", "genero 1", "codigo 3") );
		libros.add(new Libro("titulo 4", "autor 2", "genero 1", "codigo 4") );
		libros.add(new Libro("titulo 5", "autor 2", "genero 1", "codigo 5") );
		s.biblio.setLibros(libros);
		
		//tipo de ventana que se muestra dependiendo del usuario que se ha loggeado
		if (s.login.getIsAdmin()==true) {
			s.ventana.admin(s.biblio.getAdmin());
		}
		else {
			s.ventana.user(s.login.getUsuarioDevuelto());
		}
		
	}

}
