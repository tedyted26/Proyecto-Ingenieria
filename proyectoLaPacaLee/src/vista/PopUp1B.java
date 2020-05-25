package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.SwingConstants;
import control.Controlador;
import javax.swing.GroupLayout.Alignment;


@SuppressWarnings("serial")
public class PopUp1B extends JDialog{

	private JDialog frmpopup;
	private JButton btnAceptar;
	private JLabel lblAviso;

	public void setControlador(Controlador control) {
		btnAceptar.addActionListener(control);
	}

	public PopUp1B() {
		initialize();
	}

	public void initialize() {

		Toolkit screen=Toolkit.getDefaultToolkit();
		Dimension dimension=screen.getScreenSize();
		frmpopup =new JDialog();
		frmpopup.setTitle("LaPacaLee");
		frmpopup.setSize(dimension.width*16/100,dimension.height*178/1000);
		frmpopup.setLocation(dimension.width*20/48,dimension.height*5/12);
		frmpopup.setVisible(false);
		frmpopup.setResizable(false);
		frmpopup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmpopup.setAlwaysOnTop(true);
		frmpopup.setIconImage(Toolkit.getDefaultToolkit().getImage("./library.png"));
		frmpopup.getContentPane().setBackground(new Color(255, 228, 196));

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(255, 250, 240));
		btnAceptar.setForeground(new Color(220, 20, 60));
		btnAceptar.setFont(new Font("Arial", Font.BOLD, 13));

		lblAviso = new JLabel("Texto");
		lblAviso.setForeground(new Color(220, 20, 60));
		lblAviso.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frmpopup.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
						.addComponent(lblAviso, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(lblAviso, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frmpopup.getContentPane().setLayout(groupLayout);

	}

	public JDialog getFrmpopup() {
		return frmpopup;
	}

	public void setFrmpopup(JDialog popup) {
		this.frmpopup = popup;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JLabel getLblAviso() {
		return lblAviso;
	}

	public void setLblAviso(JLabel lblAviso) {
		this.lblAviso = lblAviso;
	}

}
