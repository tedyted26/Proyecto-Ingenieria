package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import control.Controlador;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.Scrollbar;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

public class A1VentanaUsuario {

	private JFrame frmLapacalee;
	private JTabbedPane tabbedPane;
	
	
	//PESTAÑA INICIO
	private JLayeredPane inicio;
	//PANEL PERFIL
	private JPanel panelPerfil;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldCorreo;
	private JTextField textFieldDNI;
	private JLabel lblPerfil;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblCorreoElectronico;
	private JLabel lblDni;
	//PANEL LIBROS
	private JPanel panelLibros;
	private JLabel lblLibrosEnPosesion;
	private Scrollbar scrollbarLibros;
	@SuppressWarnings("rawtypes")
	private JList listaLibros;

	
	//PESTAÑA BIBLIOTECA
	private JLayeredPane biblioteca;
	
	
	//PESTAÑA OPCIONES
	private JLayeredPane opciones;
	//PANEL OPCIONES
	private JPanel menuOpciones;
	private JButton btnInformacionYContacto;
	private JButton btnEliminarCuenta;
	private JButton btnCerrarSesion;
	private JButton btnSalir;
	private JButton btnModificarPerfil;
	//PANEL MODIFICAR
	private JPanel panelModificar;
	private JTextField textFieldCorreoActual;
	private JPasswordField passwordFieldContrasenaActual;
	private JTextField textFieldCorreoNuevo;
	private JPasswordField passwordContrasena;
	private JPasswordField passwordFieldConfirmarContrasena;
	private JLabel lblDebeSer;
	private JLabel lblEsNecesario;
	private JLabel lblConfirmarContrasena;
	private JLabel lblCorreoNuevo;
	private JLabel lblContrasenaNueva;
	private JSeparator separator;
	private JButton btnConfirmarModificaciones;
	private JButton btnAtras;
	private JLabel lblContrasena;
	private JLabel lblCorreo;
	private JLabel lblModificacionDePerfil;
	//PANEL INFORMACION
	private JPanel panelInformacion;
	private JLabel lblLapacalee;
	private JLabel lblSobreNosotros;
	private JLabel lblUe;
	private JButton btncontactanos;
	private JTextPane txtpnLapacalee;
	//PANEL ELIMINAR
	private JPanel panelEliminar;
	private JLabel lblCuidado;
	private JLabel lblSeguro;
	private JLabel lblInfo;
	private JButton btnSi;
	private JButton btnNo;
	


	/**
	 * Crea la ventana
	 */
	public A1VentanaUsuario() {
		initialize();
	}
	
	/**
	 * Método que especifica la clase Controlador como Listener para las acciones de los componentes.
	 * @param control
	 */
	public void setControlador(Controlador control) {
		//PESTAÑA OPCIONES
		btnInformacionYContacto.addActionListener(control);
		btnEliminarCuenta.addActionListener(control);
		btnCerrarSesion.addActionListener(control);
		btnSalir.addActionListener(control);
		btnModificarPerfil.addActionListener(control);
	}
	
	/**
	 * Inicializa el contenido de la ventana
	 */
	@SuppressWarnings("rawtypes")
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
		frmLapacalee.getContentPane().setBackground(new Color(255, 192, 203));
		frmLapacalee.getContentPane().setLayout(new BoxLayout(frmLapacalee.getContentPane(), BoxLayout.X_AXIS));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setForeground(new Color(220, 20, 60));
		tabbedPane.setFont(new Font("Arial", Font.BOLD, 12));
		tabbedPane.setBackground(new Color(255, 255, 255));
		frmLapacalee.getContentPane().add(tabbedPane);
		
		//PESTAÑA INICIO
		inicio = new JLayeredPane();
		inicio.setOpaque(true);
		inicio.setForeground(new Color(255, 228, 196));
		inicio.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		inicio.setBackground(new Color(255, 228, 196));
		tabbedPane.addTab("Inicio", null, inicio, null);
		inicio.setLayout(new MigLayout("", "[50%][50%]", "[grow]"));
		
		//PANEL PERFIL
		panelPerfil = new JPanel();
		panelPerfil.setBackground(new Color(255, 192, 203));
		panelPerfil.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		inicio.add(panelPerfil, "cell 0 0,grow");
		panelPerfil.setLayout(new MigLayout("", "[69px,center][grow]", "[16%][20%][20%][20%][20%]"));
		
		lblPerfil = new JLabel("Perfil");
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setForeground(new Color(220, 20, 60));
		lblPerfil.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblPerfil.setBackground(new Color(255, 192, 203));
		panelPerfil.add(lblPerfil, "cell 0 0,alignx left,aligny center");
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		panelPerfil.add(lblNombre, "cell 0 1,alignx leading");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(250, 128, 114)));
		textFieldNombre.setSelectedTextColor(new Color(255, 255, 255));
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setToolTipText("");
		panelPerfil.add(textFieldNombre, "cell 1 1,growx");
		textFieldNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		panelPerfil.add(lblApellidos, "cell 0 2,alignx leading");
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(250, 128, 114)));
		textFieldApellidos.setEnabled(false);
		textFieldApellidos.setEditable(false);
		panelPerfil.add(textFieldApellidos, "cell 1 2,growx");
		textFieldApellidos.setColumns(10);
		
		lblCorreoElectronico = new JLabel("Correo:");
		lblCorreoElectronico.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		panelPerfil.add(lblCorreoElectronico, "cell 0 3,alignx leading");
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(250, 128, 114)));
		textFieldCorreo.setEditable(false);
		textFieldCorreo.setEnabled(false);
		panelPerfil.add(textFieldCorreo, "cell 1 3,growx");
		textFieldCorreo.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		panelPerfil.add(lblDni, "cell 0 4,alignx leading");
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(250, 128, 114)));
		textFieldDNI.setEditable(false);
		textFieldDNI.setEnabled(false);
		panelPerfil.add(textFieldDNI, "cell 1 4,growx");
		textFieldDNI.setColumns(10);
		
		//PANEL LIBROS 
		panelLibros = new JPanel();
		panelLibros.setBackground(new Color(216, 191, 216));
		panelLibros.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		inicio.add(panelLibros, "cell 1 0,grow");
		panelLibros.setLayout(new MigLayout("", "[grow]", "[16%][grow]"));
		
		lblLibrosEnPosesion = new JLabel("Libros en posesi\u00F3n");
		lblLibrosEnPosesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrosEnPosesion.setForeground(new Color(220, 20, 60));
		lblLibrosEnPosesion.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblLibrosEnPosesion.setBackground(new Color(173, 216, 230));
		panelLibros.add(lblLibrosEnPosesion, "cell 0 0");
		
		listaLibros = new JList();
		panelLibros.add(listaLibros, "flowx,cell 0 1,grow");
		
		scrollbarLibros = new Scrollbar();
		scrollbarLibros.setBackground(new Color(255, 255, 255));
		panelLibros.add(scrollbarLibros, "cell 0 1,alignx left,growy");
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		
		//PESTAÑA BIBLIOTECA
		biblioteca = new JLayeredPane();
		biblioteca.setOpaque(true);
		biblioteca.setBackground(new Color(255, 228, 196));
		biblioteca.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		tabbedPane.addTab("Biblioteca", null, biblioteca, null);
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
		tabbedPane.setEnabledAt(1, true);
		
		//PESTAÑA OPCIONES
		opciones = new JLayeredPane();
		opciones.setOpaque(true);
		opciones.setBackground(new Color(255, 250, 205));
		opciones.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		tabbedPane.addTab("Opciones", (Icon) null, opciones, null);

		opciones.setLayout(new CardLayout(0, 0));
		
		//PANEL MENU
		menuOpciones = new JPanel();
		menuOpciones.setBackground(new Color(255, 228, 196));
		menuOpciones.setBorder(null);
		opciones.add(menuOpciones, "name_130788683441500");
		
		btnInformacionYContacto = new JButton("Informaci\u00F3n y Contacto");
		btnInformacionYContacto.setActionCommand("Informaci\u00F3n y Contacto");
		btnInformacionYContacto.setForeground(new Color(255, 255, 255));
		btnInformacionYContacto.setFont(new Font("Arial", Font.BOLD, 13));
		btnInformacionYContacto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnInformacionYContacto.setBackground(new Color(240, 128, 128));
		btnInformacionYContacto.setAlignmentX(1.0f);
		
		btnEliminarCuenta = new JButton("Eliminar Cuenta");
		btnEliminarCuenta.setForeground(new Color(255, 255, 255));
		btnEliminarCuenta.setFont(new Font("Arial", Font.BOLD, 13));
		btnEliminarCuenta.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEliminarCuenta.setBackground(new Color(240, 128, 128));
		btnEliminarCuenta.setAlignmentX(1.0f);
		
		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 13));
		btnCerrarSesion.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCerrarSesion.setBackground(new Color(240, 128, 128));
		btnCerrarSesion.setAlignmentX(1.0f);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("Arial", Font.BOLD, 13));
		btnSalir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSalir.setBackground(new Color(240, 128, 128));
		btnSalir.setAlignmentX(1.0f);
		
		btnModificarPerfil = new JButton("Modificar Perfil");
		btnModificarPerfil.setForeground(new Color(255, 255, 255));
		btnModificarPerfil.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificarPerfil.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnModificarPerfil.setBackground(new Color(240, 128, 128));
		btnModificarPerfil.setAlignmentX(1.0f);
		
		GroupLayout gl_menuOpciones = new GroupLayout(menuOpciones);
		gl_menuOpciones.setHorizontalGroup(
			gl_menuOpciones.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_menuOpciones.createSequentialGroup()
					.addGap(173)
					.addGroup(gl_menuOpciones.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnInformacionYContacto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(btnEliminarCuenta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(btnCerrarSesion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(btnModificarPerfil, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(btnSalir, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
					.addGap(178))
		);
		gl_menuOpciones.setVerticalGroup(
			gl_menuOpciones.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_menuOpciones.createSequentialGroup()
					.addGap(29)
					.addComponent(btnModificarPerfil, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(17)
					.addComponent(btnInformacionYContacto, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEliminarCuenta, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnCerrarSesion, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnSalir, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(30))
		);
		menuOpciones.setLayout(gl_menuOpciones);
		
		//PANEL MODIFICAR
		panelModificar = new JPanel();
		panelModificar.setBackground(new Color(255, 228, 196));
		opciones.add(panelModificar, "name_137554930184200");
		
		lblModificacionDePerfil = new JLabel("Modificaci\u00F3n de perfil");
		lblModificacionDePerfil.setBounds(10, 11, 275, 37);
		lblModificacionDePerfil.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblModificacionDePerfil.setForeground(new Color(220, 20, 60));
		
		lblCorreo = new JLabel("Correo electr\u00F3nico actual:");
		lblCorreo.setBounds(51, 67, 142, 16);
		lblCorreo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		
		lblContrasena = new JLabel("Contrase\u00F1a actual:");
		lblContrasena.setBounds(51, 236, 142, 16);
		lblContrasena.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		
		btnAtras = new JButton("\u2190Atr\u00E1s");
		btnAtras.setForeground(new Color(220, 20, 60));
		btnAtras.setFont(new Font("Arial", Font.BOLD, 13));
		btnAtras.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btnAtras.setBackground(new Color(255, 250, 240));
		btnAtras.setBounds(10, 275, 88, 33);
		
		btnConfirmarModificaciones = new JButton("Confirmar modificaciones");
		btnConfirmarModificaciones.setForeground(new Color(220, 20, 60));
		btnConfirmarModificaciones.setBounds(367, 274, 175, 34);
		btnConfirmarModificaciones.setBackground(new Color(255, 250, 240));
		btnConfirmarModificaciones.setFont(new Font("Arial", Font.BOLD, 13));
		btnConfirmarModificaciones.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		
		textFieldCorreoActual = new JTextField();
		textFieldCorreoActual.setEditable(false);
		textFieldCorreoActual.setBounds(233, 66, 159, 20);
		textFieldCorreoActual.setColumns(10);
		panelModificar.setLayout(null);
		panelModificar.add(btnAtras);
		panelModificar.add(btnConfirmarModificaciones);
		panelModificar.add(lblModificacionDePerfil);
		panelModificar.add(lblCorreo);
		panelModificar.add(lblContrasena);
		panelModificar.add(textFieldCorreoActual);
		
		passwordFieldContrasenaActual = new JPasswordField();
		passwordFieldContrasenaActual.setBounds(233, 235, 159, 20);
		panelModificar.add(passwordFieldContrasenaActual);
		
		separator = new JSeparator();
		separator.setBounds(51, 128, 341, 2);
		panelModificar.add(separator);
		
		lblContrasenaNueva = new JLabel("Contrase\u00F1a nueva:");
		lblContrasenaNueva.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		lblContrasenaNueva.setBounds(51, 141, 142, 16);
		panelModificar.add(lblContrasenaNueva);
		
		lblCorreoNuevo = new JLabel("Correo electr\u00F3nico nuevo:");
		lblCorreoNuevo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		lblCorreoNuevo.setBounds(51, 98, 142, 16);
		panelModificar.add(lblCorreoNuevo);
		
		textFieldCorreoNuevo = new JTextField();
		textFieldCorreoNuevo.setColumns(10);
		textFieldCorreoNuevo.setBounds(233, 97, 159, 20);
		panelModificar.add(textFieldCorreoNuevo);
		
		passwordContrasena = new JPasswordField();
		passwordContrasena.setBounds(233, 141, 159, 20);
		panelModificar.add(passwordContrasena);
		
		lblConfirmarContrasena = new JLabel("Confirmar contrase\u00F1a nueva:");
		lblConfirmarContrasena.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		lblConfirmarContrasena.setBounds(51, 173, 159, 16);
		panelModificar.add(lblConfirmarContrasena);
		
		passwordFieldConfirmarContrasena = new JPasswordField();
		passwordFieldConfirmarContrasena.setBounds(233, 172, 159, 20);
		panelModificar.add(passwordFieldConfirmarContrasena);
		
		lblEsNecesario = new JLabel("* Es necesario introducir la contrase\u00F1a para guardar cualquier cambio.");
		lblEsNecesario.setForeground(new Color(220, 20, 60));
		lblEsNecesario.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEsNecesario.setBounds(51, 211, 341, 14);
		panelModificar.add(lblEsNecesario);
		
		lblDebeSer = new JLabel(" * Debe ser de 6-50 caracteres.");
		lblDebeSer.setForeground(new Color(220, 20, 60));
		lblDebeSer.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDebeSer.setBounds(392, 143, 160, 14);
		panelModificar.add(lblDebeSer);
		
		//PANEL DE INFORMACION
		panelInformacion = new JPanel();
		panelInformacion.setBackground(new Color(255, 228, 196));
		opciones.add(panelInformacion, "name_137578710176100");
		
		lblLapacalee = new JLabel("LaPacaLee");
		lblLapacalee.setBounds(21, 25, 119, 37);
		lblLapacalee.setForeground(new Color(220, 20, 60));
		lblLapacalee.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		
		lblSobreNosotros = new JLabel("Sobre nosotros...");
		lblSobreNosotros.setBounds(21, 75, 154, 27);
		lblSobreNosotros.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		
		txtpnLapacalee = new JTextPane();
		txtpnLapacalee.setBounds(21, 120, 318, 158);
		txtpnLapacalee.setFont(new Font("Arial", Font.PLAIN, 13));
		txtpnLapacalee.setBorder(null);
		txtpnLapacalee.setEditable(false);
		txtpnLapacalee.setBackground(new Color(255, 228, 196));
		txtpnLapacalee.setText("LaPacaLee es un software sin \u00E1nimo de lucro destinado a la gesti\u00F3n online de una biblioteca. Ha sido desarollado por estudiantes de primer a\u00F1o del grado de Ingenier\u00EDa Inform\u00E1tica de la Universidad Europea de Madrid.\r\nEs un programa sencillo y f\u00E1cil de utilizar, que pretende facilitar la interacci\u00F3n del usuario con los contenidos tanto f\u00EDsicos como online de la biblioteca. Aunque tenga funcionalidades b\u00E1sicas, esperemos que les guste :D.");
		
		//IMAGEN DE LA UE EN EL PANEL DE INFORMACION
		BufferedImage myPicture=null;
		try {
			myPicture = ImageIO.read(new File("./ue.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		lblUe = new JLabel(new ImageIcon(myPicture));
		lblUe.setBorder(null);
		lblUe.setBounds(362, 25, 157, 167);
		panelInformacion.add(lblUe);

		btncontactanos = new JButton("\u00A1Cont\u00E1ctanos!");
		btncontactanos.setForeground(new Color(220, 20, 60));
		btncontactanos.setFont(new Font("Arial", Font.BOLD, 13));
		btncontactanos.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btncontactanos.setBackground(new Color(255, 250, 240));
		btncontactanos.setBounds(362, 261, 157, 37);
		
		panelInformacion.setLayout(null);
		panelInformacion.add(lblUe);
		panelInformacion.add(txtpnLapacalee);
		panelInformacion.add(btncontactanos);
		panelInformacion.add(lblSobreNosotros);
		panelInformacion.add(lblLapacalee);
		
		//PANEL ELIMINAR
		panelEliminar = new JPanel();
		panelEliminar.setBackground(new Color(255, 228, 196));
		opciones.add(panelEliminar, "name_140647994422199");
		
		lblCuidado = new JLabel("\u00A1CUIDADO!");
		lblCuidado.setForeground(new Color(220, 20, 60));
		lblCuidado.setFont(new Font("Goudy Old Style", Font.BOLD, 30));
		
		lblSeguro = new JLabel("\u00BFSeguro que quieres eliminar tu cuenta? :(");
		lblSeguro.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		
		btnNo = new JButton("\u00A1No! Quiero seguir leyendo");
		btnNo.setBackground(new Color(255, 255, 255));
		btnNo.setFont(new Font("Arial", Font.BOLD, 11));
		btnNo.setForeground(new Color(220, 20, 60));
		
		btnSi = new JButton("Si, ya no me interesa este servicio");
		btnSi.setBackground(new Color(255, 255, 255));
		btnSi.setForeground(new Color(220, 20, 60));
		btnSi.setFont(new Font("Arial", Font.BOLD, 11));
		
		lblInfo = new JLabel("* Esta es una acci\u00F3n irreversible, todos los datos ser\u00E1n eliminados.");
		lblInfo.setForeground(new Color(0, 0, 0));
		lblInfo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GroupLayout gl_panelEliminar = new GroupLayout(panelEliminar);
		gl_panelEliminar.setHorizontalGroup(
			gl_panelEliminar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEliminar.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panelEliminar.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInfo)
						.addComponent(lblSeguro, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCuidado, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(193, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelEliminar.createSequentialGroup()
					.addGap(38)
					.addComponent(btnNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(35)
					.addComponent(btnSi)
					.addGap(33))
		);
		gl_panelEliminar.setVerticalGroup(
			gl_panelEliminar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEliminar.createSequentialGroup()
					.addGap(59)
					.addComponent(lblCuidado, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSeguro, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addGroup(gl_panelEliminar.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNo)
						.addComponent(btnSi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(34)
					.addComponent(lblInfo)
					.addContainerGap())
		);
		panelEliminar.setLayout(gl_panelEliminar);
		tabbedPane.setBackgroundAt(2, new Color(255, 255, 255));
		tabbedPane.setEnabledAt(2, true);
		frmLapacalee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//GETTERS Y SETTERS
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
