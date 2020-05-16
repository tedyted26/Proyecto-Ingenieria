package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import control.Controlador;
import javax.swing.SpringLayout;

/**
 * Plantilla de Pop up de 2 botones: si y no
 * @author Teodora Nikolaeva
 *
 */
public class PopUp2B {

	private JDialog frmpopup;
	private JButton btnSi;
	private JButton btnNo;
	private JLabel lblAviso;

	public void setControlador(Controlador control) {
		btnSi.addActionListener(control);
		btnNo.addActionListener(control);
	}

	public PopUp2B() {
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

		btnSi = new JButton("Si");
		btnSi.setBackground(new Color(255, 250, 240));
		btnSi.setForeground(new Color(220, 20, 60));
		btnSi.setFont(new Font("Arial", Font.BOLD, 13));

		lblAviso = new JLabel("Texto");
		lblAviso.setForeground(new Color(220, 20, 60));
		lblAviso.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnNo = new JButton("No");
		btnNo.setForeground(new Color(220, 20, 60));
		btnNo.setFont(new Font("Arial", Font.BOLD, 13));
		btnNo.setBackground(new Color(255, 250, 240));
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, lblAviso, 26, SpringLayout.NORTH, frmpopup.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblAviso, 10, SpringLayout.WEST, frmpopup.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAviso, 61, SpringLayout.NORTH, frmpopup.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblAviso, 202, SpringLayout.WEST, frmpopup.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnNo, 72, SpringLayout.NORTH, frmpopup.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNo, 108, SpringLayout.WEST, frmpopup.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNo, 96, SpringLayout.NORTH, frmpopup.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNo, 202, SpringLayout.WEST, frmpopup.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnSi, 72, SpringLayout.NORTH, frmpopup.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnSi, 10, SpringLayout.WEST, frmpopup.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnSi, 96, SpringLayout.NORTH, frmpopup.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnSi, 102, SpringLayout.WEST, frmpopup.getContentPane());
		frmpopup.getContentPane().setLayout(springLayout);
		frmpopup.getContentPane().add(btnSi);
		frmpopup.getContentPane().add(btnNo);
		frmpopup.getContentPane().add(lblAviso);

	}

	public JDialog getFrmpopup() {
		return frmpopup;
	}

	public void setFrmpopup(JDialog frmpopup) {
		this.frmpopup = frmpopup;
	}

	public JButton getBtnSi() {
		return btnSi;
	}

	public void setBtnSi(JButton btnSi) {
		this.btnSi = btnSi;
	}

	public JButton getBtnNo() {
		return btnNo;
	}

	public void setBtnNo(JButton btnNo) {
		this.btnNo = btnNo;
	}

	public JLabel getLblAviso() {
		return lblAviso;
	}

	public void setLblAviso(JLabel lblAviso) {
		this.lblAviso = lblAviso;
	}
	
}
