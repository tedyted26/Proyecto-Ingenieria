
import java.awt.EventQueue;

import vista.PruebaExito;

public class Prueba {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PersistenciaDatos p=new PersistenciaDatos();
//		p.eliminarUsuario(p.consultarUsuario(""));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				PruebaExito p = new PruebaExito();
				try {
					p.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		
	}
}
