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
import control.Controlador;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class A2VentanaAdmin {

	private JFrame frmLapacalee;
	private JTabbedPane tabbedPane;
	
	//PESTAÑA INICIO	
	private JPanel inicio;
	
	//PESTAÑA BIBLIOTECA
	private JPanel biblioteca;
	private CardLayout cb;
	//PANEL BUSCAR
	private JPanel panelBuscar;
	private JTextField textFieldBuscar;
	private JLabel lblFiltros;
	private JPanel panelFiltros;
	private JButton btnBuscar;
	private JScrollPane scrollPaneBiblioteca;
	private JPanel panelGeneros;
	private JCheckBox chckbxOtros;
	private JCheckBox chckbxHistoricos;
	private JCheckBox chckbxFilosofia;
	private JCheckBox chckbxDrama;
	private JCheckBox chckbxPoesia;
	private JCheckBox chckbxNarrativa;
	private JLabel lblGeneros;
	private JButton btnDetalles;
	private JButton btnEliminar;
	private JButton btnAnadir;
	private JButton btnEditar;
	//PANEL AÑADIR LIBRO
	private JPanel panelAnadir;
	private JLabel lblAnadirLibro;
	private JButton btnConfirmar;
	private JButton btnCancelarAnadir;
	//PANEL EDITAR LIBRO
	private JPanel panelEditar;
	private JLabel lblEditar;
	private JButton btnConfirmarCambios;
	private JButton btnCancelarEditar;
	
	//PESTAÑA USUARIOS
	private JPanel usuarios;
	
	//PESTAÑA OPCIONES
	private JPanel opciones;
	private CardLayout co;
	//PANEL MENU
	private JPanel menuOpciones;
	private JButton btnInformacion;
	private JButton btnCerrarSesion;
	private JButton btnSalir;
	//PANEL INFORMACION
	private JPanel panelInformacion;
	private JTextPane txtpnLapacalee;
	private JButton btncontactanos;
	private JLabel lblSobreNosotros;
	private JLabel lblLapacalee;
	private JButton btnAtras;
	private JButton btnEditarInfo;
	
	

	/**
	 * Crea la aplicacion.
	 */
	public A2VentanaAdmin() {
		initialize();
	}

	/**
	 * Método que especifica la clase Controlador como Listener para las acciones de los componentes.
	 * @param control
	 */
	public void setControlador(Controlador control) {
		//PESTAÑA BIBLIOTECA
		//PANEL BUSCAR
		btnBuscar.addActionListener(control);
		btnDetalles.addActionListener(control);
		btnEliminar.addActionListener(control);
		btnAnadir.addActionListener(control);
		btnEditar.addActionListener(control);
		//PANEL AÑADIR
		btnConfirmar.addActionListener(control);
		btnCancelarAnadir.addActionListener(control);
		//PANEL EDITAR
		btnConfirmarCambios.addActionListener(control);
		btnCancelarEditar.addActionListener(control);
		
		//PESTAÑA OPCIONES
		btnInformacion.addActionListener(control);
		btnCerrarSesion.addActionListener(control);
		btnSalir.addActionListener(control);
		//PANEL INFORMACION
		btncontactanos.addActionListener(control);
		btnAtras.addActionListener(control);
		btnEditarInfo.addActionListener(control);
	}
	
	/**
	 * Initializa el contenido de la ventana.
	 */
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
		frmLapacalee.getContentPane().setLayout(new CardLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(220, 20, 60));
		tabbedPane.setFont(new Font("Arial", Font.BOLD, 12));
		frmLapacalee.getContentPane().add(tabbedPane, "name_225605748370200");
		
		/**
		 * PESTAÑA INICIO
		 */
		inicio = new JPanel();
		inicio.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		inicio.setBackground(new Color(255, 228, 196));
		tabbedPane.addTab("Inicio", null, inicio, null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido a la pantalla de administraci\u00F3n");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setForeground(new Color(220, 20, 60));
		lblBienvenido.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		GroupLayout gl_inicio = new GroupLayout(inicio);
		gl_inicio.setHorizontalGroup(
			gl_inicio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inicio.createSequentialGroup()
					.addGap(36)
					.addComponent(lblBienvenido, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
					.addGap(36))
		);
		gl_inicio.setVerticalGroup(
			gl_inicio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inicio.createSequentialGroup()
					.addGap(21)
					.addComponent(lblBienvenido)
					.addContainerGap(262, Short.MAX_VALUE))
		);
		inicio.setLayout(gl_inicio);
		
		/**
		 * PESTAÑA BIBLIOTECA
		 */
		biblioteca = new JPanel();
		biblioteca.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		biblioteca.setBackground(new Color(255, 228, 196));
		tabbedPane.addTab("Biblioteca", null, biblioteca, null);
		cb=new CardLayout(0,0);
		biblioteca.setLayout(cb);
		
		//PANEL BUSCAR
		panelBuscar = new JPanel();
		panelBuscar.setLayout(null);
		panelBuscar.setBackground(new Color(255, 228, 196));
		biblioteca.add(panelBuscar, "name_338877309191600");
		
		lblFiltros = new JLabel("B\u00FAsqueda por: ");
		lblFiltros.setForeground(new Color(220, 20, 60));
		lblFiltros.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblFiltros.setBounds(10, 11, 108, 25);
		panelBuscar.add(lblFiltros);
		
		panelFiltros = new JPanel();
		panelFiltros.setBounds(122, 11, 274, 24);
		panelBuscar.add(panelFiltros);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		textFieldBuscar.setColumns(10);
		textFieldBuscar.setBounds(10, 42, 304, 23);
		panelBuscar.add(textFieldBuscar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(220, 20, 60));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 11));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(320, 42, 76, 23);
		panelBuscar.add(btnBuscar);
		
		scrollPaneBiblioteca = new JScrollPane();
		scrollPaneBiblioteca.setBounds(10, 71, 386, 206);
		panelBuscar.add(scrollPaneBiblioteca);
		
		panelGeneros = new JPanel();
		panelGeneros.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelGeneros.setBackground(new Color(240, 128, 128));
		panelGeneros.setBounds(402, 11, 146, 304);
		panelBuscar.add(panelGeneros);
		
		chckbxOtros = new JCheckBox("Otros");
		chckbxOtros.setForeground(Color.WHITE);
		chckbxOtros.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxOtros.setBackground(new Color(240, 128, 128));
		
		chckbxHistoricos = new JCheckBox("Textos hist\u00F3ricos");
		chckbxHistoricos.setForeground(Color.WHITE);
		chckbxHistoricos.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxHistoricos.setBackground(new Color(240, 128, 128));
		
		chckbxFilosofia = new JCheckBox("Filosofia");
		chckbxFilosofia.setForeground(Color.WHITE);
		chckbxFilosofia.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxFilosofia.setBackground(new Color(240, 128, 128));
		
		chckbxDrama = new JCheckBox("Drama y teatro");
		chckbxDrama.setForeground(Color.WHITE);
		chckbxDrama.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxDrama.setBackground(new Color(240, 128, 128));
		
		chckbxPoesia = new JCheckBox("Poes\u00EDa");
		chckbxPoesia.setForeground(Color.WHITE);
		chckbxPoesia.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxPoesia.setBackground(new Color(240, 128, 128));
		
		chckbxNarrativa = new JCheckBox("Narrativa");
		chckbxNarrativa.setForeground(Color.WHITE);
		chckbxNarrativa.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxNarrativa.setBackground(new Color(240, 128, 128));
		
		lblGeneros = new JLabel("G\u00E9neros");
		lblGeneros.setForeground(new Color(220, 20, 60));
		lblGeneros.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		GroupLayout gl_panelGeneros = new GroupLayout(panelGeneros);
		gl_panelGeneros.setHorizontalGroup(
			gl_panelGeneros.createParallelGroup(Alignment.LEADING)
				.addGap(0, 146, Short.MAX_VALUE)
				.addGroup(gl_panelGeneros.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelGeneros.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxOtros)
						.addComponent(chckbxHistoricos)
						.addComponent(chckbxFilosofia)
						.addComponent(chckbxDrama)
						.addComponent(chckbxPoesia)
						.addComponent(chckbxNarrativa)
						.addComponent(lblGeneros))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_panelGeneros.setVerticalGroup(
			gl_panelGeneros.createParallelGroup(Alignment.LEADING)
				.addGap(0, 304, Short.MAX_VALUE)
				.addGroup(gl_panelGeneros.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGeneros)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNarrativa)
					.addGap(18)
					.addComponent(chckbxPoesia)
					.addGap(18)
					.addComponent(chckbxDrama)
					.addGap(18)
					.addComponent(chckbxFilosofia)
					.addGap(18)
					.addComponent(chckbxHistoricos)
					.addGap(18)
					.addComponent(chckbxOtros)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panelGeneros.setLayout(gl_panelGeneros);
		
		btnDetalles = new JButton("Detalles");
		btnDetalles.setForeground(new Color(220, 20, 60));
		btnDetalles.setFont(new Font("Arial", Font.BOLD, 11));
		btnDetalles.setBackground(Color.WHITE);
		btnDetalles.setBounds(108, 288, 91, 27);
		panelBuscar.add(btnDetalles);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(220, 20, 60));
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(305, 288, 91, 27);
		panelBuscar.add(btnEliminar);
		
		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setForeground(new Color(220, 20, 60));
		btnAnadir.setFont(new Font("Arial", Font.BOLD, 11));
		btnAnadir.setBackground(Color.WHITE);
		btnAnadir.setBounds(10, 288, 88, 27);
		panelBuscar.add(btnAnadir);
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(220, 20, 60));
		btnEditar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setBounds(204, 288, 91, 27);
		panelBuscar.add(btnEditar);
		cb.addLayoutComponent(panelBuscar, "1");
		
		//PANEL AÑADIR
		panelAnadir = new JPanel();
		panelAnadir.setBackground(new Color(255, 228, 196));
		biblioteca.add(panelAnadir, "name_260597066469100");
		panelAnadir.setLayout(null);
		
		lblAnadirLibro = new JLabel("A\u00F1adir libro");
		lblAnadirLibro.setForeground(new Color(220, 20, 60));
		lblAnadirLibro.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblAnadirLibro.setBounds(10, 11, 165, 31);
		panelAnadir.add(lblAnadirLibro);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(new Color(220, 20, 60));
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 13));
		btnConfirmar.setBackground(new Color(255, 250, 240));
		btnConfirmar.setAlignmentX(1.0f);
		btnConfirmar.setBounds(449, 284, 99, 31);
		panelAnadir.add(btnConfirmar);
		
		btnCancelarAnadir = new JButton("Cancelar");
		btnCancelarAnadir.setForeground(new Color(220, 20, 60));
		btnCancelarAnadir.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelarAnadir.setBackground(new Color(255, 250, 240));
		btnCancelarAnadir.setAlignmentX(1.0f);
		btnCancelarAnadir.setBounds(10, 284, 99, 31);
		panelAnadir.add(btnCancelarAnadir);
		cb.addLayoutComponent(panelAnadir, "2");
		
		//PANEL EDITAR
		panelEditar = new JPanel();
		panelEditar.setBackground(new Color(255, 228, 196));
		biblioteca.add(panelEditar, "name_262116212701800");
		panelEditar.setLayout(null);
		
		lblEditar = new JLabel("Editar informaci\u00F3n de ejemplar");
		lblEditar.setBounds(10, 11, 368, 37);
		lblEditar.setForeground(new Color(220, 20, 60));
		lblEditar.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		panelEditar.add(lblEditar);
		
		btnConfirmarCambios = new JButton("Confirmar cambios");
		btnConfirmarCambios.setForeground(new Color(220, 20, 60));
		btnConfirmarCambios.setFont(new Font("Arial", Font.BOLD, 13));
		btnConfirmarCambios.setBackground(new Color(255, 250, 240));
		btnConfirmarCambios.setAlignmentX(1.0f);
		btnConfirmarCambios.setBounds(389, 284, 153, 31);
		panelEditar.add(btnConfirmarCambios);
		
		btnCancelarEditar = new JButton("Cancelar");
		btnCancelarEditar.setForeground(new Color(220, 20, 60));
		btnCancelarEditar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelarEditar.setBackground(new Color(255, 250, 240));
		btnCancelarEditar.setAlignmentX(1.0f);
		btnCancelarEditar.setBounds(10, 284, 99, 31);
		panelEditar.add(btnCancelarEditar);
		cb.addLayoutComponent(panelEditar, "3");
		
		/**
		 * PESTAÑA USUARIOS
		 */
		usuarios = new JPanel();
		usuarios.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		usuarios.setBackground(new Color(255, 228, 196));
		tabbedPane.addTab("Usuarios", null, usuarios, null);
		
		/**
		 * PESTAÑA OPCIONES
		 */
		opciones = new JPanel();
		opciones.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		opciones.setBackground(new Color(255, 228, 196));
		tabbedPane.addTab("Opciones", null, opciones, null);
		co=new CardLayout(0,0);
		opciones.setLayout(co);
		
		menuOpciones = new JPanel();
		menuOpciones.setBorder(null);
		menuOpciones.setBackground(new Color(255, 228, 196));
		opciones.add(menuOpciones, "name_238836784821200");
		
		btnInformacion = new JButton("Informaci\u00F3n y Contacto");
		btnInformacion.setForeground(Color.WHITE);
		btnInformacion.setFont(new Font("Arial", Font.BOLD, 13));
		btnInformacion.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnInformacion.setBackground(new Color(240, 128, 128));
		btnInformacion.setAlignmentX(1.0f);
		btnInformacion.setActionCommand("");
		
		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 13));
		btnCerrarSesion.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCerrarSesion.setBackground(new Color(240, 128, 128));
		btnCerrarSesion.setAlignmentX(1.0f);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Arial", Font.BOLD, 13));
		btnSalir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSalir.setBackground(new Color(240, 128, 128));
		btnSalir.setAlignmentX(1.0f);
		GroupLayout gl_menuOpciones = new GroupLayout(menuOpciones);
		gl_menuOpciones.setHorizontalGroup(
			gl_menuOpciones.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 552, Short.MAX_VALUE)
				.addGroup(gl_menuOpciones.createSequentialGroup()
					.addGap(173)
					.addGroup(gl_menuOpciones.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSalir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(btnCerrarSesion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(btnInformacion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
					.addGap(178))
		);
		gl_menuOpciones.setVerticalGroup(
			gl_menuOpciones.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_menuOpciones.createSequentialGroup()
					.addGap(65)
					.addComponent(btnInformacion, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnCerrarSesion, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(btnSalir, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(83))
		);
		menuOpciones.setLayout(gl_menuOpciones);
		co.addLayoutComponent(menuOpciones, "1");
		
		//PANEL INFORMACION
		panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setBackground(new Color(255, 228, 196));
		opciones.add(panelInformacion, "name_339854700071600");
		
		//IMAGEN DE LA UE EN EL PANEL DE INFORMACION
		BufferedImage myPicture=null;
		try {
			myPicture = ImageIO.read(new File("./ue.png"));
		} catch (IOException e) {
			System.out.println("La imagen no carga");
			e.printStackTrace();
		}
		JLabel lblUe = new JLabel(new ImageIcon(myPicture));
		lblUe.setBorder(null);
		lblUe.setBounds(362, 25, 157, 167);
		panelInformacion.add(lblUe);
		
		txtpnLapacalee = new JTextPane();
		txtpnLapacalee.setText("LaPacaLee es un software sin \u00E1nimo de lucro destinado a la gesti\u00F3n online de una biblioteca. Ha sido desarollado por estudiantes de primer a\u00F1o del grado de Ingenier\u00EDa Inform\u00E1tica de la Universidad Europea de Madrid.\r\nEs un programa sencillo y f\u00E1cil de utilizar, que pretende facilitar la interacci\u00F3n del usuario con los contenidos tanto f\u00EDsicos como online de la biblioteca. Aunque tenga funcionalidades b\u00E1sicas, esperemos que les guste :D.");
		txtpnLapacalee.setFont(new Font("Arial", Font.PLAIN, 13));
		txtpnLapacalee.setEditable(false);
		txtpnLapacalee.setBorder(null);
		txtpnLapacalee.setBackground(new Color(255, 228, 196));
		txtpnLapacalee.setBounds(21, 120, 318, 150);
		panelInformacion.add(txtpnLapacalee);
		
		btncontactanos = new JButton("\u00A1Cont\u00E1ctanos!");
		btncontactanos.setForeground(Color.WHITE);
		btncontactanos.setFont(new Font("Arial", Font.BOLD, 13));
		btncontactanos.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		btncontactanos.setBackground(new Color(250, 128, 114));
		btncontactanos.setBounds(362, 261, 157, 37);
		panelInformacion.add(btncontactanos);
		
		lblSobreNosotros = new JLabel("Sobre nosotros...");
		lblSobreNosotros.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblSobreNosotros.setBounds(21, 75, 154, 27);
		panelInformacion.add(lblSobreNosotros);
		
		lblLapacalee = new JLabel("LaPacaLee");
		lblLapacalee.setForeground(new Color(220, 20, 60));
		lblLapacalee.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblLapacalee.setBounds(21, 25, 119, 37);
		panelInformacion.add(lblLapacalee);
		
		btnAtras = new JButton("\u2190 Atr\u00E1s");
		btnAtras.setForeground(new Color(220, 20, 60));
		btnAtras.setFont(new Font("Arial", Font.BOLD, 11));
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(10, 281, 83, 28);
		panelInformacion.add(btnAtras);
		
		btnEditarInfo = new JButton("Editar");
		btnEditarInfo.setForeground(new Color(220, 20, 60));
		btnEditarInfo.setFont(new Font("Arial", Font.BOLD, 11));
		btnEditarInfo.setBackground(Color.WHITE);
		btnEditarInfo.setBounds(256, 281, 83, 28);
		panelInformacion.add(btnEditarInfo);
		co.addLayoutComponent(panelInformacion, "2");
		

		
		frmLapacalee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrmLapacalee() {
		return frmLapacalee;
	}

	public void setFrmLapacalee(JFrame frmLapacalee) {
		this.frmLapacalee = frmLapacalee;
	}

	public JPanel getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(JPanel biblioteca) {
		this.biblioteca = biblioteca;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnDetalles() {
		return btnDetalles;
	}

	public void setBtnDetalles(JButton btnDetalles) {
		this.btnDetalles = btnDetalles;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public void setBtnAnadir(JButton btnAnadir) {
		this.btnAnadir = btnAnadir;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public JButton getBtnCancelarAnadir() {
		return btnCancelarAnadir;
	}

	public void setBtnCancelarAnadir(JButton btnCancelarAnadir) {
		this.btnCancelarAnadir = btnCancelarAnadir;
	}

	public JButton getBtnConfirmarCambios() {
		return btnConfirmarCambios;
	}

	public void setBtnConfirmarCambios(JButton btnConfirmarCambios) {
		this.btnConfirmarCambios = btnConfirmarCambios;
	}

	public JButton getBtnCancelarEditar() {
		return btnCancelarEditar;
	}

	public void setBtnCancelarEditar(JButton btnCancelarEditar) {
		this.btnCancelarEditar = btnCancelarEditar;
	}

	public JPanel getOpciones() {
		return opciones;
	}

	public void setOpciones(JPanel opciones) {
		this.opciones = opciones;
	}

	public JButton getBtnInformacion() {
		return btnInformacion;
	}

	public void setBtnInformacion(JButton btnInformacion) {
		this.btnInformacion = btnInformacion;
	}

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtncontactanos() {
		return btncontactanos;
	}

	public void setBtncontactanos(JButton btncontactanos) {
		this.btncontactanos = btncontactanos;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	public void setBtnAtras(JButton btnAtras) {
		this.btnAtras = btnAtras;
	}

	public JButton getBtnEditarInfo() {
		return btnEditarInfo;
	}

	public void setBtnEditarInfo(JButton btnEditarInfo) {
		this.btnEditarInfo = btnEditarInfo;
	}

	public CardLayout getCb() {
		return cb;
	}

	public void setCb(CardLayout cb) {
		this.cb = cb;
	}

	public CardLayout getCo() {
		return co;
	}

	public void setCo(CardLayout co) {
		this.co = co;
	}
}
