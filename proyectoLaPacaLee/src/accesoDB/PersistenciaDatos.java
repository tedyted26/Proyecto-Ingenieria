package accesoDB;

import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.table.TableModel;

import model.Libro;
import model.Usuario;
import net.proteanit.sql.DbUtils;

public class PersistenciaDatos {
	
	private AccesoDB acceso;
	private Usuario user = null;
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rslt = null;

	public PersistenciaDatos() {
		acceso = new AccesoDB();
	}
	
	/**
	 * Crea un usuario y devuelve true si se inserta correctamente en la bbdd
	 * @param user
	 * @return boolean exito 
	 */
	public boolean crearUsuario(Usuario user) {
		//se declaran las variables que se van a utilizar
		
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
			pstmt.executeUpdate();
			
		//control de errores	
		} catch (ClassNotFoundException e) {
			//No se ha podido establecer la conexion con la base de datos
			return false;
		} catch (SQLException e) {
			return false;
			//error de sql
		}finally {
			try {
				//se cierran las conexiones
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	/**
	 * Consulta un usuario por su correo y devuelve los datos completos del usuario si se realiza correctamente
	 * @param correo
	 * @return user
	 */
	public Usuario consultarUsuario(String correo) {		
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
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	/**
	 * Consulta los datos de un usuario a traves de su dni y los devuelve
	 * @param dni
	 * @return user
	 */
	public Usuario consultarUsuarioDni(String dni) {
		try {
			//comprobar conexion
			con = acceso.getConexion();
			
			String query = "SELECT * FROM USUARIO WHERE DNI = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dni);
			
			rslt = pstmt.executeQuery();
			
			//declaracion de las variables e inicializacion vacia
			String correo = "";
			String contrasena = "";
			String nombre = "";
			String apellidos = "";
			boolean bloqueado;
			boolean admin;
			
			if (rslt.next()) {
				correo = rslt.getString("CORREO");
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
	
	/**
	 * Modifica el correo de un usuario utilizando su dni. Devuelve true si la modificacion se ha hecho con exito
	 * @param user
	 * @return boolean exito 
	 */
	public boolean modificarCorreoUsuario(Usuario user, String correoNuevo) {
		try {
			con = acceso.getConexion();

			String query = "UPDATE USUARIO SET CORREO = ? WHERE DNI = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, correoNuevo);
			pstmt.setString(2, user.getDni());

			pstmt.executeUpdate();
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			return false;
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	/**
	 * Modifica la contraseña de un usuario utilizando su dni. Devuelve true si la modificacion se ha hecho con exito
	 * @param user
	 * @param contrasena
	 * @return boolean exito
	 */
	public boolean modificarContrasenaUsuario(Usuario user, String contrasena) {
		//funciona igual que el metodo anterior
		boolean exito;
		
		try {
			con = acceso.getConexion();
			
			String query = "UPDATE USUARIO SET CONTRASENA = ? WHERE DNI = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, contrasena);
			pstmt.setString(2, user.getDni());
			
			int res = pstmt.executeUpdate();
			
			if (res == 1) {
				exito=true;
			} else {
				exito=false;
			}
			
		} catch (ClassNotFoundException e) {
			//No se ha podido establecer la conexion con la base de datos
			exito=false;
			
		} catch (SQLException e) {
			//Se ha producido un error de SQL
			exito=false;
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return exito;
	}
	
	/**
	 * Edita los campos de un usuario dependiendo de los parametros pasados
	 * @param dni del usuario a editar
	 * @param columna en la que se va a editar
	 * @param valor que se va a actualizar
	 * @return true si se ha realizado con exito
	 */
	public boolean editarUsuario(String dni, String columna, String valor) {
		boolean exito;
		try {
			con = acceso.getConexion();

			String query = "UPDATE USUARIO SET "+columna.toUpperCase()+" = ?  WHERE DNI = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, valor);
			pstmt.setString(2, dni);

			pstmt.executeUpdate();

			exito=true;

		} catch (ClassNotFoundException e) {
			exito=false;
			e.printStackTrace();
		} catch (SQLException e) {
			exito=false;
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return exito;
	}

	/**
	 * bloquea un usuario para que no sea capaz de entrar a su cuenta
	 * @param dni
	 * @return
	 */
	public boolean bloquearUsuario(String dni) {		
		try {
			con = acceso.getConexion();
			
			String query = "UPDATE USUARIO SET BLOQUEO = 1 WHERE DNI = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dni);
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

	}
	/**
	 * desbloquea un usario para que pueda volver a acceder a su cuenta
	 * @param dni
	 * @return true si se ha realizado con exito
	 */
	public boolean desbloquearUsuario(String dni) {		
		try {
			con = acceso.getConexion();
			
			String query = "UPDATE USUARIO SET BLOQUEO = 0 WHERE DNI = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dni);
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

	}
	/**
	 * convierte un usuario en administrador. Solo puede acceder a la pantalla de administracion
	 * @param dni
	 * @return
	 */
	public boolean covertirAdministrador(String dni) {
		try {
			con = acceso.getConexion();
			
			String query = "UPDATE USUARIO SET ADMIN = 1 WHERE DNI = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dni);
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

	}
	
	/**
	 * elimina un usuario por su dni
	 * @param dni
	 * @return true si se ha realizado con exito
	 */
	public boolean eliminarUsuario(String dni) {		
		try {
			con = acceso.getConexion();
			
			String query = "DELETE FROM USUARIO WHERE DNI = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dni);
			
			int res = pstmt.executeUpdate();
			
			if (res == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	/**
	 * Mete el libro pasado por parametro en la base de datos
	 * @param libro
	 * @return true si se ha realizado con exito
	 */
	public boolean crearLibro(Libro libro) {
		try {

			con = acceso.getConexion();

			String query = "INSERT INTO LIBRO (TITULO, AUTOR, RESUMEN, GENERO, CODIGO, PRESTADO)"+"VALUES (?,?,?,?,?,?)";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, libro.getTitulo());
			pstmt.setString(2, libro.getAutor());
			pstmt.setString(3, libro.getResumen());
			pstmt.setString(4, libro.getGenero());
			pstmt.setString(5, libro.getCodigo());
			pstmt.setBoolean(6, false);


			int res = pstmt.executeUpdate();

			if (res == 1) {
				return true;
			} else {
				return false;
			}


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				//se cierran las conexiones
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	/**
	 * Función que consulta los datos de un libro según su código
	 * @param codigo
	 * @return Libro
	 */
	public Libro consultarLibro(String codigo) {
		//declaracion de variables
		Libro libro = null;

		Connection conec = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;

		try {
			//comprobar conexion
			conec = acceso.getConexion();

			String query = "SELECT * FROM LIBRO WHERE CODIGO = ?";
			pstmt = conec.prepareStatement(query);
			pstmt.setString(1, codigo);

			rslt = pstmt.executeQuery();

			//declaracion de las variables e inicializacion vacia
			String autor = "";
			String resumen = "";
			String genero = "";
			String titulo = "";
			boolean prestado = false;
			String dniPrestatario = null;

			if (rslt.next()) {
				titulo = rslt.getString("TITULO");
				autor = rslt.getString("AUTOR");
				resumen = rslt.getString("RESUMEN");
				genero = rslt.getString("GENERO");
				prestado = rslt.getBoolean("PRESTADO");
				dniPrestatario = rslt.getString("PRESTATARIO");
				libro =new Libro(titulo, autor, resumen, genero, codigo, prestado, dniPrestatario);
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
	
	/**
	 * consulta un libro en la base de datos por el titulo
	 * @param titulo
	 * @return objeto Libro con los datos pedidos
	 */
	public Libro consultarLibroTitulo(String titulo) {
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
			String resumen = "";
			String genero = "";
			String codigo = "";
			boolean prestado = false;
			String dniPrestatario = null;

			if (rslt.next()) {
				autor = rslt.getString("AUTOR");
				resumen = rslt.getString("RESUMEN");
				genero = rslt.getString("GENERO");
				codigo = rslt.getString("CODIGO");
				prestado = rslt.getBoolean("PRESTADO");
				dniPrestatario = rslt.getString("PRESTATARIO");
				libro =new Libro(titulo, autor, resumen, genero, codigo, prestado, dniPrestatario);
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

	/**
	 * Funcion que cambia el estado de los libros a prestado
	 * @param codigo
	 * @return true cuando se realiza de forma correcta
	 */
	public boolean prestarLibro(String codigo, String dni) {
		//funciona de la misma manera que el metodo anterior
		boolean exito;
		try {
			con = acceso.getConexion();
			
			String query = "UPDATE LIBRO SET PRESTADO = 1, PRESTATARIO = ? WHERE CODIGO = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dni);
			pstmt.setString(2, codigo);
			
			pstmt.executeUpdate();
			
			exito=true;
			
		} catch (ClassNotFoundException e) {
			exito=false;
			e.printStackTrace();
		} catch (SQLException e) {
			exito=false;
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return exito;
	}
	/**
	 * Edita solo una caracteristica del libro dependiendo de los parametros pasados
	 * @param codigo del libro editado (primary key)
	 * @param columna que se vaya a editar
	 * @param valor que se va a actualizar
	 * @return true si se ha realizado con exito
	 */
	public boolean editarLibro(String codigo, String columna, String valor) {
		boolean exito;
		try {
			con = acceso.getConexion();

			String query = "UPDATE LIBRO SET "+columna.toUpperCase()+" = ?  WHERE CODIGO = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, valor);
			pstmt.setString(2, codigo);

			pstmt.executeUpdate();

			exito=true;

		} catch (ClassNotFoundException e) {
			exito=false;
			e.printStackTrace();
		} catch (SQLException e) {
			exito=false;
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return exito;
	}
	
	/**
	 * Marca el libro como devuelto y elimina al prestatario
	 * @param codigo del libro a devolver
	 * @return true si se ha realizado con exito
	 */
	public boolean devolverLibro(String codigo) {
		boolean exito;
	
		try {
			con = acceso.getConexion();
			
			String query = "UPDATE LIBRO SET PRESTADO = 0, PRESTATARIO = NULL WHERE CODIGO = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, codigo);
			
			pstmt.executeUpdate();
			
			exito=true;
			
		} catch (ClassNotFoundException e) {
			exito=false;
			e.printStackTrace();
		} catch (SQLException e) {
			exito=false;
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return exito;
	}
	
	/**
	 * elimina un libro por su codigo, antes de eliminarlo, si esta prestado primero hay que devolverlo para
	 * que no se produzca error al ejecutar
	 * @param codigo
	 * @return true si se ha realizado con exito
	 */
	public boolean eliminarLibro(String codigo) {
		try {
			con = acceso.getConexion();

			String query = "DELETE FROM LIBRO WHERE CODIGO = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, codigo);

			int res = pstmt.executeUpdate();

			if (res == 1) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	/**
	 * Función que modela una tabla dependiendo de los datos que se necesiten
	 * @param query Sentencia sql con los datos pedidos
	 * @return TableModel 
	 */
	public TableModel modelarTabla(String query) {
		DatabaseMetaData datos=null;
		TableModel modelo=null;
		try {
			con = acceso.getConexion();
			datos=con.getMetaData();
			rslt=datos.getTables(null, null, null, null);
			pstmt=con.prepareStatement(query);
			rslt=pstmt.executeQuery();

			modelo=DbUtils.resultSetToTableModel(rslt);
			return modelo;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	@SuppressWarnings("unchecked")
	public DefaultListModel cargarLista(String dniPrestatario) {
		try {
			con=acceso.getConexion();
			String query="SELECT * FROM LIBRO WHERE PRESTATARIO = ?";
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, dniPrestatario);
			rslt=pstmt.executeQuery();
			
			@SuppressWarnings("rawtypes")
			DefaultListModel modelo=new DefaultListModel();
			
			while(rslt.next()) {
				modelo.addElement(rslt.getString("TITULO"));
			}
			return modelo;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
