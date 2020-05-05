package control;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import accesoDB.PersistenciaDatos;
import model.Usuario;
import vista.A0VentanaInicio;
import vista.A1VentanaUsuario;

public class Controlador implements ActionListener{

	private PersistenciaDatos p;
	
	private A0VentanaInicio app0;
	private A1VentanaUsuario app1;
	
	public Controlador(A0VentanaInicio app0, A1VentanaUsuario app1) {
		this.app0=app0;
		this.app1=app1;
		this.p=new PersistenciaDatos();
	}

	public void actionPerformed(ActionEvent ev) {
		Object fuente = ev.getSource();
		Container parent = app0.getFrmLaPacaLee().getContentPane();
		
		
		//PANEL INICIO
		if (fuente.equals(app0.getBtnCrearCuenta())) {
			app0.getCl().show(parent, "2");
		}
		else if(fuente.equals(app0.getBtnIniciarSesion())) {
			app0.getCl().show(parent, "3");
		}
		
		
		//PANEL CREACION DE CUENTA
		else if(fuente.equals(app0.getBtnCCAtras())) {
			app0.eliminarContenidoCC();
			app0.getCl().show(parent, "1");

		}
		else if(fuente.equals(app0.getBtnCCSiguiente())) {
			
			//TODO COMPROBAR QUE EL DNI Y EL CORREO SON UNICOS Y CONTROLAR ERRORES (SI EXISTE USUARIO)
			//TODO COMPROBAR FORMATO DEL CORREO Y FORMATO DEL DNI(8N Y 1L O 7N Y 2L)
			//TODO CONTRASEÑA FORMATO DE MÁS DE X CARACTERES
			
			Usuario user=app0.obtenerDatosUsuarioCC();
			try{//creacion de usuario
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
			app0.getCl().show(parent, "1");
			app0.eliminarContenidoCC();
			app0.getExitoOperacion().setVisible(false);
		}
		
		
		//PANEL INICIO DE SESION
		else if(fuente.equals(app0.getBtnAtras())) {
			app0.eliminarContenidoIS();
			app0.getCl().show(parent, "1");
		}
		else if(fuente.equals(app0.getBtnSiguiente())) {
			//inicio de sesion normal
			String[] datos=app0.devolverDatosIS();

			String correo=datos[0];
			String contrasena=datos[1];

			Usuario u=p.consultarUsuario(correo);
			
			if(u==null) {
				app0.getLblAutentificacionDeContrasena().setText(("Correo inexistente"));
			
			}else if (u.isAdmin()==false&&contrasena.equals(u.getContrasena())) {
				app0.getFrmLaPacaLee().setVisible(false);
				app1.getFrmLapacalee().setVisible(true);
			}
			else app0.getLblAutentificacionDeContrasena().setText(("Contraseña incorrecta"));
		}		
		else if(fuente.equals(app0.getBtnAdmin())) {

			String[] datos=app0.devolverDatosIS();

			String correo=datos[0];
			String contrasena=datos[1];

			Usuario u=p.consultarUsuario(correo);
			if (u==null) {
				app0.getLblAutentificacionDeContrasena().setText(("Correo inexistente"));
			}else if(u.isAdmin()&&contrasena.equals(u.getContrasena())) {
				app0.getFrmLaPacaLee().setVisible(false);
				app1.getFrmLapacalee().setVisible(true);
			}else app0.getLblAutentificacionDeContrasena().setText(("Correo o contraseña incorrectos"));	
		}
	}
}
