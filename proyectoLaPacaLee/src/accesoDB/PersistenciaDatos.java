package accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Libro;
import model.Usuario;

public class PersistenciaDatos {
	
	private AccesoDB acceso;

	public PersistenciaDatos() {
		acceso = new AccesoDB();
	}
	
	public String crearUsuario(Usuario user) {
		//se declaran las variables que se van a utilizar
		//msg es el mensaje que se va a devolver, depende del resultado de la query
		String msg = "";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			//comprueba conexion
			con = acceso.getConexion();
			
			//declara un String query para hacer la peticion a la base de datos
			String query = "INSERT INTO USUARIO(DNI, CORREO, CONTRASENA, NOMBRE, APELLIDOS, BLOQUEO, ADMIN) VALUES(?,?,?,?,?,?,?);";
			
			//sustituye en query las interrogaciones por los datos que se quieren introducir
			try (Connection cone=this.acceso.getConexion()){
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, user.getDni());
				pstmt.setString(2, user.getCorreo());
				pstmt.setString(3, user.getContrasena());
				pstmt.setString(4, user.getNombre());
				pstmt.setString(5, user.getApellidos());
				pstmt.setBoolean(6, user.isBloqueado());
				pstmt.setBoolean(7, user.isAdmin());

			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			//se ejecuta la query y se devuelve un numero que indica si se ha realizado correctamente
			int res = pstmt.executeUpdate();
			
			//dependiendo del resultado, devuelve un mensaje u otro
			if (res == 1) {
				msg = "Usuario creado";
			} else {
				msg = "No se ha podido crear el usuario";
			}
			
		//control de errores	
		} catch (ClassNotFoundException e) {
			msg = "No se ha podido establecer la conexion con la base de datos";
			e.printStackTrace();
		} catch (SQLException e) {
			msg = "Se ha producido un error de SQL";
			e.printStackTrace();
		} finally {
			try {
				//se cierran las conexiones
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return msg;
	}
	
	//consulta de usuario por su correo
	public Usuario consultarUsuario(String correo) {
		//decalracion de variables
		Usuario user = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			//comprobar conexion
			con = acceso.getConexion();
			
			String query = "SELECT * FROM USUARIO WHERE CORREO = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, correo);
			
			rslt = pstmt.executeQuery();
			
			//declaracion de las variables e inicializacion vacia
			String dni = "";
			String contrasena = "";
			String nombre = "";
			String apellidos = "";
			boolean bloqueado;
			boolean admin;
			
			if (rslt.next()) {
				dni = rslt.getString("DNI");
				contrasena = rslt.getString("CONTRASENA");
				nombre = rslt.getString("NOMBRE");
				apellidos = rslt.getString("APELLIDOS");
				bloqueado = rslt.getBoolean("BLOQUEO");
				admin = rslt.getBoolean("ADMIN");
				
				user = new Usuario(dni, correo, contrasena, nombre, apellidos, bloqueado, admin);
			}
			//control de errores
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Correo inexistente");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Correo inexistente");
		} finally {
			try {
				//cierra conexiones
				if (rslt != null) rslt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//devuelve el usuario que se consulta
		return user;
	}

	public String modificarContrasenaUsuario(Usuario user) {
		//funciona igual que el metodo anterior
		String msg = "";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "UPDATE USUARIO SET CONTRASENA = ? WHERE CORREO = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getNombre());
			pstmt.setString(2, user.getCorreo());
			
			int res = pstmt.executeUpdate();
			
			if (res == 1) {
				msg = "La modificacion se ha realizado con exito";
			} else {
				msg = "No se ha podido realizar la modificacion";
			}
			
		} catch (ClassNotFoundException e) {
			msg = "No se ha podido establecer la conexion con la base de datos";
			e.printStackTrace();
		} catch (SQLException e) {
			msg = "Se ha producido un error de SQL";
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return msg;
	}

	//controla el bloqueo del usuario, sirve tanto para bloquear como para desboquear
	public String bloqueoUsuario(Usuario user) {
		//funciona de la misma manera que el metodo anterior
		String msg = "";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "UPDATE USUARIO SET BLOQUEADO = ? WHERE CORREO = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setBoolean(1, user.isBloqueado());
			pstmt.setString(2, user.getCorreo());
			
			int res = pstmt.executeUpdate();
			
			if (res == 1) {
				if (user.isBloqueado()) {
					msg = "Se ha bloqueado con exito";
				}
				else msg= "Se ha desbloqueado con exito";
			
			} else {
				msg = "No se ha podido realizar la modificacion";
			}
			
		} catch (ClassNotFoundException e) {
			msg = "No se ha podido establecer la conexion con la base de datos";
			e.printStackTrace();
		} catch (SQLException e) {
			msg = "Se ha producido un error de SQL";
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return msg;
	}
	
	public String eliminarUsuario(Usuario user) {
		String msg = "";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "DELETE FROM USUARIO WHERE CORREO = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getCorreo());
			
			int res = pstmt.executeUpdate();
			
			if (res == 1) {
				msg = "Usuario eliminado con exito";
			} else {
				msg = "No se ha podido eliminar";
			}
			
		} catch (ClassNotFoundException e) {
			msg = "No se ha podido establecer la conexion con la base de datos";
			e.printStackTrace();
		} catch (SQLException e) {
			msg = "Se ha producido un error de SQL";
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return msg;
	}

	public String crearLibro(Libro libro) {

		String mnsg = "";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = acceso.getConexion();

			String query = "INSERT INTO LIBRO (TITULO, AUTOR, RESUMEN, GENERO, CODIGO, PRESTADO)"+"VALUES ('?','?','?','?','?','?')";


			pstmt = con.prepareStatement(query);
			pstmt.setString(1, libro.getTitulo());
			pstmt.setString(2, libro.getAutor());
			pstmt.setString(3, libro.getResumen());
			pstmt.setString(4, libro.getGenero());
			pstmt.setString(5, libro.getCodigo());
			pstmt.setBoolean(6, libro.isPrestado());


			int res = pstmt.executeUpdate();

			if (res == 1) {
				mnsg = "Libro añadido";
			} else {
				mnsg = "No se ha podido añadir el nuevo libro";
			}


		} catch (ClassNotFoundException e) {
			mnsg = "No se ha podido establecer la conexion con la base de datos";
			e.printStackTrace();
		} catch (SQLException e) {
			mnsg = "Se ha producido un error de SQL";
			e.printStackTrace();
		} finally {
			try {
				//se cierran las conexiones
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return mnsg;
	}

	//consulta de libro por su titulo
	public Libro consultaLibro(String titulo) {
		//declaracion de variables
		Libro libro = null;

		Connection conec = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;

		try {
			//comprobar conexion
			conec = acceso.getConexion();

			String query = "SELECT * FROM LIBRO WHERE TITULO = ?";
			pstmt = conec.prepareStatement(query);
			pstmt.setString(1, titulo);

			rslt = pstmt.executeQuery();

			//declaracion de las variables e inicializacion vacia
			String autor = "";
			String genero = "";
			String codigo = "";
			boolean prestado = false;

			if (rslt.next()) {
				titulo = rslt.getString("TITULO");
				autor = rslt.getString("AUTOR");
				genero = rslt.getString("GENERO");
				codigo = rslt.getString("CODIGO");
				prestado = rslt.getBoolean("PRESTADO");
				libro = new Libro(titulo, autor, genero, codigo, prestado);
			}

			//control de errores
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//cierra conexiones
				if (rslt != null) rslt.close();
				if (pstmt != null) pstmt.close();
				if (conec != null) conec.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//devuelve el libro que se consulta
		return libro;
	}
	public String eliminarLibro(Libro libro) {
		String mnsg = "";

		Connection conec = null;
		PreparedStatement pstmt = null;

		try {
			conec = acceso.getConexion();

			String query = "DELETE FROM LIBRO WHERE TITULO = ?";

			pstmt = conec.prepareStatement(query);
			pstmt.setString(1, libro.getTitulo());

			int res = pstmt.executeUpdate();

			if (res == 1) {
				mnsg = "Libro eliminado con exito";
			} else {
				mnsg = "No se ha podido eliminar el libro";
			}

		} catch (ClassNotFoundException e) {
			mnsg = "No se ha podido establecer la conexion con la base de datos";
			e.printStackTrace();
		} catch (SQLException e) {
			mnsg = "Se ha producido un error de SQL";
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conec != null) conec.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return mnsg;
	}
}
