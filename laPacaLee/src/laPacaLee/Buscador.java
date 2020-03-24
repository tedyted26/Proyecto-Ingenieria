package laPacaLee;
import java.util.*;

public class Buscador {
	
	public void menu(Biblioteca b) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Criterio de busqueda");
		System.out.println("\t1. Por titulo");
		System.out.println("\t2. Por genero");
		System.out.println("\t3. Por autor");
		System.out.println("\t4. Por código de identificacion");
		int opcion=sc.nextInt();
		switch (opcion) { //esta parte del código debe ser depurada y optimizada
		case 1:
			System.out.println("Introduzca el titulo");
			sc.nextLine();
			String titulo=sc.nextLine();
			if(buscar(b.getLibros(), opcion, titulo)) {
				System.out.println("Dicho libro se encuentra disponible");
				System.out.println("*Aqui se muestra su informacion*");
			}
			else
				System.out.println("El titulo "+titulo+" no esta disponible");
			break;
		case 2:
			System.out.println("Elija genero");
			System.out.println("\t1. Accion");
			System.out.println("\t2. Aventura");
			System.out.println("\t3. Romance");
			System.out.println("\t4. Miedo");
			System.out.println("\t5. Drama");
			break;
		case 3: 
			System.out.println("Introduzca el autor");
			sc.nextLine();
			String autor=sc.nextLine();
			if(buscar(b.getLibros(), opcion, autor)) {
				System.out.println("Dicho libro se encuentra disponible");
				System.out.println("*Aqui se muestra su informacion*");
			}
			else
				System.out.println("El titulo "+autor+" no esta disponible");
			
			break;
		case 4: 
			System.out.println("Introduzca el codigo");
			sc.nextLine();
			String codigo=sc.nextLine();
			if(buscar(b.getLibros(), opcion, codigo)) {
				System.out.println("Dicho libro se encuentra disponible");
				System.out.println("*Aqui se muestra su informacion*");
			}
			else
				System.out.println("El titulo "+codigo+" no esta disponible");
			
		}
	}
	
	private boolean buscar(ArrayList<Libro> libros,int opcion, String criterio) {
		boolean disponible=false;
		if (opcion==1) {
			for (int i=0; i<libros.size()&&!disponible; i++) {
				if (libros.get(i).getTitulo().equals(criterio))
					disponible=true;
			}
		}
		else if (opcion==3) {
			for (int i=0; i<libros.size()&&!disponible; i++) {
				if (libros.get(i).getAutor().equals(criterio))
					disponible=true;
			}
		}
		else if (opcion==4) {
			for (int i=0; i<libros.size()&&!disponible; i++) {
				if (libros.get(i).getCodigo().equals(criterio))
					disponible=true;
			}
		}
		
		return disponible;
	}
}
