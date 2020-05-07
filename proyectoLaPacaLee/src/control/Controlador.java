package control;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import accesoDB.PersistenciaDatos;
import model.Usuario;
import vista.A0VentanaInicio;
import vista.A1VentanaUsuario;
import vista.A2VentanaAdmin;

public class Controlador implements ActionListener{

	private PersistenciaDatos p;
	
	private A0VentanaInicio app0;
	private A1VentanaUsuario app1;
	private A2VentanaAdmin app2;
	
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
		Container parent3 = app2.getOpciones();
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
			
			Usuario user=app0.obtenerDatosUsuarioCC();
			try{
				if(app0.comprobarDatosCC()) {
					p.crearUsuario(user);
					app0.getExitoOperacion().setVisible(true);
				}
				else app0.getLblMensaje().setText("Debe completar los campos");			
			}catch (Exception e) {
				app0.getLblMensaje().setText("Las contraseñas no coinciden");
			}
		}
		
		
		//POP UP DE CREAR CUENTA
		else if(fuente.equals(app0.getBtnAceptar())) {
			app0.getCl().show(parent0, "1");
			app0.eliminarContenidoCC();
			app0.getExitoOperacion().setVisible(false);
		}
		
		
		//PANEL INICIO DE SESION
		else if(fuente.equals(app0.getBtnAtras())) {
			app0.eliminarContenidoIS();
			app0.getCl().show(parent0, "1");
		}
		
		//inicio de sesion normal
		else if(fuente.equals(app0.getBtnSiguiente())) {
			iniciarSesion(app0.getBtnSiguiente());
		}
		
		//inicio de sesion de administrador
		else if(fuente.equals(app0.getBtnAdmin())) {
			iniciarSesion(app0.getBtnAdmin());	
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
			//TODO cambiar el estado del libro
		}
		else if(fuente.equals(app1.getBtnModificarPerfil())) {
			app1.getCl().show(parent1, "2");
		}
		else if(fuente.equals(app1.getBtnCancelar())) {
			app1.getCl().show(parent1, "1");
			//TODO eliminar contenido de los campos
		}
		else if(fuente.equals(app1.getBtnConfirmarModificaciones())) {
			//TODO JDialog de modificaciones hechas con exito
		}
		else if(fuente.equals(app1.getBtnInformacionYContacto())) {
			app1.getCl().show(parent1, "3");
		}
		else if(fuente.equals(app1.getBtncontactanos())) {
			
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
			//TODO eliminar datos en la bbdd
			//TODO JDialog mostrando que se ha hecho el cambio con exito
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
		
		else if(fuente.equals(app2.getBtnBuscar())) {
			//TODO buscador
		}
		else if(fuente.equals(app2.getBtnAnadir())) {
			app2.getCb().show(parent2, "2");
		}
		else if(fuente.equals(app2.getBtnCancelarAnadir())) {
			app2.getCb().show(parent2, "1");
			//TODO borrar datos de los campos
		}
		else if(fuente.equals(app2.getBtnConfirmar())) {
			//TODO JDialog con confirmacion
			//TODO borrar datos de los campos al salir
			//TODO añadir libro a la base de datos
//			app2.getCb().show(parent2, "1");
		}
		else if(fuente.equals(app2.getBtnDetalles())) {
			//TODO JDialog con los detalles
		}
		else if(fuente.equals(app2.getBtnEditar())) {
			app2.getCb().show(parent2, "3");
		}
		else if(fuente.equals(app2.getBtnCancelarEditar())) {
			app2.getCb().show(parent2, "1");
			//TODO borrar datos de los campos
		}
		else if(fuente.equals(app2.getBtnConfirmarCambios())) {
			//TODO JDialog con confirmacion
//			app2.getCb().show(parent2, "1");
		}
		else if(fuente.equals(app2.getBtnEliminar())) {
			//TODO JDialog con confirmacion
		}
		else if(fuente.equals(app2.getBtnInformacion())) {
			app2.getCo().show(parent3, "2");
		}
		else if(fuente.equals(app2.getBtnAtras())) {
			app2.getCo().show(parent3, "1");
		}
		else if(fuente.equals(app2.getBtnEditarInfo())) {
			//TODO edicion del texto
		}
		else if(fuente.equals(app2.getBtncontactanos())) {
			//TODO JDialog con mensajito
		}
		else if(fuente.equals(app2.getBtnCerrarSesion())) {
			cerrarSesion(app2);
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
}
