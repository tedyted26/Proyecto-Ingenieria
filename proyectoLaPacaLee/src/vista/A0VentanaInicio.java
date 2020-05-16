package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

import control.Controlador;
import model.Usuario;
import net.miginfocom.swing.MigLayout;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class A0VentanaInicio{

	private JFrame frmLaPacaLee;
	
	//PANEL INICIO
	private JPanel panelInicio;
	private JButton btnIniciarSesion;
	private JButton btnCrearCuenta;
	private JLabel lblLapacalee;
	private CardLayout cl;
	private GroupLayout groupLayout;
	
	//PANEL CREAR CUENTA
	private JPanel panelCrearCuenta;
	private JLabel lblCreacionDeCuenta;
	private JButton btnCCSiguiente;
	private JButton btnCCAtras;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldDNI;
	private JTextField textFieldCorreo;
	private JPasswordField passContrasena1;
	private JPasswordField passContrasena2;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDNI;
	private JLabel lblCCCorreo;
	private JLabel lblCCContrasena;
	private JLabel lblContrasena2;
	private JPanel panelMensaje;
	private JLabel lblMensaje;
	private SpringLayout springLayout;

	
	//PANEL INICIO SESION
	private JPanel panelInicioSesion;
	private JLabel lblInicioSesion;
	private Panel marcoDeIncio;
	private JLabel lblCorreo;
	private JTextField textField;
	private JLabel lblContrasena;
	private JPasswordField passwordField;
	private JButton btnAtras;
	private JButton btnSiguiente;
	private JButton btnAdmin;
	private JPanel panelMensajes;
	private JLabel lblAutentificacionDeContrasena;
	private JLabel lblDebeSer_1;
	private JLabel lblDebeSer;

	
	/**
	 * Crea la ventana
	 */
	public A0VentanaInicio() {
		initialize();
	}
	
	
	/**
	 * Método que especifica la clase Controlador como Listener para las acciones de los componentes.
	 * @param control de tipo Controlador
	 */
	public void setControlador(Controlador control) {
		
		//BOTONES INICIO
		btnCrearCuenta.addActionListener(control);
		btnIniciarSesion.addActionListener(control);
		
		//BOTONES CREAR CUENTA
		btnCCSiguiente.addActionListener(control);
		btnCCAtras.addActionListener(control);
		
		//BOTONES INICIAR SESION
		btnSiguiente.addActionListener(control);
		btnAtras.addActionListener(control);
		btnAdmin.addActionListener(control);
	}
	
	
	/**
	 * Devuelve los datos de los campos de la creación de usuario
	 * @return  usuario
	 */
	public Usuario obtenerDatosUsuarioCC() {
		Usuario user;
		String dni = textFieldDNI.getText(); 
		String correo = textFieldCorreo.getText();
		@SuppressWarnings("deprecation")
		String contrasena = passContrasena1.getText();
		@SuppressWarnings("deprecation")
		String contrasena2 = passContrasena2.getText();
		String nombre = textFieldNombre.getText();
		String apellidos = textFieldApellidos.getText();

		if (contrasena.contentEquals(contrasena2)) {
			user = new Usuario(dni, correo, contrasena, nombre, apellidos, false, false);
		}
		else {
			user=null;
		}
		
		return user;
	}
	
	/**
	 * Elimina el contenido de los campos de la creación de usuario
	 */
	public void eliminarContenidoCC() {
		textFieldDNI.setText("");
		textFieldCorreo.setText("");
		passContrasena1.setText("");
		passContrasena2.setText("");
		textFieldNombre.setText("");
		textFieldApellidos.setText("");
	}
	
	/**
	 * Comprueba si los datos en la creación de usuario son correctos
	 * @return true o false 
	 */
	@SuppressWarnings("deprecation")
	public boolean comprobarDatosCC() {
		if (textFieldDNI.getText().equals("")
				||textFieldCorreo.getText().equals("")
				||textFieldNombre.getText().equals("")
				||textFieldApellidos.getText().equals("")
				||passContrasena1.getText().equals("")
				||passContrasena2.getText().equals("")
				) {
			return false;			
		}
		else return true;
	}
	
	/**
	 * Devuelve los datos de los campos de iniciar sesión
	 * @return array de tipo string
	 */
	@SuppressWarnings("deprecation")
	public String[] devolverDatosIS() {
		String[] datos=new String[2];
		datos[0]=textField.getText();
		datos[1]=passwordField.getText();
		return datos;
	}
	
	/**
	 * Elimina el contenido de los campos de iniciar sesion
	 */
	public void eliminarContenidoIS() {
		textField.setText("");
		passwordField.setText("");
		
	}
	
	/**
	 * Inicializa el contenido de la ventana
	 */
	private void initialize() {
		frmLaPacaLee = new JFrame();
		frmLaPacaLee.setTitle("LaPacaLee");
		frmLaPacaLee.getContentPane().setBackground(new Color(255, 250, 240));
		Toolkit screen=Toolkit.getDefaultToolkit();
		Dimension dimension=screen.getScreenSize();
		frmLaPacaLee.setSize(dimension.width*5/12,dimension.height/2);
		frmLaPacaLee.setLocation(dimension.width*7/24,dimension.height/4);
		frmLaPacaLee.setIconImage(Toolkit.getDefaultToolkit().getImage("./library.png"));
		frmLaPacaLee.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmLaPacaLee.setResizable(false);
		frmLaPacaLee.getContentPane().setFont(new Font("Goudy Old Style", Font.PLAIN, 35));
		cl=new CardLayout(0,0);
		frmLaPacaLee.getContentPane().setLayout(cl);
		frmLaPacaLee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		//PANEL INICIO
		panelInicio = new JPanel();
		panelInicio.setBackground(new Color(255, 192, 203));
		frmLaPacaLee.getContentPane().add(panelInicio, "name_73486089282900");
		
		btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnIniciarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnIniciarSesion.setBackground(new Color(255, 250, 240));
		btnIniciarSesion.setForeground(new Color(220, 20, 60));
		btnIniciarSesion.setFont(new Font("Arial", Font.BOLD, 13));
		
		btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnCrearCuenta.setBackground(new Color(255, 250, 240));
		btnCrearCuenta.setFont(new Font("Arial", Font.BOLD, 13));
		btnCrearCuenta.setForeground(new Color(220, 20, 60));
		
		lblLapacalee = new JLabel("LaPacaLee");
		lblLapacalee.setHorizontalAlignment(SwingConstants.CENTER);
		lblLapacalee.setFont(new Font("Goudy Old Style", Font.PLAIN, 35));
		lblLapacalee.setForeground(new Color(220, 20, 60));
		lblLapacalee.setBackground(new Color(255, 192, 203));
		groupLayout = new GroupLayout(panelInicio);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLapacalee, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(btnIniciarSesion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(btnCrearCuenta, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
					.addGap(86))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblLapacalee, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnCrearCuenta)
					.addGap(49)
					.addComponent(btnIniciarSesion)
					.addContainerGap(115, Short.MAX_VALUE))
		);
		panelInicio.setLayout(groupLayout);
		
		//PANEL CREAR CUENTA
		panelCrearCuenta = new JPanel();
		panelCrearCuenta.setBackground(new Color(255, 192, 203));
		frmLaPacaLee.getContentPane().add(panelCrearCuenta, "name_74369261535200");
		
		lblCreacionDeCuenta = new JLabel("Creaci\u00F3n de Cuenta");
		lblCreacionDeCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreacionDeCuenta.setForeground(new Color(220, 20, 60));
		lblCreacionDeCuenta.setFont(new Font("Goudy Old Style", Font.PLAIN, 35));
		lblCreacionDeCuenta.setBackground(new Color(255, 192, 203));
		
		btnCCSiguiente = new JButton("Siguiente \u2192");
		btnCCSiguiente.setForeground(new Color(220, 20, 60));
		btnCCSiguiente.setFont(new Font("Arial", Font.BOLD, 13));
		btnCCSiguiente.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnCCSiguiente.setBackground(new Color(255, 250, 240));
		btnCCSiguiente.setAlignmentX(1.0f);
		
		btnCCAtras = new JButton("\u2190  Atr\u00E1s");
		btnCCAtras.setForeground(new Color(220, 20, 60));
		btnCCAtras.setFont(new Font("Arial", Font.BOLD, 13));
		btnCCAtras.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnCCAtras.setBackground(new Color(255, 250, 240));
		btnCCAtras.setAlignmentX(1.0f);
		
		springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, btnCCSiguiente, 0, SpringLayout.SOUTH, btnCCAtras);
		springLayout.putConstraint(SpringLayout.WEST, lblCreacionDeCuenta, 10, SpringLayout.WEST, panelCrearCuenta);
		springLayout.putConstraint(SpringLayout.EAST, lblCreacionDeCuenta, -10, SpringLayout.EAST, panelCrearCuenta);
		springLayout.putConstraint(SpringLayout.NORTH, btnCCSiguiente, 0, SpringLayout.NORTH, btnCCAtras);
		springLayout.putConstraint(SpringLayout.EAST, btnCCSiguiente, 0, SpringLayout.EAST, lblCreacionDeCuenta);
		springLayout.putConstraint(SpringLayout.NORTH, btnCCAtras, 111, SpringLayout.SOUTH, lblCreacionDeCuenta);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCCAtras, -127, SpringLayout.SOUTH, panelCrearCuenta);
		springLayout.putConstraint(SpringLayout.NORTH, lblCreacionDeCuenta, 12, SpringLayout.NORTH, panelCrearCuenta);
		springLayout.putConstraint(SpringLayout.WEST, btnCCAtras, 10, SpringLayout.WEST, panelCrearCuenta);
		springLayout.putConstraint(SpringLayout.EAST, btnCCAtras, 117, SpringLayout.WEST, panelCrearCuenta);
		panelCrearCuenta.setLayout(springLayout);
		panelCrearCuenta.add(btnCCSiguiente);
		panelCrearCuenta.add(btnCCAtras);
		panelCrearCuenta.add(lblCreacionDeCuenta);
		
		Panel marco = new Panel();
		springLayout.putConstraint(SpringLayout.WEST, btnCCSiguiente, 15, SpringLayout.EAST, marco);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCreacionDeCuenta, -6, SpringLayout.NORTH, marco);
		springLayout.putConstraint(SpringLayout.NORTH, marco, 89, SpringLayout.NORTH, panelCrearCuenta);
		springLayout.putConstraint(SpringLayout.WEST, marco, 135, SpringLayout.WEST, panelCrearCuenta);
		springLayout.putConstraint(SpringLayout.SOUTH, marco, 331, SpringLayout.NORTH, panelCrearCuenta);
		springLayout.putConstraint(SpringLayout.EAST, marco, 431, SpringLayout.WEST, panelCrearCuenta);
		panelCrearCuenta.add(marco);
		marco.setLayout(new MigLayout("", "[124.00px][148px]", "[35px][35px][][35px][35px][][35px][40px]"));
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 13));
		marco.add(lblNombre, "cell 0 0,grow");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		marco.add(textFieldNombre, "cell 1 0,growx,aligny center");
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 13));
		marco.add(lblApellidos, "cell 0 1,grow");
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		marco.add(textFieldApellidos, "cell 1 1,growx,aligny center");
		
		lblDebeSer = new JLabel("* Debe tener min 7 cifras y una letra.");
		lblDebeSer.setForeground(new Color(220, 20, 60));
		lblDebeSer.setFont(new Font("Arial", Font.PLAIN, 11));
		marco.add(lblDebeSer, "cell 0 2 2 1,alignx right");
		
		lblDNI = new JLabel("DNI*:");
		lblDNI.setFont(new Font("Arial", Font.BOLD, 13));
		marco.add(lblDNI, "cell 0 3,grow");
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		marco.add(textFieldDNI, "cell 1 3,growx,aligny center");
		
		lblCCCorreo = new JLabel("Correo:");
		lblCCCorreo.setFont(new Font("Arial", Font.BOLD, 13));
		marco.add(lblCCCorreo, "cell 0 4,grow");
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		marco.add(textFieldCorreo, "cell 1 4,growx,aligny center");
		
		lblDebeSer_1 = new JLabel("* Debe ser de 6-50 caracteres.");
		lblDebeSer_1.setForeground(new Color(220, 20, 60));
		lblDebeSer_1.setFont(new Font("Arial", Font.PLAIN, 11));
		marco.add(lblDebeSer_1, "cell 0 5 2 1,alignx right");
		
		lblCCContrasena = new JLabel("Contrase\u00F1a*:");
		lblCCContrasena.setFont(new Font("Arial", Font.BOLD, 13));
		marco.add(lblCCContrasena, "cell 0 6,grow");
		
		passContrasena1 = new JPasswordField();
		passContrasena1.setColumns(2);
		marco.add(passContrasena1, "cell 1 6,growx,aligny center");
		
		lblContrasena2 = new JLabel("Confirma Contrase\u00F1a:");
		lblContrasena2.setFont(new Font("Arial", Font.BOLD, 13));
		marco.add(lblContrasena2, "cell 0 7,grow");
		
		passContrasena2 = new JPasswordField();
		marco.add(passContrasena2, "cell 1 7,growx,aligny center");
		
		panelMensaje = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panelMensaje, 0, SpringLayout.NORTH, lblCreacionDeCuenta);
		springLayout.putConstraint(SpringLayout.WEST, panelMensaje, 0, SpringLayout.WEST, marco);
		springLayout.putConstraint(SpringLayout.SOUTH, panelMensaje, 0, SpringLayout.SOUTH, panelCrearCuenta);
		springLayout.putConstraint(SpringLayout.EAST, panelMensaje, 0, SpringLayout.EAST, marco);
		panelMensaje.setBackground(new Color(255, 192, 203));
		panelCrearCuenta.add(panelMensaje);
		
		lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(new Color(220, 20, 60));
		lblMensaje.setFont(new Font("Arial", Font.PLAIN, 11));
		GroupLayout gl_panelMensaje = new GroupLayout(panelMensaje);
		gl_panelMensaje.setHorizontalGroup(
			gl_panelMensaje.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMensaje.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMensaje, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelMensaje.setVerticalGroup(
			gl_panelMensaje.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMensaje.createSequentialGroup()
					.addGap(63)
					.addComponent(lblMensaje, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(265, Short.MAX_VALUE))
		);
		panelMensaje.setLayout(gl_panelMensaje);
		
		
		//PANEL INICIO SESION
		panelInicioSesion = new JPanel();
		frmLaPacaLee.getContentPane().add(panelInicioSesion, "name_246001625800600");
		panelInicioSesion.setBackground(new Color(255, 192, 203));
		
		lblInicioSesion = new JLabel("Inicio de Sesi\u00F3n");
		lblInicioSesion.setBounds(10, 35, 543, 87);
		lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioSesion.setForeground(new Color(220, 20, 60));
		lblInicioSesion.setFont(new Font("Goudy Old Style", Font.PLAIN, 35));
		lblInicioSesion.setBackground(new Color(255, 153, 153));
		panelInicioSesion.setLayout(null);
		
		panelMensajes = new JPanel();
		panelMensajes.setBounds(136, 117, 290, 24);
		panelInicioSesion.add(panelMensajes);
		panelMensajes.setBackground(new Color(255, 192, 203));
		panelMensajes.setBorder(null);
		panelMensajes.setForeground(new Color(216, 191, 216));
		
		lblAutentificacionDeContrasena = new JLabel("");
		lblAutentificacionDeContrasena.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAutentificacionDeContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutentificacionDeContrasena.setForeground(new Color(220, 20, 60));
		lblAutentificacionDeContrasena.setFont(new Font("Arial", Font.PLAIN, 11));
		panelMensajes.add(lblAutentificacionDeContrasena);
		panelInicioSesion.add(lblInicioSesion);
		
		btnAtras = new JButton("\u2190  Atr\u00E1s");
		btnAtras.setForeground(new Color(220, 20, 60));
		btnAtras.setFont(new Font("Arial", Font.BOLD, 13));
		btnAtras.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnAtras.setBackground(new Color(255, 250, 240));
		btnAtras.setAlignmentX(1.0f);
		btnAtras.setBounds(10, 194, 107, 34);
		panelInicioSesion.add(btnAtras);
		
		btnSiguiente = new JButton("Siguiente \u2192");
		btnSiguiente.setForeground(new Color(220, 20, 60));
		btnSiguiente.setFont(new Font("Arial", Font.BOLD, 13));
		btnSiguiente.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnSiguiente.setBackground(new Color(255, 250, 240));
		btnSiguiente.setAlignmentX(1.0f);
		btnSiguiente.setBounds(446, 194, 107, 34);
		panelInicioSesion.add(btnSiguiente);
		
		btnAdmin = new JButton("Iniciar como administrador");
		btnAdmin.setForeground(new Color(220, 20, 60));
		btnAdmin.setFont(new Font("Arial", Font.BOLD, 13));
		btnAdmin.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnAdmin.setBackground(new Color(255, 250, 240));
		btnAdmin.setAlignmentX(1.0f);
		btnAdmin.setBounds(190, 292, 187, 34);
		panelInicioSesion.add(btnAdmin);
		
		marcoDeIncio = new Panel();
		marcoDeIncio.setBounds(136, 128, 290, 148);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Arial", Font.BOLD, 13));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setColumns(10);
		
		lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setFont(new Font("Arial", Font.BOLD, 13));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordField.setColumns(2);
		GroupLayout gl_marcoDeIncio = new GroupLayout(marcoDeIncio);
		gl_marcoDeIncio.setHorizontalGroup(
			gl_marcoDeIncio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_marcoDeIncio.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_marcoDeIncio.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_marcoDeIncio.createSequentialGroup()
							.addComponent(lblCorreo)
							.addGap(68)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_marcoDeIncio.createSequentialGroup()
							.addComponent(lblContrasena)
							.addGap(39)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))))
		);
		gl_marcoDeIncio.setVerticalGroup(
			gl_marcoDeIncio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_marcoDeIncio.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_marcoDeIncio.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_marcoDeIncio.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCorreo))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_marcoDeIncio.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_marcoDeIncio.createSequentialGroup()
							.addGap(2)
							.addComponent(lblContrasena))
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		marcoDeIncio.setLayout(gl_marcoDeIncio);
		panelInicioSesion.add(marcoDeIncio);
		cl.addLayoutComponent(panelInicio, "1");
		cl.addLayoutComponent(panelCrearCuenta, "2");
		cl.addLayoutComponent(panelInicioSesion, "3");
	}

	
	//GETTERS Y SETTERS
	public JFrame getFrmLaPacaLee() {
		return frmLaPacaLee;
	}
	public void setFrmLaPacaLee(JFrame frmLaPacaLee) {
		this.frmLaPacaLee = frmLaPacaLee;
	}
	public JPanel getPanelInicio() {
		return panelInicio;
	}
	public void setPanelInicio(JPanel panelInicio) {
		this.panelInicio = panelInicio;
	}
	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}
	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}
	public JButton getBtnCrearCuenta() {
		return btnCrearCuenta;
	}
	public void setBtnCrearCuenta(JButton btnCrearCuenta) {
		this.btnCrearCuenta = btnCrearCuenta;
	}
	public JLabel getLblLapacalee() {
		return lblLapacalee;
	}
	public void setLblLapacalee(JLabel lblLapacalee) {
		this.lblLapacalee = lblLapacalee;
	}
	public JPanel getPanelCrearCuenta() {
		return panelCrearCuenta;
	}
	public void setPanelCrearCuenta(JPanel panelCrearCuenta) {
		this.panelCrearCuenta = panelCrearCuenta;
	}
	public JLabel getLblCreacionDeCuenta() {
		return lblCreacionDeCuenta;
	}
	public void setLblCreacionDeCuenta(JLabel lblCreacionDeCuenta) {
		this.lblCreacionDeCuenta = lblCreacionDeCuenta;
	}
	public JButton getBtnCCSiguiente() {
		return btnCCSiguiente;
	}
	public void setBtnCCSiguiente(JButton btnCCSiguiente) {
		this.btnCCSiguiente = btnCCSiguiente;
	}
	public JButton getBtnCCAtras() {
		return btnCCAtras;
	}
	public void setBtnCCAtras(JButton btnCCAtras) {
		this.btnCCAtras = btnCCAtras;
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

	public JTextField getTextFieldDNI() {
		return textFieldDNI;
	}

	public void setTextFieldDNI(JTextField textFieldDNI) {
		this.textFieldDNI = textFieldDNI;
	}

	public JTextField getTextFieldCorreo() {
		return textFieldCorreo;
	}

	public void setTextFieldCorreo(JTextField textFieldCorreo) {
		this.textFieldCorreo = textFieldCorreo;
	}

	public JPasswordField getPassContrasena1() {
		return passContrasena1;
	}

	public void setPassContrasena1(JPasswordField passContrasena1) {
		this.passContrasena1 = passContrasena1;
	}

	public JPasswordField getPassContrasena2() {
		return passContrasena2;
	}

	public void setPassContrasena2(JPasswordField passContrasena2) {
		this.passContrasena2 = passContrasena2;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblApellidos() {
		return lblApellidos;
	}

	public void setLblApellidos(JLabel lblApellidos) {
		this.lblApellidos = lblApellidos;
	}

	public JLabel getLblDNI() {
		return lblDNI;
	}

	public void setLblDNI(JLabel lblDNI) {
		this.lblDNI = lblDNI;
	}

	public JLabel getLblCCCorreo() {
		return lblCCCorreo;
	}

	public void setLblCCCorreo(JLabel lblCCCorreo) {
		this.lblCCCorreo = lblCCCorreo;
	}

	public JLabel getLblCCContrasena() {
		return lblCCContrasena;
	}

	public void setLblCCContrasena(JLabel lblCCContrasena) {
		this.lblCCContrasena = lblCCContrasena;
	}

	public JLabel getLblContrasena2() {
		return lblContrasena2;
	}

	public void setLblContrasena2(JLabel lblContrasena2) {
		this.lblContrasena2 = lblContrasena2;
	}

	public JPanel getPanelMensaje() {
		return panelMensaje;
	}

	public void setPanelMensaje(JPanel panelMensaje) {
		this.panelMensaje = panelMensaje;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public void setLblMensaje(JLabel lblMensaje) {
		this.lblMensaje = lblMensaje;
	}

	public JPanel getPanelInicioSesion() {
		return panelInicioSesion;
	}

	public void setPanelInicioSesion(JPanel panelInicioSesion) {
		this.panelInicioSesion = panelInicioSesion;
	}

	public JLabel getLblInicioSesion() {
		return lblInicioSesion;
	}

	public void setLblInicioSesion(JLabel lblInicioSesion) {
		this.lblInicioSesion = lblInicioSesion;
	}

	public Panel getMarcoDeIncio() {
		return marcoDeIncio;
	}

	public void setMarcoDeIncio(Panel marcoDeIncio) {
		this.marcoDeIncio = marcoDeIncio;
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JLabel getLblContrasena() {
		return lblContrasena;
	}

	public void setLblContrasena(JLabel lblContrasena) {
		this.lblContrasena = lblContrasena;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	public void setBtnAtras(JButton btnAtras) {
		this.btnAtras = btnAtras;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}

	public JButton getBtnAdmin() {
		return btnAdmin;
	}

	public void setBtnAdmin(JButton btnAdmin) {
		this.btnAdmin = btnAdmin;
	}

	public JPanel getPanelMensajes() {
		return panelMensajes;
	}

	public void setPanelMensajes(JPanel panelMensajes) {
		this.panelMensajes = panelMensajes;
	}

	public JLabel getLblAutentificacionDeContrasena() {
		return lblAutentificacionDeContrasena;
	}

	public void setLblAutentificacionDeContrasena(JLabel lblAutentificacionDeContrasena) {
		this.lblAutentificacionDeContrasena = lblAutentificacionDeContrasena;
	}
	public CardLayout getCl() {
		return cl;
	}
	public void setCl(CardLayout cl) {
		this.cl = cl;
	}	

}
