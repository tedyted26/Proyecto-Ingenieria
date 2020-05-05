import java.awt.EventQueue;
import control.Controlador;
import vista.A0VentanaInicio;
import vista.A1VentanaUsuario;

/**
 * 
 * @author Teodora Nikoalaeva Nikolova
 *
 */
public class ASistema {
	/**
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				A0VentanaInicio vInicio=new A0VentanaInicio();
				A1VentanaUsuario vUsuario=new A1VentanaUsuario();
				Controlador control=new Controlador(vInicio,vUsuario);
				
				try {
					
					vInicio.getFrmLaPacaLee().setVisible(true);
					vInicio.setControlador(control);
					vUsuario.setControlador(control);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
