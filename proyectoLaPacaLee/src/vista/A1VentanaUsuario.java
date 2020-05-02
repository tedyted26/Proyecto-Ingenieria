package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;

import control.Controlador;

import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class A1VentanaUsuario {

	private JFrame frmLapacalee;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldCorreo;
	private JTextField textFieldDNI;
	private JTabbedPane tabbedPane;
	private JLayeredPane inicio;
	private JPanel panel_1;
	private JLabel lblPerfil;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblCorreoElectrnico;
	private JLabel lblDni;
	private JPanel panel;
	private JPanel panel_3;
	private JLabel lblLibrosPosesion;
	private JPanel panel_2;
	private JLabel lblLibrosLedos;
	private JLayeredPane buscador;
	private JLayeredPane opciones;
	private JPanel menuOpciones;
	private JButton btnInformacinDeContacto;
	private JButton btnEliminarCuenta;
	private JButton btnCerrarSesin;
	private JButton btnSalir;
	private JButton btnModificarPerfil;
	
	public A1VentanaUsuario() {
		initialize();
	}
	
	public void setControlador(Controlador control) {
		btnInformacinDeContacto.addActionListener(control);
		btnEliminarCuenta.addActionListener(control);
		btnCerrarSesin.addActionListener(control);
		btnSalir.addActionListener(control);
		btnModificarPerfil.addActionListener(control);
	}
	
	
	private void initialize() {
		frmLapacalee = new JFrame();
		frmLapacalee.setTitle("LaPacaLee");
		Toolkit screen=Toolkit.getDefaultToolkit();
		Dimension dimension=screen.getScreenSize();
		frmLapacalee.setSize(dimension.width*5/12,dimension.height/2);
		frmLapacalee.setLocation(dimension.width*7/24,dimension.height/4);
		frmLapacalee.setIconImage(Toolkit.getDefaultToolkit().getImage("./library.png"));
		frmLapacalee.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmLapacalee.setResizable(false);
		frmLapacalee.getContentPane().setFont(new Font("Arial", Font.PLAIN, 14));
		frmLapacalee.getContentPane().setBackground(new Color(240, 128, 128));
		frmLapacalee.getContentPane().setLayout(new BoxLayout(frmLapacalee.getContentPane(), BoxLayout.X_AXIS));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setForeground(new Color(220, 20, 60));
		tabbedPane.setFont(new Font("Arial", Font.BOLD, 12));
		tabbedPane.setBackground(new Color(255, 255, 255));
		frmLapacalee.getContentPane().add(tabbedPane);
		
		inicio = new JLayeredPane();
		inicio.setOpaque(true);
		inicio.setForeground(new Color(240, 230, 140));
		inicio.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		inicio.setBackground(new Color(240, 230, 140));
		tabbedPane.addTab("Inicio", null, inicio, null);
		inicio.setLayout(new MigLayout("", "[50%][50%]", "[grow]"));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(220, 20, 60), 2));
		inicio.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new MigLayout("", "[69px,center][grow]", "[16%][21%][21%][21%][21%]"));
		
		lblPerfil = new JLabel("Perfil");
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setForeground(new Color(220, 20, 60));
		lblPerfil.setFont(new Font("Viner Hand ITC", Font.PLAIN, 26));
		lblPerfil.setBackground(new Color(255, 192, 203));
		panel_1.add(lblPerfil, "cell 0 0,alignx left,aligny top");
		
		lblNombre = new JLabel("Nombre");
		panel_1.add(lblNombre, "cell 0 1");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setToolTipText("");
		panel_1.add(textFieldNombre, "cell 1 1,growx");
		textFieldNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		panel_1.add(lblApellidos, "cell 0 2");
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setEnabled(false);
		textFieldApellidos.setEditable(false);
		panel_1.add(textFieldApellidos, "cell 1 2,growx");
		textFieldApellidos.setColumns(10);
		
		lblCorreoElectrnico = new JLabel("Correo Electr\u00F3nico");
		panel_1.add(lblCorreoElectrnico, "cell 0 3");
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setEditable(false);
		textFieldCorreo.setEnabled(false);
		panel_1.add(textFieldCorreo, "cell 1 3,growx");
		textFieldCorreo.setColumns(10);
		
		lblDni = new JLabel("DNI");
		panel_1.add(lblDni, "cell 0 4");
		
		textFieldDNI = new JTextField();
		textFieldDNI.setEditable(false);
		textFieldDNI.setEnabled(false);
		panel_1.add(textFieldDNI, "cell 1 4,growx");
		textFieldDNI.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(null);
		inicio.add(panel, "cell 1 0,grow");
		panel.setLayout(new MigLayout("", "[grow]", "[grow][grow]"));
		
		panel_3 = new JPanel();
		panel.add(panel_3, "cell 0 0,grow");
		panel_3.setLayout(new MigLayout("", "[]", "[]"));
		
		lblLibrosPosesion = new JLabel("Libros en posesi\u00F3n");
		lblLibrosPosesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrosPosesion.setForeground(new Color(220, 20, 60));
		lblLibrosPosesion.setFont(new Font("Viner Hand ITC", Font.PLAIN, 26));
		lblLibrosPosesion.setBackground(new Color(255, 192, 203));
		panel_3.add(lblLibrosPosesion, "cell 0 0");
		
		panel_2 = new JPanel();
		panel.add(panel_2, "cell 0 1,grow");
		panel_2.setLayout(new MigLayout("", "[]", "[]"));
		
		lblLibrosLedos = new JLabel("Libros le\u00EDdos");
		lblLibrosLedos.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrosLedos.setForeground(new Color(220, 20, 60));
		lblLibrosLedos.setFont(new Font("Viner Hand ITC", Font.PLAIN, 26));
		lblLibrosLedos.setBackground(new Color(255, 192, 203));
		panel_2.add(lblLibrosLedos, "cell 0 0");
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		
		buscador = new JLayeredPane();
		buscador.setOpaque(true);
		buscador.setBackground(new Color(240, 230, 140));
		buscador.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		tabbedPane.addTab("Buscador", null, buscador, null);
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
		tabbedPane.setEnabledAt(1, true);
		
		opciones = new JLayeredPane();
		opciones.setOpaque(true);
		opciones.setBackground(new Color(240, 230, 140));
		opciones.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		tabbedPane.addTab("Opciones", (Icon) null, opciones, null);
		opciones.setLayout(new MigLayout("", "[200.00][338.00][200.00]", "[grow]"));
		
		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setBorder(new LineBorder(new Color(220, 20, 60), 2));
		opciones.add(panelIzquierda, "cell 0 0,grow");
		GroupLayout gl_panelIzquierda = new GroupLayout(panelIzquierda);
		gl_panelIzquierda.setHorizontalGroup(
			gl_panelIzquierda.createParallelGroup(Alignment.LEADING)
				.addGap(0, 127, Short.MAX_VALUE)
		);
		gl_panelIzquierda.setVerticalGroup(
			gl_panelIzquierda.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
		);
		panelIzquierda.setLayout(gl_panelIzquierda);
		
		menuOpciones = new JPanel();
		menuOpciones.setBackground(new Color(240, 230, 140));
		menuOpciones.setBorder(null);
		opciones.add(menuOpciones, "cell 1 0,grow");
		
		btnInformacinDeContacto = new JButton("Informaci\u00F3n de Contacto");
		btnInformacinDeContacto.setForeground(new Color(220, 20, 60));
		btnInformacinDeContacto.setFont(new Font("Arial", Font.BOLD, 13));
		btnInformacinDeContacto.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnInformacinDeContacto.setBackground(new Color(255, 250, 240));
		btnInformacinDeContacto.setAlignmentX(1.0f);
		
		btnEliminarCuenta = new JButton("Eliminar Cuenta");
		btnEliminarCuenta.setForeground(new Color(220, 20, 60));
		btnEliminarCuenta.setFont(new Font("Arial", Font.BOLD, 13));
		btnEliminarCuenta.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnEliminarCuenta.setBackground(new Color(255, 250, 240));
		btnEliminarCuenta.setAlignmentX(1.0f);
		
		btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setForeground(new Color(220, 20, 60));
		btnCerrarSesin.setFont(new Font("Arial", Font.BOLD, 13));
		btnCerrarSesin.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnCerrarSesin.setBackground(new Color(255, 250, 240));
		btnCerrarSesin.setAlignmentX(1.0f);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(220, 20, 60));
		btnSalir.setFont(new Font("Arial", Font.BOLD, 13));
		btnSalir.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnSalir.setBackground(new Color(255, 250, 240));
		btnSalir.setAlignmentX(1.0f);
		
		btnModificarPerfil = new JButton("Modificar Perfil");
		btnModificarPerfil.setForeground(new Color(220, 20, 60));
		btnModificarPerfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificarPerfil.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnModificarPerfil.setBackground(new Color(255, 250, 240));
		btnModificarPerfil.setAlignmentX(1.0f);
		menuOpciones.setLayout(new MigLayout("", "[229px,grow,center]", "[20%][20%][20%][20%][20%]"));
		menuOpciones.add(btnInformacinDeContacto, "cell 0 1,grow");
		menuOpciones.add(btnEliminarCuenta, "cell 0 2,grow");
		menuOpciones.add(btnCerrarSesin, "cell 0 3,grow");
		menuOpciones.add(btnSalir, "cell 0 4,grow");
		menuOpciones.add(btnModificarPerfil, "cell 0 0,grow");
		
		JPanel panelDerecha = new JPanel();
		panelDerecha.setBorder(new LineBorder(new Color(220, 20, 60), 2));
		opciones.add(panelDerecha, "cell 2 0,grow");
		GroupLayout gl_panelDerecha = new GroupLayout(panelDerecha);
		gl_panelDerecha.setHorizontalGroup(
			gl_panelDerecha.createParallelGroup(Alignment.LEADING)
				.addGap(0, 127, Short.MAX_VALUE)
		);
		gl_panelDerecha.setVerticalGroup(
			gl_panelDerecha.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
		);
		panelDerecha.setLayout(gl_panelDerecha);
		tabbedPane.setBackgroundAt(2, new Color(255, 255, 255));
		tabbedPane.setEnabledAt(2, true);
		frmLapacalee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JFrame getFrmLapacalee() {
		return frmLapacalee;
	}
	
	public void setFrmLapacalee(JFrame frmLapacalee) {
		this.frmLapacalee = frmLapacalee;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public JTextField getTextFieldApellidos() {
		return textFieldApellidos;
	}

	public void setTextFieldApellidos(JTextField textFieldApellidos) {
		this.textFieldApellidos = textFieldApellidos;
	}

	public JTextField getTextFieldCorreo() {
		return textFieldCorreo;
	}

	public void setTextFieldCorreo(JTextField textFieldCorreo) {
		this.textFieldCorreo = textFieldCorreo;
	}

	public JTextField getTextFieldDNI() {
		return textFieldDNI;
	}

	public void setTextFieldDNI(JTextField textFieldDNI) {
		this.textFieldDNI = textFieldDNI;
	}

}
