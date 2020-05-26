package control;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import accesoDB.PersistenciaDatos;
import model.Libro;
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
	private PopUp2B popupDevolverLibro;
	

	/**
	 * Constructor
	 * @param app0 Ventana de inicio de sesion
	 * @param app1 Ventana de uso de usuarios
	 * @param app2 Ventana de uso de administracion
	 */
	public Controlador(A0VentanaInicio app0, A1VentanaUsuario app1, A2VentanaAdmin app2) {
		this.app0=app0;
		this.app1=app1;
		this.app2=app2;
		this.p=new PersistenciaDatos();
		
		popup = new PopUp1B();
		popup.setControlador(this);
		
		popupPedirPrestado = new PopUp2B();
		popupPedirPrestado.setControlador(this);
		
		popupBloquearUsuario = new PopUp2B();
		popupBloquearUsuario.setControlador(this);
		
		popupEliminarUsuario = new PopUp2B();
		popupEliminarUsuario.setControlador(this);
		
		popupEliminarLibro = new PopUp2B();
		popupEliminarLibro.setControlador(this);
		
		popupInfoLibro = new PopUpInfo();
		
		popupDevolverLibro = new PopUp2B();
		popupDevolverLibro.setControlador(this);
		
	}
		
	/**
	 * Método que dicta las acciones de los componentes de las ventanas inicializadas
	 * @param ev Evento que recoge la clase al implementar el ActionListener
	 */
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent ev) {
		//variables para simplificar
		Object fuente = ev.getSource();
		Container parent0 = app0.getFrmLaPacaLee().getContentPane();
		Container parent1 = app1.getOpciones();
		Container parent2 = app2.getBiblioteca();
		Container parent3 = app2.getUsuarios();
		Container parent4 = app2.getOpciones();
		
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
			crearUsuario(app0);
		}
		
		
		//POP UP 
		else if(fuente.equals(popup.getBtnAceptar())) {
			popup.getFrmpopup().setVisible(false);
			popup.getFrmpopup().getContentPane().setBackground(new Color(255, 228, 196));
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
			app1.refrescarTablas();
		}
		
			//inicio de sesion de administrador
		else if(fuente.equals(app0.getBtnAdmin())) {
			iniciarSesion(app0.getBtnAdmin());
			rellenarDatosU(app0.getBtnAdmin());
			app2.refrescarTablas("usuario");
			app2.refrescarTablas("libro");
		}
		
		/**
		 * Acciones de la ventana de usuario (inicio, biblioteca y opciones)
		 */
		else if(fuente.equals(app1.getBtnDevolver())) {
			try{
				app1.getListaLibros().getSelectedValue();
				popupDevolverLibro.getLblAviso().setText("¿Devolver este libro?");
				popupDevolverLibro.getFrmpopup().setVisible(true);
			}catch(Exception e) {
				popup.getLblAviso().setText("No has seleccionado nada");
				popup.getFrmpopup().setVisible(true);
			}

		}
		//popup
		else if(fuente.equals(popupDevolverLibro.getBtnNo())) {
			popupDevolverLibro.getFrmpopup().setVisible(false);
		}
		else if(fuente.equals(popupDevolverLibro.getBtnSi())){
			String titulo=(String)app1.getListaLibros().getSelectedValue();
			String codigo=p.consultarLibroTitulo(titulo).getCodigo();
			if (p.devolverLibro(codigo)) {
				popup.getLblAviso().setText("¡Hecho!");
				popup.getFrmpopup().setVisible(true);
				app1.refrescarTablas();
				Usuario u=getUsuarioIS();
				app1.getListaLibros().setModel(p.cargarLista(u.getDni()));
				popupDevolverLibro.getFrmpopup().setVisible(false);
			}
		}
		
		//biblioteca
		else if(fuente.equals(app1.getBtnBuscar())) {
			String texto=app1.getTextFieldBuscar().getText();
			boolean buscarDisponibles=app1.getChckbxDisponible().isSelected();
			String generoSeleccionado=app1.recogerFiltros();
			if (texto.equals("")&&buscarDisponibles) {
				app1.getTablaLibros().setModel(p.buscarLibrosDisponibles(false));
				app1.preferenciasTamanoTabla();
			}else if (texto.equals("")&&!buscarDisponibles){
				app1.refrescarTablas();
			}else {
				String columna=app1.recogerColumnaFiltro();				
				app1.getTablaLibros().setModel(p.buscarLibro(columna, texto, buscarDisponibles, false));
				app1.preferenciasTamanoTabla();			
			}
		}
		else if(fuente.equals(app1.getBtnVerDetalles())) {
			try {
				int fila=app1.getTablaLibros().getSelectedRow();
				String codigo=(String)app1.getTablaLibros().getValueAt(fila, 4);
				Libro libro=p.consultarLibro(codigo);
				popupInfoLibro.rellenarDatos(libro);
				popupInfoLibro.getFrmpopup().setVisible(true);
			}catch(Exception e) {
				popup.getLblAviso().setText("No has seleccionado nada");
				popup.getFrmpopup().setVisible(true);
			}
		}
		else if(fuente.equals(app1.getBtnPedirPrestado())) {
			
			try{
				app1.getTablaLibros().getSelectedRow();
				popupPedirPrestado.getLblAviso().setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
				popupPedirPrestado.getLblAviso().setText("¿Seguro que quieres este libro?");
				popupPedirPrestado.getFrmpopup().setVisible(true);
			}catch (Exception e) {
				popup.getLblAviso().setText("No has seleccionado nada");
				popup.getFrmpopup().setVisible(true);
			}
			
		}
		
		
		//POP UP
		else if(fuente.equals(popupPedirPrestado.getBtnNo())) {
			popupPedirPrestado.getFrmpopup().setVisible(false);
		}
		
		else if(fuente.equals(popupPedirPrestado.getBtnSi())) {
			int fila=app1.getTablaLibros().getSelectedRow();
			String codigo=(String)app1.getTablaLibros().getValueAt(fila, 4);
			if((int)app1.getTablaLibros().getValueAt(fila, 3)==0) {
				Usuario u=getUsuarioIS();
				p.prestarLibro(codigo, u.getDni());
				popup.getLblAviso().setText("¡Hecho!");
				popup.getFrmpopup().setVisible(true);
				app1.refrescarTablas();
				app1.getListaLibros().setModel(p.cargarLista(u.getDni()));
				popupPedirPrestado.getFrmpopup().setVisible(false);
			}
			else {
				popup.getLblAviso().setText("No disponible");
				popup.getFrmpopup().setVisible(true);
				popupPedirPrestado.getFrmpopup().setVisible(false);
			}
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
			popup.getLblAviso().setText("Correo: admin@admin");
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
			popup.getFrmpopup().setBackground(new Color(255, 192, 203));
			popup.getLblAviso().setText("Eliminado con éxito");
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
			String texto=app2.getTextFieldBuscar().getText();
			boolean buscarDisponibles=app2.getChckbxDisponible().isSelected();
			String generoSeleccionado=app2.recogerFiltrosB();
			if (texto.equals("")&&buscarDisponibles) {
				app2.getTablaLibros().setModel(p.buscarLibrosDisponibles(true));
				app2.preferenciasTamanoTablaLibros();
			}else if (texto.equals("")&&!buscarDisponibles){
				app2.refrescarTablas("libro");
			}else {
				String columna=app2.recogerColumnaFiltroB();				
				app2.getTablaLibros().setModel(p.buscarLibro(columna, texto, buscarDisponibles, true));
				app2.preferenciasTamanoTablaLibros();			
			}
		}
		else if(fuente.equals(app2.getBtnAnadir())) {
			app2.getCb().show(parent2, "2");
		}
		else if(fuente.equals(app2.getBtnCancelarAnadir())) {
			app2.getCb().show(parent2, "1");
			app2.eliminarDatosAnadirLibro();
		}
		else if(fuente.equals(app2.getBtnConfirmar())) {
			crearLibro();
			
		}
		else if(fuente.equals(app2.getBtnDetalles())) {
			try {
				int fila=app2.getTablaLibros().getSelectedRow();
				String codigo=(String)app2.getTablaLibros().getValueAt(fila, 5);
				Libro libro=p.consultarLibro(codigo);
				popupInfoLibro.rellenarDatos(libro);
				popupInfoLibro.getFrmpopup().setVisible(true);
			}catch(Exception e) {
				popup.getLblAviso().setText("No has seleccionado nada");
				popup.getFrmpopup().setVisible(true);
			}
		}
		else if(fuente.equals(app2.getBtnEditar())) {
			try {
				int fila=app2.getTablaLibros().getSelectedRow();
				String codigo=(String)app2.getTablaLibros().getValueAt(fila, 5);
				Libro libro=p.consultarLibro(codigo);
				app2.rellenarDatosLibro(libro);
				app2.getCb().show(parent2, "3");
			}catch(Exception e) {
				popup.getLblAviso().setText("No has seleccionado nada");
				popup.getFrmpopup().setVisible(true);
			}
			
		}
		else if(fuente.equals(app2.getBtnCancelarEditar())) {
			app2.getCb().show(parent2, "1");
			
		}
		else if(fuente.equals(app2.getBtnConfirmarCambios())) {
			try{
				int fila=app2.getTablaLibros().getSelectedRow();
				String codigo=(String)app2.getTablaLibros().getValueAt(fila, 5);
				Libro libro=p.consultarLibro(codigo);
				editarLibro(libro);
				app2.refrescarTablas("libro");
			}catch (Exception e) {
				popup.getLblAviso().setText("No se puede editar");
				popup.getFrmpopup().setVisible(true);
			}
			
			
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
			try {
				int fila=app2.getTablaLibros().getSelectedRow();
				String codigo=(String)app2.getTablaLibros().getValueAt(fila, 5);
				p.devolverLibro(codigo);
				p.eliminarLibro(codigo);
				app2.refrescarTablas("libro");
				popup.getLblAviso().setText("Libro eliminado");
				popup.getFrmpopup().setVisible(true);
				popupEliminarLibro.getFrmpopup().setVisible(false);
				
			}catch(Exception e) {
				System.out.println("No has seleccionado nada");
			}
		}
		
		//USUARIOS
		else if(fuente.equals(app2.getBtnBuscarU())) {
			String texto=app2.getTextFieldBuscarU().getText();
			String filtroSeleccionado=app2.recogerFiltrosB();
			if (texto.equals("")){
				app2.refrescarTablas("usuario");
			}else {
				String columna=app2.recogerColumnaFiltroU();				
				app2.getTablaUsuarios().setModel(p.buscarUsuario(columna, texto));
				app2.preferenciasTamanoTablaLibros();			
			}
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
		
		else if(fuente.equals(app2.getBtnEditarU())) {
			try {
				int fila=app2.getTablaUsuarios().getSelectedRow();
				String dni=(String)app2.getTablaUsuarios().getValueAt(fila, 1);
				Usuario user=p.consultarUsuario(dni);
				if(user.isAdmin()) {
					popup.getLblAviso().setText("No se puede editar");
					popup.getFrmpopup().setVisible(true);
				}else {
					app2.completarCamposEU(user);
					app2.getCu().show(parent3, "3");
				}
			}catch(Exception e) {
				popup.getLblAviso().setText("No has seleccionado nada");
				popup.getFrmpopup().setVisible(true);
			}
			
		}
		else if(fuente.equals(app2.getBtnCancelarEditarU())) {
			app2.getCu().show(parent3, "1");
		}
		else if(fuente.equals(app2.getBtnConfirmarCambiosU())) {
			try {
				int fila=app2.getTablaUsuarios().getSelectedRow();
				String dni=(String)app2.getTablaUsuarios().getValueAt(fila, 1);
				Usuario user=p.consultarUsuario(dni);
				editarUsuario(user);
			}catch (Exception e) {
				popup.getLblAviso().setText("No se ha podido editar");
				popup.getFrmpopup().setVisible(true);
			}
			
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
			try {
				int fila=app2.getTablaUsuarios().getSelectedRow();
				String dni=(String)app2.getTablaUsuarios().getValueAt(fila, 0);
				Usuario u=p.consultarUsuarioDni(dni);
				if(u.isAdmin()||u.isBloqueado()) {
					popup.getLblAviso().setText("No se puede bloquear");
					popup.getFrmpopup().setVisible(true);
					popupEliminarUsuario.getFrmpopup().setVisible(false);
				}else {
					p.bloquearUsuario(dni);
					app2.refrescarTablas("usuario");
					popup.getLblAviso().setText("Usuario bloqueado");
					popup.getFrmpopup().setVisible(true);
					popupBloquearUsuario.getFrmpopup().setVisible(false);
				}
				
			}catch(Exception e) {
				popup.getLblAviso().setText("No has seleccionado nada");
				popup.getFrmpopup().setVisible(true);
			}
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
			try {
				int fila=app2.getTablaUsuarios().getSelectedRow();
				String dni=(String)app2.getTablaUsuarios().getValueAt(fila, 0);
				Usuario u=p.consultarUsuarioDni(dni);
				if(u.isAdmin()) {
					popup.getLblAviso().setText("No se puede eliminar");
					popup.getFrmpopup().setVisible(true);
					popupEliminarUsuario.getFrmpopup().setVisible(false);
				}
				else {
					if(p.eliminarUsuario(dni)) {
					app2.refrescarTablas("usuario");
					popup.getLblAviso().setText("Usuario eliminado");
					popup.getFrmpopup().setVisible(true);
					popupEliminarUsuario.getFrmpopup().setVisible(false);
					}
					else {
						popup.getLblAviso().setText("Debe devolver los libros");
						popup.getFrmpopup().setVisible(true);
						popupEliminarUsuario.getFrmpopup().setVisible(false);
					}
				}

			}catch(Exception e) {
				popup.getLblAviso().setText("No has seleccionado nada");
				popup.getFrmpopup().setVisible(true);
			}
		}
		else if(fuente.equals(app2.getBtnInformacion())) {
			app2.getCo().show(parent4, "2");
		}
		else if(fuente.equals(app2.getBtnAtras())) {
			app2.getTxtpnLapacalee().setEditable(false);
			app1.getTxtpnLapacalee().setText(app2.getTxtpnLapacalee().getText());
			app2.getTxtpnLapacalee().setBackground(new Color(255,228,196));
			app2.getCo().show(parent4, "1");
		}
		else if(fuente.equals(app2.getBtnEditarInfo())) {
			app2.getTxtpnLapacalee().setEditable(true);
			app2.getTxtpnLapacalee().setBackground(new Color(255,255,255));
		}
		else if(fuente.equals(app2.getBtncontactanos())) {
			popup.getLblAviso().setText("Correo: admin@admin");
			popup.getFrmpopup().setVisible(true);
		}
		else if(fuente.equals(app2.getBtnCerrarSesion())) {
			cerrarSesion(app2);
		}
	}
	
	//MÉTODOS RELACIONADOS CON LOS USUARIOS
	
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
			else app0.getLblMensaje().setText("Correo o DNI ya existente");
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
				popup.getLblAviso().setText("Usuario creado con éxito");
				popup.getFrmpopup().setVisible(true);
				app2.eliminarContenidoCC();
				app2.refrescarTablas("usuario");
				app2.getCu().show(app2.getUsuarios(), "1");
				
			}
			else app2.getLblMensaje().setText("Correo o DNI ya existente");
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
			else if(u.isBloqueado()) {
				app0.getLblAutentificacionDeContrasena().setText(("Cuenta bloqueada"));
			}
			else if(boton.equals(app0.getBtnSiguiente())&&u.isAdmin()==false&&contrasena.equals(u.getContrasena())&&!u.isBloqueado()) {
				app0.getFrmLaPacaLee().setVisible(false);
				app1.getFrmLapacalee().setVisible(true);
				app1.reiniciarPaneles();
			}
			else if(boton.equals(app0.getBtnAdmin())&&u.isAdmin()&&contrasena.equals(u.getContrasena())) {
				app0.getFrmLaPacaLee().setVisible(false);
				app2.getFrmLapacalee().setVisible(true);
				app2.reiniciarPaneles();
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
	@SuppressWarnings("unchecked")
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
			//DATOS DE LIBROS EN POSESION
			app1.getListaLibros().setModel(p.cargarLista(u.getDni()));
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
		app1.getListaLibros().setModel(p.cargarLista(dni));
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
		popup.getFrmpopup().setVisible(true);
		app1.getCl().show(app1.getOpciones(), "1");
		app1.eliminarContenidoMU();
		
	}
	
	/**
	 * edita los datos de un usuario seleccionado en la tabla de administracion
	 * @param u seleccionado
	 */
	private void editarUsuario(Usuario u) {
		String[] cambios=app2.obtenerDatosUsuarioEU();
		if (cambios==null) {
			popup.getLblAviso().setText("Rellene los campos");
			popup.getFrmpopup().setVisible(true);
		}
		else {
			String correo=cambios[0];
			String nombre=cambios[1];
			String apellidos=cambios[2];
			String contrasena=cambios[3];
			String contrasenaAdmin=cambios[4];

			if(contrasenaAdmin.equals(getUsuarioIS().getContrasena())) {
				if(!correo.equals(u.getCorreo())) {
					p.editarUsuario(u.getDni(), "correo", correo);
				}
				if(!nombre.equals(u.getNombre())) {
					p.editarUsuario(u.getDni(), "nombre", nombre);
				}
				if(!apellidos.equals(u.getApellidos())) {
					p.editarUsuario(u.getDni(), "apellidos", apellidos);
				}
				if(!contrasena.equals(u.getContrasena())) {
					p.editarUsuario(u.getDni(), "contrasena", contrasena);
				}
				if(u.isBloqueado()&&app2.getChckbxDesbloquear().isSelected()) {
					p.desbloquearUsuario(u.getDni());
				}
				if(!u.isAdmin()&&app2.getChckbxDerechosDeAdministrador().isSelected()) {
					p.covertirAdministrador(u.getDni());
				}
				
				popup.getLblAviso().setText("Cambios realizados");
				popup.getFrmpopup().setVisible(true);
				app2.refrescarTablas("usuario");
				app2.getCu().show(app2.getUsuarios(), "1");
			}
			else {
				popup.getLblAviso().setText("Se necesitan permisos");
				popup.getFrmpopup().setVisible(true);
			}
		}


		
	}


	//MÉTODOS RELACIONADOS CON LOS LIBROS
	/**
	 * llama a la funcion que añade los libros a la base de datos solo si se cumplen una serie de requisitos
	 */
	private void crearLibro() {
		Libro libro=app2.obtenerDatosLibroCL();
		if(libro==null) {
			app2.getLblMensajeAnadirLibro().setText("Datos no rellenados correctamente");
		}
		else if(p.consultarLibro(libro.getCodigo())==null&&p.crearLibro(libro)) {
			popup.getLblAviso().setText("Libro añadido");
			popup.getFrmpopup().setVisible(true);
			app2.eliminarDatosAnadirLibro();
			app2.refrescarTablas("libro");
			app2.getCb().show(app2.getBiblioteca(), "1");

		}
		else app2.getLblMensajeAnadirLibro().setText("Código de libro en uso");
	}
	
	/**
	 * edita un libro seleccionado de la tabla de administracion
	 * @param libro seleccionado
	 */
	private void editarLibro(Libro libro) {
		String[] cambios=app2.obtenerDatosLibroEL();
		String titulo=cambios[0];
		String autor=cambios[1];
		String resumen=cambios[2];
		String genero=cambios[3];
		
		if(!titulo.equals(libro.getTitulo())) {
			p.editarLibro(libro.getCodigo(), "titulo", titulo);
		}
		if(!autor.equals(libro.getAutor())) {
			p.editarLibro(libro.getCodigo(), "autor", autor);
		}
		if(!resumen.equals(libro.getResumen())) {
			p.editarLibro(libro.getCodigo(), "resumen", resumen);
		}
		if(!genero.equals(libro.getGenero())) {
			p.editarLibro(libro.getCodigo(), "genero", genero);
		}
		if(libro.isPrestado()&&app2.getChckbxMarcarComoDevuelto().isSelected()) {
			p.devolverLibro(libro.getCodigo());
		}
		
		popup.getLblAviso().setText("Cambios realizados");
		popup.getFrmpopup().setVisible(true);
		app2.getCb().show(app2.getBiblioteca(), "1");
		
	}

}



