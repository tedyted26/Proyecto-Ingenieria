package control;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import accesoDB.PersistenciaDatos;
import model.Usuario;
import vista.A0VentanaInicio;
import vista.A1VentanaUsuario;
import vista.A2VentanaAdmin;
import vista.PopUp1B;
import vista.PopUp2B;
import vista.PopUpInfo;

public class Controlador implements ActionListener{

	private PersistenciaDatos p;
	
	private A0VentanaInicio app0;
	private A1VentanaUsuario app1;
	private A2VentanaAdmin app2;
	private PopUp1B popup;
	private PopUp2B popupPedirPrestado;
	private PopUp2B popupBloquearUsuario;
	private PopUp2B popupEliminarUsuario;
	private PopUp2B popupEliminarLibro;
	private PopUpInfo popupInfoLibro;
	

	/**
	 * Constructor
	 * @param app0 Ventana de inicio de sesion
	 * @param app1 Ventana de uso de usuarios
	 * @param app2 Ventana de uso de administracion
	 */
	public Controlador(A0VentanaInicio app0, A1VentanaUsuario app1, A2VentanaAdmin app2, PopUp1B popup) {
		this.app0=app0;
		this.app1=app1;
		this.app2=app2;
		this.popup=popup;
		this.p=new PersistenciaDatos();
		
		popupPedirPrestado = new PopUp2B();
		popupPedirPrestado.setControlador(this);
		
		popupBloquearUsuario = new PopUp2B();
		popupBloquearUsuario.setControlador(this);
		
		popupEliminarUsuario = new PopUp2B();
		popupEliminarUsuario.setControlador(this);
		
		popupEliminarLibro = new PopUp2B();
		popupEliminarLibro.setControlador(this);
	}
		
	/**
	 * Método que dicta las acciones de los componentes de las ventanas inicializadas
	 * @param ev Evento que recoge la clase al implementar el ActionListener
	 */
	public void actionPerformed(ActionEvent ev) {
		//variables para simplificar
		Object fuente = ev.getSource();
		Container parent0 = app0.getFrmLaPacaLee().getContentPane();
		Container parent1 = app1.getOpciones();
		Container parent2 = app2.getBiblioteca();
		Container parent3 = app2.getUsuarios();
		Container parent4 = app2.getOpciones();
		
		//TODO MIRAR COMO HACER QUE CUANDO TE SALGAS DE UN PANEL VUELVA AL INICIAL
		//TODO MIRAR "" CUANDO TE SALES DE LA APLICACION Y VUELVES A ENTRAR QUE VUELVA AL INICIAL
		
		/**
		 * Acciones de la ventana de inicio (inicio de sesion, y creación de cuenta)
		 */
		
		//PANEL INICIO
		if (fuente.equals(app0.getBtnCrearCuenta())) {
			app0.getCl().show(parent0, "2");
		}
		
		else if(fuente.equals(app0.getBtnIniciarSesion())) {
			app0.getCl().show(parent0, "3");
		}
		
		
		//PANEL CREACION DE CUENTA
		else if(fuente.equals(app0.getBtnCCAtras())) {
			app0.eliminarContenidoCC();
			app0.getCl().show(parent0, "1");

		}
		
		else if(fuente.equals(app0.getBtnCCSiguiente())) {
			
			//TODO COMPROBAR QUE EL DNI Y EL CORREO SON UNICOS Y CONTROLAR ERRORES (SI EXISTE USUARIO)
			//TODO COMPROBAR FORMATO DEL CORREO Y FORMATO DEL DNI(8N Y 1L O 7N Y 2L)
			//TODO CONTRASEÑA FORMATO DE MÁS DE X CARACTERES
			//TODO LIMPIAR LOS ESPACIOS DE LOS CAMPOS CADA VEZ QUE SE RECOGEN LOS DATOS
			crearUsuario(app0);
		}
		
		
		//POP UP 
		else if(fuente.equals(popup.getBtnAceptar())) {
			popup.getFrmpopup().setVisible(false);
		}
		
		
		//PANEL INICIO DE SESION
		else if(fuente.equals(app0.getBtnAtras())) {
			app0.eliminarContenidoIS();
			app0.getCl().show(parent0, "1");
		}
		
			//inicio de sesion normal
		else if(fuente.equals(app0.getBtnSiguiente())) {
			iniciarSesion(app0.getBtnSiguiente());
			rellenarDatosU(app0.getBtnSiguiente());
		}
		
			//inicio de sesion de administrador
		else if(fuente.equals(app0.getBtnAdmin())) {
			iniciarSesion(app0.getBtnAdmin());
			rellenarDatosU(app0.getBtnAdmin());
		}
		
		/**
		 * Acciones de la ventana de usuario (inicio, biblioteca y opciones)
		 */
		
		else if(fuente.equals(app1.getBtnBuscar())) {
			// TODO buscador
		}
		else if(fuente.equals(app1.getBtnVerDetalles())) {
			//TODO panel con detalles de los libros
		}
		else if(fuente.equals(app1.getBtnPedirPrestado())) {
			popupPedirPrestado.getLblAviso().setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
			popupPedirPrestado.getLblAviso().setText("¿Seguro que quieres este libro?");
			popupPedirPrestado.getFrmpopup().setVisible(true);
		}
		
		//POP UP
		else if(fuente.equals(popupPedirPrestado.getBtnNo())) {
			popupPedirPrestado.getFrmpopup().setVisible(false);
		}
		else if(fuente.equals(popupPedirPrestado.getBtnSi())) {
			popup.getFrmpopup().getContentPane().setBackground(new Color(255, 228, 196));
			popup.getLblAviso().setText("¡Hecho!");
			popup.getFrmpopup().setVisible(true);
			popupPedirPrestado.getFrmpopup().setVisible(false);
			//TODO cambiar estado del libro
		}
		
		else if(fuente.equals(app1.getBtnModificarPerfil())) {
			app1.getCl().show(parent1, "2");
		}
		else if(fuente.equals(app1.getBtnCancelar())) {
			app1.getCl().show(parent1, "1");
			app1.eliminarContenidoMU();
		}
		else if(fuente.equals(app1.getBtnConfirmarModificaciones())) {
			modificarPerfil();	
		}
		else if(fuente.equals(app1.getBtnInformacionYContacto())) {
			app1.getCl().show(parent1, "3");
		}
		else if(fuente.equals(app1.getBtncontactanos())) {
			//TODO cambiar el correo por una consulta a la base de datos
			popup.getLblAviso().setText("Correo: admin@admin");
			popup.getFrmpopup().setBackground(new Color(255, 192, 203));
			popup.getFrmpopup().setVisible(true);
		}
		else if(fuente.equals(app1.getBtnAtras())) {
			app1.getCl().show(parent1, "1");
		}
		else if(fuente.equals(app1.getBtnEliminarCuenta())) {
			app1.getCl().show(parent1, "4");
		}
		else if(fuente.equals(app1.getBtnNo())) {
			app1.getCl().show(parent1, "1");
		}
		else if(fuente.equals(app1.getBtnSi())) {
			p.eliminarUsuario(app1.getTextFieldDNI().getText());
			popup.getLblAviso().setText("Eliminado con éxito");
			popup.getFrmpopup().setBackground(new Color(255, 192, 203));
			popup.getFrmpopup().setVisible(true);
			cerrarSesion(app1);
		}
		else if(fuente.equals(app1.getBtnCerrarSesion())) {
			cerrarSesion(app1);
		}
		else if(fuente.equals(app1.getBtnSalir())||fuente.equals(app2.getBtnSalir())) {
			System.exit(0);
		}
		
		/**
		 * Acciones de la ventana de administrador (inicio, biblioteca, usuarios y opciones)
		 */
		//BIBLIOTECA
		else if(fuente.equals(app2.getBtnBuscar())) {
			//TODO buscador
		}
		else if(fuente.equals(app2.getBtnAnadir())) {
			app2.getCb().show(parent2, "2");
		}
		else if(fuente.equals(app2.getBtnCancelarAnadir())) {
			app2.getCb().show(parent2, "1");
			app2.eliminarDatosAnadirLibro();
		}
		else if(fuente.equals(app2.getBtnConfirmar())) {
			popup.getLblAviso().setText("Libro añadido");
			popup.getFrmpopup().setBackground(new Color(255, 250, 240));
			popup.getFrmpopup().setVisible(true);
			app2.eliminarDatosAnadirLibro();
			//TODO añadir libro a la base de datos
//			app2.getCb().show(parent2, "1");
		}
		else if(fuente.equals(app2.getBtnDetalles())) {
			//TODO JDialog con los detalles
		}
		else if(fuente.equals(app2.getBtnEditar())) {
			//TODO si no hay libro seleccionado que lo diga
			app2.getCb().show(parent2, "3");
		}
		else if(fuente.equals(app2.getBtnCancelarEditar())) {
			app2.getCb().show(parent2, "1");
			
		}
		else if(fuente.equals(app2.getBtnConfirmarCambios())) {
			popup.getLblAviso().setText("Cambios realizados");
			popup.getFrmpopup().setBackground(new Color(255, 250, 240));
			popup.getFrmpopup().setVisible(true);
//			app2.getCb().show(parent2, "1");
		}
		else if(fuente.equals(app2.getBtnEliminar())) {
			popupEliminarLibro.getLblAviso().setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
			popupEliminarLibro.getLblAviso().setText("¿Desea eliminar este libro?");
			popupEliminarLibro.getFrmpopup().setVisible(true);
			
		}
		//POPUP
		else if (fuente.equals(popupEliminarLibro.getBtnNo())) {
			popupEliminarLibro.getFrmpopup().setVisible(false);
		}
		else if (fuente.equals(popupEliminarLibro.getBtnSi())) {	
			popup.getLblAviso().setText("Libro eliminado");
			popup.getFrmpopup().setBackground(new Color(255, 250, 240));
			popup.getFrmpopup().setVisible(true);
			popupEliminarLibro.getFrmpopup().setVisible(false);
			//TODO ELIMINAR DE LA BASE DE DATOS
		}
		
		//USUARIOS
		else if(fuente.equals(app2.getBtnBuscarU())) {
			//TODO buscador
		}
		else if(fuente.equals(app2.getBtnAnadirU())) {
			app2.getCu().show(parent3, "2");
		}
		else if(fuente.equals(app2.getBtnCancelarAnadirU())) {
			app2.getCu().show(parent3, "1");
			app2.eliminarContenidoCC();
		}
		else if(fuente.equals(app2.getBtnConfirmarU())) {
			crearUsuario(app2);
		}
		else if(fuente.equals(app2.getBtnVerInfo())) {
			//JDialog con informacion
		}
		else if(fuente.equals(app2.getBtnEditarU())) {
			//TODO si no hay usuario que lo diga
			app2.getCu().show(parent3, "3");
		}
		else if(fuente.equals(app2.getBtnCancelarEditarU())) {
			app2.getCu().show(parent3, "1");
		}
		else if(fuente.equals(app2.getBtnConfirmarCambiosU())) {
			popup.getLblAviso().setText("Cambios realizados");
			popup.getFrmpopup().setBackground(new Color(255, 250, 240));
			popup.getFrmpopup().setVisible(true);
			//TODO hacer update de la base de datos
		}
		else if(fuente.equals(app2.getBtnBloquear())) {
			popupBloquearUsuario.getLblAviso().setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
			popupBloquearUsuario.getLblAviso().setText("¿Desea bloquear este usuario?");
			popupBloquearUsuario.getFrmpopup().setVisible(true);
		}
		
		//popup
		else if (fuente.equals(popupBloquearUsuario.getBtnNo())){
			popupBloquearUsuario.getFrmpopup().setVisible(false);
		}
		else if (fuente.equals(popupBloquearUsuario.getBtnSi())) {
			popup.getLblAviso().setText("Usuario bloqueado");
			popup.getFrmpopup().setBackground(new Color(255, 250, 240));
			popup.getFrmpopup().setVisible(true);
			popupBloquearUsuario.getFrmpopup().setVisible(false);
			//TODO update a la base de datos
		}
		
		else if(fuente.equals(app2.getBtnEliminarU())) {
			popupEliminarUsuario.getLblAviso().setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
			popupEliminarUsuario.getLblAviso().setText("¿Desea eliminar este usuario?");
			popupEliminarUsuario.getFrmpopup().setVisible(true);	
		}
		
		//POPUP
		else if (fuente.equals(popupEliminarUsuario.getBtnNo())) {
			popupEliminarUsuario.getFrmpopup().setVisible(false);
		}
		else if (fuente.equals(popupEliminarUsuario.getBtnSi())) {
			popup.getLblAviso().setText("Usuario eliminado");
			popup.getFrmpopup().setBackground(new Color(255, 250, 240));
			popup.getFrmpopup().setVisible(true);
			popupEliminarUsuario.getFrmpopup().setVisible(false);
			//TODO delete a la base de datos
		}
		else if(fuente.equals(app2.getBtnInformacion())) {
			app2.getCo().show(parent4, "2");
		}
		else if(fuente.equals(app2.getBtnAtras())) {
			app2.getTxtpnLapacalee().setEditable(false);
			app1.getTxtpnLapacalee().setText(app2.getTxtpnLapacalee().getText());
			app2.getCo().show(parent4, "1");
		}
		else if(fuente.equals(app2.getBtnEditarInfo())) {
			app2.getTxtpnLapacalee().setEditable(true);
		}
		else if(fuente.equals(app2.getBtncontactanos())) {
			popup.getLblAviso().setText("Correo: admin@admin");
			popup.getFrmpopup().setBackground(new Color(255, 192, 203));
			popup.getFrmpopup().setVisible(true);
		}
		else if(fuente.equals(app2.getBtnCerrarSesion())) {
			cerrarSesion(app2);
		}
	}
	
	/**
	 * Crea un usuario en la base de datos dependiendo desde qué ventana se esta dando la instrucción
	 * @param app
	 */
	private void crearUsuario(Object app) {
		
		if (app instanceof A0VentanaInicio){
			A0VentanaInicio app0=(A0VentanaInicio)app;
			Usuario u=app0.obtenerDatosUsuarioCC();
			if (u==null) {
				app0.getLblMensaje().setText("Las contraseñas no coinciden");
			}
			else if (app0.comprobarDatosCC()==false) {
				app0.getLblMensaje().setText("Debe completar los campos");			
			}
			else if(app0.comprobarDatosCC()&&p.crearUsuario(u)) {
				popup.getFrmpopup().getContentPane().setBackground(new Color(255, 192, 203));
				popup.getLblAviso().setText("Usuario creado con éxito");
				popup.getFrmpopup().setVisible(true);
				app0.eliminarContenidoCC();
				app0.getCl().show(app0.getFrmLaPacaLee().getContentPane(), "1");
			}
			else app0.getLblMensaje().setText("Correo ya existente");
		}
		else if (app instanceof A2VentanaAdmin) {
			A2VentanaAdmin app2=(A2VentanaAdmin)app;
			Usuario u=app2.obtenerDatosUsuarioCC();
			if (u==null) {
				app2.getLblMensaje().setText("Las contraseñas no coinciden");
			}
			else if (app2.comprobarDatosCC()==false) {
				app2.getLblMensaje().setText("Debe completar los campos");			
			}
			else if(app2.comprobarDatosCC()&&p.crearUsuario(u)) {
				popup.getFrmpopup().getContentPane().setBackground(new Color(255, 250, 240));
				popup.getLblAviso().setText("Usuario creado con éxito");
				popup.getFrmpopup().setVisible(true);
				app2.eliminarContenidoCC();
				app2.getCu().show(app2.getUsuarios(), "1");
			}
			else app2.getLblMensaje().setText("Correo ya existente");
		}
		
	}

	/**
	 * Método que, dependiendo del boton que se pulse realiza un inicio de sesion u otro
	 * @param boton pulsado
	 */
	private void iniciarSesion(JButton boton) {

		String[] datos=app0.devolverDatosIS();

		String correo=datos[0];
		String contrasena=datos[1];

		if (correo.equals("")||contrasena.equals("")) {
			app0.getLblAutentificacionDeContrasena().setText(("Debe completar los campos"));
		}
		else {
			Usuario u=p.consultarUsuario(correo);

			if (u==null) {
				app0.getLblAutentificacionDeContrasena().setText(("Correo inexistente"));
			}
			else if(boton.equals(app0.getBtnSiguiente())&&u.isAdmin()==false&&contrasena.equals(u.getContrasena())) {
				app0.getFrmLaPacaLee().setVisible(false);
				app1.getFrmLapacalee().setVisible(true);
			}
			else if(boton.equals(app0.getBtnAdmin())&&u.isAdmin()&&contrasena.equals(u.getContrasena())) {
				app0.getFrmLaPacaLee().setVisible(false);
				app2.getFrmLapacalee().setVisible(true);
			}else app0.getLblAutentificacionDeContrasena().setText(("Correo o contraseña incorrectos"));
		}
	}
	
	/**
	 * Método que identifica qué ventana es de la que proviene la orden y cierra la sesión
	 * @param app Ventana de procedencia
	 */
	private void cerrarSesion(Object app) {
		Container parent0 = app0.getFrmLaPacaLee().getContentPane();
		if (app instanceof A1VentanaUsuario) {
			A1VentanaUsuario app1=(A1VentanaUsuario)app;
			app1.getFrmLapacalee().setVisible(false);		
		}
		else {
			A2VentanaAdmin app2=(A2VentanaAdmin)app;
			app2.getFrmLapacalee().setVisible(false);
		}
		app0.getFrmLaPacaLee().setVisible(true);
		app0.getCl().show(parent0, "3");
		app0.eliminarContenidoIS();
	}
	
	/**
	 * Recoge los datos que se han insertado en el inicio de sesion y devuelve el usuario completo
	 * @return u
	 */
	private Usuario getUsuarioIS() {
		String [] datos = app0.devolverDatosIS();
		String correo=datos[0];
		Usuario u=p.consultarUsuario(correo);
		return u;
	}
	
	/**
	 * Dependiendo del boton pulsado rellena los campos de una ventana o de otra
	 * @param boton
	 */
	private void rellenarDatosU(JButton boton) {
		Usuario u=getUsuarioIS();
		
		//datos de usuario
		if (boton.equals(app0.getBtnSiguiente())) {
			//DATOS DE PERFIL
			try {
			app1.getTextFieldNombre().setText(u.getNombre());
			app1.getTextFieldNombre().setText(u.getNombre());
			app1.getTextFieldApellidos().setText(u.getApellidos());
			app1.getTextFieldCorreo().setText(u.getCorreo());
			app1.getTextFieldDNI().setText(u.getDni());
			//DATOS DE MODIFICAR PERFIL
			app1.getTextFieldCorreoActual().setText(u.getCorreo());
			}
			catch (Exception e) {
				System.out.println("No se pueden rellenar los datos");
			}
		}
		else if (boton.equals(app0.getBtnAdmin())){
			try {
			app2.getTextFieldNombre().setText(u.getNombre());
			app2.getTextFieldNombre().setText(u.getNombre());
			app2.getTextFieldApellidos().setText(u.getApellidos());
			app2.getTextFieldCorreo().setText(u.getCorreo());
			app2.getTextFieldDNI().setText(u.getDni());
			}
			catch (Exception e) {
				System.out.println("No se pueden rellenar los datos");
			}
		}
		
	}
	
	/**
	 * Actualiza los datos al modificar el perfil nada mas se modifican
	 * @param dni para evitar fallos
	 */
	private void actualizarDatos(String dni) {
		Usuario u=p.consultarUsuarioDni(dni);
		app1.getTextFieldCorreo().setText(u.getCorreo());
		app1.getTextFieldCorreoActual().setText(u.getCorreo());
	}
	
	/**
	 * Modifica el perfil del usuario desde su cuenta
	 */
	@SuppressWarnings("deprecation")
	private void modificarPerfil(){
		Usuario u=getUsuarioIS();
		if (app1.getPasswordFieldContrasenaActual().getText().equals(u.getContrasena())) {
			if (app1.getTextFieldCorreoNuevo().getText().equals("")&&app1.getPasswordContrasena().getText().equals("")) {
				app1.getLabelMensaje().setText("No hay nada que cambiar");
			}
			else if (!app1.getTextFieldCorreoNuevo().getText().equals("")){
				
				if(p.modificarCorreoUsuario(u,app1.getTextFieldCorreoNuevo().getText())) {
					popUpModificarPerfil();
					actualizarDatos(u.getDni());
				}
				else app1.getLabelMensaje().setText("Correo no disponible");

			}
			else if (!app1.getPasswordContrasena().getText().equals("")&&app1.getPasswordContrasena().getText().equals(app1.getPasswordFieldConfirmarContrasena().getText())) {
				
				if(p.modificarContrasenaUsuario(u,app1.getPasswordContrasena().getText())) {
					popUpModificarPerfil();
					actualizarDatos(u.getDni());
				}
				else app1.getLabelMensaje().setText("Se ha producido un error");
			}
			else app1.getLabelMensaje().setText("Las contraseñas no coinciden");
				
		}
		else app1.getLabelMensaje().setText("Introduzca correctamente su contraseña actual");
	}
	
	/**
	 * Funcion para ahorrar codigo
	 */
	private void popUpModificarPerfil() {
		popup.getLblAviso().setText("Modificado con éxito");
		popup.getFrmpopup().setBackground(new Color(255, 192, 203));
		popup.getFrmpopup().setVisible(true);
		app1.getCl().show(app1.getOpciones(), "1");
		app1.eliminarContenidoMU();
		
	}
}
