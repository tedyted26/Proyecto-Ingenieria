import java.awt.EventQueue;
import control.Controlador;
import vista.A0VentanaInicio;
import vista.A1VentanaUsuario;

public class ASistema {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				A0VentanaInicio aa=new A0VentanaInicio();
				A1VentanaUsuario aaa=new A1VentanaUsuario();
				Controlador control=new Controlador(aa,aaa);
				
				try {
					
					aa.getFrmLaPacaLee().setVisible(true);
					aa.setControlador(control);
					aaa.setControlador(control);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
