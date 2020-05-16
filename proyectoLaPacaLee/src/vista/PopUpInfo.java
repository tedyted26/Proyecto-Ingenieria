package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class PopUpInfo {

	private JDialog frmpopup;
	/**
	 * Create the application.
	 */
	public PopUpInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Toolkit screen=Toolkit.getDefaultToolkit();
		Dimension dimension=screen.getScreenSize();
		frmpopup =new JDialog();
		frmpopup.setTitle("LaPacaLee");
		frmpopup.setSize(dimension.width*16/100,dimension.height/2);
		frmpopup.setLocation(dimension.width*20/48,dimension.height/4);
		frmpopup.setVisible(false);
		frmpopup.setResizable(false);
		frmpopup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmpopup.setAlwaysOnTop(true);
		frmpopup.setIconImage(Toolkit.getDefaultToolkit().getImage("./library.png"));
		frmpopup.getContentPane().setBackground(new Color(255, 228, 196));
	}

}
