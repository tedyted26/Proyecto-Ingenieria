package control;
import java.awt.EventQueue;

import vista.A0VentanaInicio;
import vista.A1VentanaUsuario;
import vista.A2VentanaAdmin;

/**
 * 
 * @author Teodora Nikoalaeva Nikolova
 *
 */
public class ASistema {
	/**
	 * Inicializa las ventanas y el controlador
	 * @param args 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				A0VentanaInicio vInicio=new A0VentanaInicio();
				A1VentanaUsuario vUsuario=new A1VentanaUsuario();
				A2VentanaAdmin vAdmin=new A2VentanaAdmin();
				Controlador control=new Controlador(vInicio,vUsuario,vAdmin);
				
				try {
					
					vInicio.getFrmLaPacaLee().setVisible(true);
					vInicio.setControlador(control);
					vUsuario.setControlador(control);
					vAdmin.setControlador(control);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
