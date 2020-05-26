package vista;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import control.Controlador;
import model.Libro;
import model.Usuario;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import accesoDB.PersistenciaDatos;
import net.miginfocom.swing.MigLayout;

public class A2VentanaAdmin{

	private JFrame frmLapacalee;
	private JTabbedPane tabbedPane;
	private PersistenciaDatos p;
	
	//PESTAÑA INICIO	
	private JPanel inicio;
	private JLabel lblNombre, lblApellidos, lblDni, lblCorreo;
	private JTextField textFieldNombre, textFieldApellidos, textFieldCorreo, textFieldDNI;
	
	//PESTAÑA BIBLIOTECA
	private JPanel biblioteca;
	private CardLayout cb;
	//TABLA
	private JPanel panelBuscadorLibros;
	private JScrollPane scrollPaneLibros;
	private JTable tablaLibros;
	
	//PANEL BUSCAR
	private JPanel panelBuscar, panelFiltros, panelGeneros, panelBotones;
	private JTextField textFieldBuscar;
	private JLabel lblFiltros, lblGeneros;
	private JButton btnBuscar, btnDetalles, btnEliminar, btnAnadir;
	private JCheckBox chckbxOtros, chckbxHistoricos, chckbxFilosofia, chckbxDrama, chckbxPoesia, chckbxNarrativa, chckbxDisponible;
	private JRadioButton rdbtnAutor, rdbtnTtulo, rdbtnCdigo;
	private ButtonGroup grupoBuscarGeneros, grupoL;
	
	//PANEL AÑADIR LIBRO
	private JPanel panelAnadir, panelLibroA, panelGenerosA;
	private JLabel lblAnadirLibro, lblTituloA, lblAutorA, lblCodigoA, lblResumenA, lblGenerosA, lblMensajeAnadirLibro;
	private JButton btnConfirmar, btnCancelarAnadir;
	private JTextField textTituloA, textFieldAutorA, textFieldCodigoA;
	private JTextPane textPaneResumenA;
	private JCheckBox chckbxOtrosA, chckbxHistoricosA, chckbxFilosofiaA, chckbxDramaA, chckbxPoesiaA, chckbxNarrativaA;
	
	//PANEL EDITAR LIBRO
	private JPanel panelEditar, panelGenerosE, panelLibroE;
	private JLabel lblEditar, lblGenerosE, lblTituloE, lblAutorE, lblCodigoE, lblResumenE;
	private JButton btnConfirmarCambios, btnCancelarEditar;
	private JCheckBox chckbxNarrativaE, chckbxPoesiaE, chckbxDramaE, chckbxFilosofiaE, chckbxHistoricosE, chckbxOtrosE, chckbxMarcarComoDevuelto;
	private JTextField textFieldTituloE, textFieldAutorE, textFieldCodigoE;
	private JTextPane textPaneE;	
	
	//PESTAÑA USUARIOS
	private JPanel usuarios;
	private CardLayout cu;
	//TABLA
	private JPanel panelBuscador;
	private JTable tablaUsuarios;
	private JScrollPane scrollPaneUsuarios;
	
	//PANEL BUSCAR
	private JPanel panelBuscarU, panelFiltrosU, panelBotonesU, panelCheckBxU;
	private JLabel lblFiltrosU, lblFiltrarPorU;
	private JTextField textFieldBuscarU;
	private JButton btnBuscarU, btnAnadirU, btnEditarU, btnBloquear, btnEliminarU;
	private JCheckBox chckbxUsuariosBloqueados, chckbxAdministrador;
	private JRadioButton rdbtnDni,rdbtnNombre, rdbtnApellidos, rdbtnCorreo;
	private ButtonGroup grupoFiltroUsuario, grupoU;
	//PANEL AÑADIR
	private JPanel panelAnadirU, panelCrearUsuario;
	private JButton btnConfirmarU, btnCancelarAnadirU;
	private JLabel lblAnadirUsuario, lblMensaje, lblNombreU, lblApellidosU, lblDniU, lblCorreoU,lblContrasenaU, lblRepetirContrasena;
	private JTextField textFieldNombreU, textFieldApellidosU, textFieldDniU,textFieldCorreoU;
	private JPasswordField passwordFieldContrasenaU, passwordFieldContrasena2U;
	//PANEL EDITAR
	private JPanel panelEditarU, panelE1;
	private JLabel lblEditarU, lblNombreE, lblApellidosE, lblCorreoE, lblContraseaNueva_1, lblRepetirContrasena_1, lblContrasea, lblNoSe;
	private JButton btnConfirmarCambiosU, btnCancelarEditarU, btnEditar;
	private JTextField textFieldNombreNuevo, textFieldApellidosNuevos, textFieldCorreoNuevo;
	private JPasswordField passwordFieldContrasenaNueva, passwordFieldRepContrasenaNueva, passwordFieldContrasenaAdmin;
	private JCheckBox chckbxDerechosDeAdministrador, chckbxDesbloquear;
	private JSeparator separator;
	private JTextPane txtpnParaGuardarLos, txtpnSoloSi;
	
	//PESTAÑA OPCIONES
	private JPanel opciones;
	private CardLayout co;
	//PANEL MENU
	private JPanel menuOpciones;
	private JButton btnInformacion, btnCerrarSesion, btnSalir;
	//PANEL INFORMACION
	private JPanel panelInformacion;
	private JTextPane txtpnLapacalee;
	private JButton btncontactanos, btnAtras, btnEditarInfo;
	private JLabel lblSobreNosotros, lblLapacalee;
	private JScrollPane scrollPane;
	

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
		
		//PESTAÑA USUARIO
		//PANEL BUSCAR
		btnBuscarU.addActionListener(control);
		btnAnadirU.addActionListener(control);
		btnEditarU.addActionListener(control);
		btnBloquear.addActionListener(control);
		btnEliminarU.addActionListener(control);
		//PANEL AÑADIR
		btnConfirmarU.addActionListener(control);
		btnCancelarAnadirU.addActionListener(control);
		//PANEL EDITAR
		btnConfirmarCambiosU.addActionListener(control);
		btnCancelarEditarU.addActionListener(control);
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
	 * método que restablece el orden inicial de los paneles
	 */
	public void reiniciarPaneles() {
		tabbedPane.setSelectedComponent(inicio);
		cu.show(usuarios, "1");
		cb.show(biblioteca, "1");
		co.show(opciones, "1");
	}
	
	/**
	 * Devuelve los datos de los campos de la creación de usuario
	 * @return  usuario
	 */
	public Usuario obtenerDatosUsuarioCC() {
		Usuario user;
		String dni = textFieldDniU.getText(); 
		String correo = textFieldCorreoU.getText();
		@SuppressWarnings("deprecation")
		String contrasena = passwordFieldContrasenaU.getText();
		@SuppressWarnings("deprecation")
		String contrasena2 = passwordFieldContrasena2U.getText();
		String nombre = textFieldNombreU.getText();
		String apellidos = textFieldApellidosU.getText();

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
		textFieldDniU.setText("");
		textFieldCorreoU.setText("");
		passwordFieldContrasenaU.setText("");
		passwordFieldContrasena2U.setText("");
		textFieldNombreU.setText("");
		textFieldApellidosU.setText("");
	}
	
	/**
	 * Comprueba si los datos en la creación de usuario son correctos
	 * @return true o false 
	 */
	@SuppressWarnings("deprecation")
	public boolean comprobarDatosCC() {
		if (textFieldDniU.getText().equals("")
				||textFieldCorreoU.getText().equals("")
				||textFieldNombreU.getText().equals("")
				||textFieldApellidosU.getText().equals("")
				||passwordFieldContrasenaU.getText().equals("")
				||passwordFieldContrasena2U.getText().equals("")
				) {
			return false;			
		}
		else return true;
	}
	
	/**
	 * Completa los campos del panel de editar usuario 
	 * @param Usuario user 
	 */
	public void completarCamposEU(Usuario user) {
		textFieldCorreoNuevo.setText(user.getCorreo());
		textFieldApellidosNuevos.setText(user.getApellidos());
		textFieldNombreNuevo.setText(user.getNombre());
		passwordFieldContrasenaNueva.setText(user.getContrasena());
		
		if (user.isBloqueado()) chckbxDesbloquear.setEnabled(true);
		else chckbxDesbloquear.setEnabled(false);
		
		if (user.isAdmin()) chckbxDerechosDeAdministrador.setEnabled(false);
		else chckbxDerechosDeAdministrador.setEnabled(true);

	}
	
	/**
	 * obtiene los datos de los campos del panel de editar usuario
	 * @return String[] de los cambios realizados
	 */
	public String[] obtenerDatosUsuarioEU() {
		String[] cambios=new String[5];
		String correo = textFieldCorreoNuevo.getText();
		String nombre = textFieldNombreNuevo.getText();
		String apellidos = textFieldApellidosNuevos.getText();
		String contrasena = passwordFieldContrasenaNueva.getText();
		String contrasenaAdmin = passwordFieldContrasenaAdmin.getText();
		
		if(correo.equals("")
				||nombre.equals("")
				||apellidos.equals("")
				||contrasena.equals("")
				||contrasenaAdmin.equals("")) {
			cambios=null;
		}
		else {
			cambios[0]=correo;
			cambios[1]=nombre;
			cambios[2]=apellidos;
			cambios[3]=contrasena;
			cambios[4]=contrasenaAdmin;
		}
		return cambios;	
	}
		
	/**
	 * Devuelve los datos de los campos de la creación de libro
	 * @return  libro
	 */
	public Libro obtenerDatosLibroCL() {
		Libro libro;
		String titulo = textTituloA.getText();
		String autor = textFieldAutorA.getText();
		String resumen = textPaneResumenA.getText();
		String codigo = textFieldCodigoA.getText();
		String genero = obtenerGeneroLibroCL();
		String prestatario = null;
		
		if(titulo.equals("")
				||autor.equals("")
				||resumen.equals("")
				||codigo.equals("")
				||genero.equals("")) {
			libro=null;
		}
		else {
			libro=new Libro(titulo, autor, resumen, genero, codigo, false, prestatario);
		}
		return libro;
	}
	
	/**
	 * Obtiene el género del libro a partir del checkbox y lo devuelve
	 * @return genero
	 */
	private String obtenerGeneroLibroCL() {
		String genero;
		if (chckbxNarrativaA.isSelected()) genero=chckbxNarrativaA.getText();
		else if (chckbxPoesiaA.isSelected()) genero=chckbxPoesiaA.getText();
		else if (chckbxDramaA.isSelected()) genero=chckbxDramaA.getText();
		else if (chckbxFilosofiaA.isSelected()) genero=chckbxFilosofiaA.getText();
		else if (chckbxHistoricosA.isSelected()) genero=chckbxHistoricosA.getText();
		else if (chckbxOtrosA.isSelected()) genero=chckbxOtrosA.getText();
		else genero="";
		
		return genero;
	}
	
	/**
	 * Elimina los datos de los campos de añadir libro
	 */
	public void eliminarDatosAnadirLibro() {
		textTituloA.setText("");
		textFieldAutorA.setText("");
		textPaneResumenA.setText("");
		textFieldCodigoA.setText("");
		
		chckbxOtrosA.setSelected(false);
		chckbxHistoricosA.setSelected(false);
		chckbxFilosofiaA.setSelected(false);
		chckbxDramaA.setSelected(false);
		chckbxPoesiaA.setSelected(false);
		chckbxNarrativaA.setSelected(false);
	}
	
	
	/**
	 * rellena los campos del panel de editar libro con el libro seleccionado
	 * @param libro
	 */
	public void rellenarDatosLibro(Libro libro) {
		textFieldTituloE.setText(libro.getTitulo());
		textFieldAutorE.setText(libro.getAutor());
		textPaneE.setText(libro.getResumen());
		textFieldCodigoE.setText(libro.getCodigo());
		
		if(libro.getGenero().equals("Narrativa")) chckbxNarrativaE.setSelected(true);
		else if (libro.getGenero().equals("Poesía"))chckbxPoesiaE.setSelected(true);
		else if (libro.getGenero().equals("Drama y teatro"))chckbxDramaE.setSelected(true);
		else if (libro.getGenero().equals("Filosofía"))chckbxFilosofiaE.setSelected(true);
		else if (libro.getGenero().equals("Textos históricos"))chckbxHistoricosE.setSelected(true);
		else chckbxOtrosE.setSelected(true);
		
		if (!libro.isPrestado()) chckbxMarcarComoDevuelto.setEnabled(false);
		else {
			chckbxMarcarComoDevuelto.setEnabled(true);
			chckbxMarcarComoDevuelto.setSelected(false);
		}
	}
	
	/**
	 * obtiene los valores de los campos de editar libro
	 * @return String[] de los datos
	 */
	public String[] obtenerDatosLibroEL() {
		String[] cambios=new String[4];
		String titulo = textFieldTituloE.getText();
		String autor = textFieldAutorE.getText();
		String resumen = textPaneE.getText();
		String genero = obtenerGeneroLibroEL(); 
		
		if(titulo.equals("")
				||autor.equals("")
				||resumen.equals("")
				||genero.equals("")) {
			cambios=null;
		}
		else {
			cambios[0]=titulo;
			cambios[1]=autor;
			cambios[2]=resumen;
			cambios[3]=genero;
		}
		return cambios;
	}
	/**
	 * método privado que solo se usa para obtener un string del género seleccionado
	 * @return genero
	 */
	private String obtenerGeneroLibroEL() {
		String genero;
		if (chckbxNarrativaE.isSelected()) genero=chckbxNarrativaE.getText();
		else if (chckbxPoesiaE.isSelected()) genero=chckbxPoesiaE.getText();
		else if (chckbxDramaE.isSelected()) genero=chckbxDramaE.getText();
		else if (chckbxFilosofiaE.isSelected()) genero=chckbxFilosofiaE.getText();
		else if (chckbxHistoricosE.isSelected()) genero=chckbxHistoricosE.getText();
		else if (chckbxOtrosE.isSelected()) genero=chckbxOtrosE.getText();
		else genero="";
		
		return genero;
	}
	
	/**
	 * Recoge la casilla marcada de los generos del libro para usarlo como filtro
	 * @return String genero
	 */
	public String recogerFiltrosB() {
		String genero;
		if (chckbxNarrativa.isSelected()) genero=chckbxNarrativa.getText();
		else if (chckbxPoesia.isSelected()) genero=chckbxPoesia.getText();
		else if (chckbxDrama.isSelected()) genero=chckbxDrama.getText();
		else if (chckbxFilosofia.isSelected()) genero=chckbxFilosofia.getText();
		else if (chckbxHistoricos.isSelected()) genero=chckbxHistoricos.getText();
		else if (chckbxOtros.isSelected()) genero=chckbxOtros.getText();
		else genero="";
		return genero;
		
	}
	
	/**
	 * Recoge la casilla marcada de los filtros por los que se puede buscar un usuario
	 * @return String filtro
	 */
	public String recogerFiltrosU() {
		String filtro;
		if (chckbxUsuariosBloqueados.isSelected()) filtro=chckbxUsuariosBloqueados.getText();
		else if	(chckbxAdministrador.isSelected()) filtro=chckbxAdministrador.getText();
		else filtro="";
		
		return filtro;
	}
	
	/**
	 * Recoge el valor de la casilla marcada que despues servirá para establecer la columna por la que
	 * se va a buscar el libro en la base de datos
	 * @return String columna
	 */
	public String recogerColumnaFiltroB() {
		String columna;
		if (rdbtnAutor.isSelected()) {
			columna="AUTOR";
		}
		else if (rdbtnTtulo.isSelected()) {
			columna="TITULO";
		}
		else if (rdbtnCdigo.isSelected()) {
			columna="CODIGO";
		}
		else columna=null;
		return columna;
	}
	
	/**
	 * Recoge el valor de la casilla marcada que despues servirá para establecer la columna por la que 
	 * se va a buscar el usuario en la base de datos
	 * @return String columna
	 */
	public String recogerColumnaFiltroU() {
		String columna;
		if (rdbtnDni.isSelected()) {
			columna="DNI";
		}
		else if (rdbtnNombre.isSelected()) {
			columna="NOMBRE";
		}
		else if (rdbtnApellidos.isSelected()) {
			columna="APELLIDOS";
		}
		else if (rdbtnCorreo.isSelected()) {
			columna="CORREO";
		}
		else columna=null;
		return columna;
	}
	
	/**
	 * Actualiza el contenido de las tablas al producirse una modificación
	 * @param nombreTabla especifica qué tabla tiene que ser modificada
	 */
	public void refrescarTablas(String nombreTabla) {
		if(nombreTabla.equals("libro")) {
			tablaLibros.setModel(p.modelarTabla("SELECT TITULO, AUTOR, GENERO, PRESTADO, PRESTATARIO, CODIGO FROM LIBRO ORDER BY TITULO"));
			preferenciasTamanoTablaLibros();
		}
		else if (nombreTabla.equals("usuario")) {
			tablaUsuarios.setModel(p.modelarTabla("SELECT DNI, CORREO, NOMBRE, APELLIDOS, BLOQUEO, ADMIN FROM USUARIO ORDER BY CORREO"));
			preferenciasTamanoTablaUsuarios();
		}
	}
	
	/**
	 * método para establecer las preferencias visuales de tamaño de la tabla de libros en la interfaz
	 */
	public void preferenciasTamanoTablaLibros() {
		tablaLibros.getColumn("TITULO").setPreferredWidth(200);
		tablaLibros.getColumn("AUTOR").setPreferredWidth(150);
		tablaLibros.getColumn("GENERO").setPreferredWidth(100);
		tablaLibros.getColumn("PRESTADO").setPreferredWidth(50);
		tablaLibros.getColumn("PRESTATARIO").setPreferredWidth(100);
		tablaLibros.getColumn("CODIGO").setPreferredWidth(100);
	}
	
	/**
	 * método para establecer las preferencias visuales de tamaño de la tabla de usuarios en la interfaz
	 */
	public void preferenciasTamanoTablaUsuarios() {
		tablaUsuarios.getColumn("DNI").setPreferredWidth(100);
		tablaUsuarios.getColumn("CORREO").setPreferredWidth(150);
		tablaUsuarios.getColumn("NOMBRE").setPreferredWidth(150);
		tablaUsuarios.getColumn("APELLIDOS").setPreferredWidth(200);
		tablaUsuarios.getColumn("BLOQUEO").setPreferredWidth(50);
		tablaUsuarios.getColumn("ADMIN").setPreferredWidth(50);
	}

	/**
	 * Initializa el contenido de la ventana.
	 */
	private void initialize() {
		p=new PersistenciaDatos();
		
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
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(new Color(255, 192, 203));
		panelDatos.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JPanel panelGuia = new JPanel();
		panelGuia.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelGuia.setBackground(new Color(216, 191, 216));
		GroupLayout gl_inicio = new GroupLayout(inicio);
		gl_inicio.setHorizontalGroup(
			gl_inicio.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_inicio.createSequentialGroup()
					.addGroup(gl_inicio.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_inicio.createSequentialGroup()
							.addGap(28)
							.addComponent(panelDatos, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelGuia, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
						.addGroup(gl_inicio.createSequentialGroup()
							.addGap(36)
							.addComponent(lblBienvenido, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)))
					.addGap(36))
		);
		gl_inicio.setVerticalGroup(
			gl_inicio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inicio.createSequentialGroup()
					.addGap(21)
					.addComponent(lblBienvenido)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_inicio.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelDatos, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
						.addComponent(panelGuia, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
					.addGap(29))
		);
		panelGuia.setLayout(null);
		
		JLabel lblFuncionesPermitidas = new JLabel("Gu\u00EDa de administraci\u00F3n");
		lblFuncionesPermitidas.setForeground(new Color(220, 20, 60));
		lblFuncionesPermitidas.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblFuncionesPermitidas.setBounds(10, 11, 194, 19);
		panelGuia.add(lblFuncionesPermitidas);
		
		JTextPane txtpnSePermiten = new JTextPane();
		txtpnSePermiten.setBorder(null);
		txtpnSePermiten.setEditable(false);
		txtpnSePermiten.setBackground(new Color(216, 191, 216));
		txtpnSePermiten.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		txtpnSePermiten.setText("Se permiten:\r\n -Gesti\u00F3n de libros (a\u00F1adir, modificar, eliminar).\r\n -Gesti\u00F3n de usuarios (a\u00F1adir, modificar datos, bloquear acceso, eliminar).\r\n -Editar la secci\u00F3n de informaci\u00F3n y contacto.\r\nNo se permiten:\r\n -Crear usuarios con derecho de administraci\u00F3n.\r\n -Editar la informaci\u00F3n de esta cuenta.\r\n\r\n");
		txtpnSePermiten.setBounds(10, 36, 216, 179);
		panelGuia.add(txtpnSePermiten);
		panelDatos.setLayout(new MigLayout("", "[30%][grow]", "[20%][20%][20%][20%][20%]"));
		
		JLabel lblDatosDeAdministrador = new JLabel("Datos de administrador");
		lblDatosDeAdministrador.setForeground(new Color(220, 20, 60));
		lblDatosDeAdministrador.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		panelDatos.add(lblDatosDeAdministrador, "cell 0 0 2 1,growx,aligny top");
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		panelDatos.add(lblNombre, "cell 0 1,alignx trailing,aligny center");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		panelDatos.add(textFieldNombre, "cell 1 1,growx");
		textFieldNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidos.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		panelDatos.add(lblApellidos, "cell 0 2,alignx trailing,aligny center");
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setEditable(false);
		panelDatos.add(textFieldApellidos, "cell 1 2,growx");
		textFieldApellidos.setColumns(10);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		panelDatos.add(lblCorreo, "cell 0 3,alignx trailing");
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setEditable(false);
		panelDatos.add(textFieldCorreo, "cell 1 3,growx");
		textFieldCorreo.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		panelDatos.add(lblDni, "cell 0 4,alignx trailing,aligny center");
		
		textFieldDNI = new JTextField();
		textFieldDNI.setEditable(false);
		panelDatos.add(textFieldDNI, "cell 1 4,growx");
		textFieldDNI.setColumns(10);
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
		panelFiltros.setBackground(new Color(255, 228, 196));
		panelFiltros.setBounds(122, 11, 274, 24);
		panelBuscar.add(panelFiltros);
		GridBagLayout gbl_panelFiltros = new GridBagLayout();
		gbl_panelFiltros.columnWidths = new int[]{68, 68, 68, 68, 0};
		gbl_panelFiltros.rowHeights = new int[]{24, 0};
		gbl_panelFiltros.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelFiltros.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelFiltros.setLayout(gbl_panelFiltros);
		
		rdbtnAutor = new JRadioButton("Autor");
		rdbtnAutor.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		rdbtnAutor.setForeground(new Color(0, 0, 0));
		rdbtnAutor.setBackground(new Color(255, 228, 196));
		GridBagConstraints gbc_rdbtnAutor = new GridBagConstraints();
		gbc_rdbtnAutor.fill = GridBagConstraints.BOTH;
		gbc_rdbtnAutor.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnAutor.gridx = 0;
		gbc_rdbtnAutor.gridy = 0;
		panelFiltros.add(rdbtnAutor, gbc_rdbtnAutor);
		
		rdbtnTtulo = new JRadioButton("T\u00EDtulo");
		rdbtnTtulo.setSelected(true);
		rdbtnTtulo.setBackground(new Color(255, 228, 196));
		rdbtnTtulo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		rdbtnTtulo.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_rdbtnTtulo = new GridBagConstraints();
		gbc_rdbtnTtulo.fill = GridBagConstraints.BOTH;
		gbc_rdbtnTtulo.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnTtulo.gridx = 1;
		gbc_rdbtnTtulo.gridy = 0;
		panelFiltros.add(rdbtnTtulo, gbc_rdbtnTtulo);
		
		rdbtnCdigo = new JRadioButton("C\u00F3digo");
		rdbtnCdigo.setBackground(new Color(255, 228, 196));
		rdbtnCdigo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		rdbtnCdigo.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_rdbtnCdigo = new GridBagConstraints();
		gbc_rdbtnCdigo.fill = GridBagConstraints.BOTH;
		gbc_rdbtnCdigo.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnCdigo.gridx = 2;
		gbc_rdbtnCdigo.gridy = 0;
		panelFiltros.add(rdbtnCdigo, gbc_rdbtnCdigo);
		
		grupoL = new ButtonGroup();
		grupoL.add(rdbtnAutor);
		grupoL.add(rdbtnTtulo);
		grupoL.add(rdbtnCdigo);
		
		chckbxDisponible = new JCheckBox("Disponible");
		chckbxDisponible.setSelected(false);
		chckbxDisponible.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxDisponible.setBackground(new Color(255, 228, 196));
		GridBagConstraints gbc_chckbxDisponible = new GridBagConstraints();
		gbc_chckbxDisponible.gridx = 3;
		gbc_chckbxDisponible.gridy = 0;
		panelFiltros.add(chckbxDisponible, gbc_chckbxDisponible);
		
		
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
		
		grupoBuscarGeneros = new ButtonGroup();
		grupoBuscarGeneros.add(chckbxNarrativa);
		grupoBuscarGeneros.add(chckbxHistoricos);
		grupoBuscarGeneros.add(chckbxPoesia);
		grupoBuscarGeneros.add(chckbxFilosofia);
		grupoBuscarGeneros.add(chckbxOtros);
		grupoBuscarGeneros.add(chckbxDrama);
		
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
		cb.addLayoutComponent(panelBuscar, "1");
		
		panelBotones = new JPanel();
		panelBotones.setAlignmentY(0.0f);
		panelBotones.setBackground(new Color(255, 228, 196));
		panelBotones.setBounds(2, 277, 402, 43);
		panelBuscar.add(panelBotones);
		panelBotones.setLayout(new MigLayout("", "[25%,right][25%][25%][25%]", "[100%]"));
		
		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setAlignmentX(0.5f);
		panelBotones.add(btnAnadir, "cell 0 0,grow");
		btnAnadir.setForeground(new Color(220, 20, 60));
		btnAnadir.setFont(new Font("Arial", Font.BOLD, 11));
		btnAnadir.setBackground(Color.WHITE);
		
		btnDetalles = new JButton("Detalles");
		btnDetalles.setPreferredSize(new Dimension(92, 23));
		btnDetalles.setAlignmentY(Component.TOP_ALIGNMENT);
		panelBotones.add(btnDetalles, "cell 1 0,grow");
		btnDetalles.setForeground(new Color(220, 20, 60));
		btnDetalles.setFont(new Font("Arial", Font.BOLD, 11));
		btnDetalles.setBackground(Color.WHITE);
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(220, 20, 60));
		btnEditar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEditar.setBackground(Color.WHITE);
		panelBotones.add(btnEditar, "cell 2 0,grow");
		
		btnEliminar = new JButton("Eliminar");
		panelBotones.add(btnEliminar, "cell 3 0,grow");
		btnEliminar.setForeground(new Color(220, 20, 60));
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEliminar.setBackground(Color.WHITE);
		
		panelBuscadorLibros = new JPanel();
		panelBuscadorLibros.setBounds(10, 69, 386, 208);
		panelBuscar.add(panelBuscadorLibros);
		panelBuscadorLibros.setLayout(new BorderLayout(0, 0));
		
		scrollPaneLibros = new JScrollPane();
		panelBuscadorLibros.add(scrollPaneLibros);
		
		tablaLibros = new JTable();
		tablaLibros.setFillsViewportHeight(true);
		tablaLibros.setFocusable(false);
		tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaLibros.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		tablaLibros.setModel(p.modelarTabla("SELECT TITULO, AUTOR, GENERO, PRESTADO, PRESTATARIO, CODIGO FROM LIBRO ORDER BY TITULO"));
		preferenciasTamanoTablaLibros();
		
		scrollPaneLibros.setViewportView(tablaLibros);
		
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
		btnConfirmar.setBounds(443, 284, 99, 31);
		panelAnadir.add(btnConfirmar);
		
		btnCancelarAnadir = new JButton("Cancelar");
		btnCancelarAnadir.setForeground(new Color(220, 20, 60));
		btnCancelarAnadir.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelarAnadir.setBackground(new Color(255, 250, 240));
		btnCancelarAnadir.setAlignmentX(1.0f);
		btnCancelarAnadir.setBounds(10, 284, 99, 31);
		panelAnadir.add(btnCancelarAnadir);
		cb.addLayoutComponent(panelAnadir, "2");
		
		panelLibroA = new JPanel();
		panelLibroA.setBackground(new Color(255, 228, 196));
		panelLibroA.setBounds(10, 42, 387, 241);
		panelAnadir.add(panelLibroA);
		panelLibroA.setLayout(new MigLayout("", "[][grow]", "[][][][grow]"));
		
		lblTituloA = new JLabel("T\u00EDtulo:");
		lblTituloA.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		panelLibroA.add(lblTituloA, "cell 0 0,alignx trailing");
		
		textTituloA = new JTextField();
		panelLibroA.add(textTituloA, "cell 1 0,growx");
		textTituloA.setColumns(10);
		
		lblAutorA = new JLabel("Autor:");
		lblAutorA.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		panelLibroA.add(lblAutorA, "cell 0 1,alignx trailing");
		
		textFieldAutorA = new JTextField();
		panelLibroA.add(textFieldAutorA, "cell 1 1,growx");
		textFieldAutorA.setColumns(10);
		
		lblCodigoA = new JLabel("C\u00F3digo:");
		lblCodigoA.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		panelLibroA.add(lblCodigoA, "cell 0 2,alignx trailing");
		
		textFieldCodigoA = new JTextField();
		panelLibroA.add(textFieldCodigoA, "cell 1 2,growx");
		textFieldCodigoA.setColumns(10);
		
		lblResumenA = new JLabel("Resumen:");
		lblResumenA.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		panelLibroA.add(lblResumenA, "cell 0 3,aligny top");
		
		textPaneResumenA = new JTextPane();
		textPaneResumenA.setBorder(null);
		panelLibroA.add(textPaneResumenA, "cell 1 3,grow");
		
		panelGenerosA = new JPanel();
		panelGenerosA.setBackground(new Color(240, 128, 128));
		panelGenerosA.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelGenerosA.setBounds(407, 49, 135, 227);
		panelAnadir.add(panelGenerosA);
		
		lblGenerosA = new JLabel("G\u00E9neros:");
		lblGenerosA.setForeground(new Color(220, 20, 60));
		lblGenerosA.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		chckbxOtrosA = new JCheckBox("Otros");
		chckbxOtrosA.setForeground(Color.WHITE);
		chckbxOtrosA.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxOtrosA.setBackground(new Color(240, 128, 128));
		
		chckbxHistoricosA = new JCheckBox("Textos hist\u00F3ricos");
		chckbxHistoricosA.setForeground(Color.WHITE);
		chckbxHistoricosA.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxHistoricosA.setBackground(new Color(240, 128, 128));
		
		chckbxFilosofiaA = new JCheckBox("Filosofia");
		chckbxFilosofiaA.setForeground(Color.WHITE);
		chckbxFilosofiaA.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxFilosofiaA.setBackground(new Color(240, 128, 128));
		
		chckbxDramaA = new JCheckBox("Drama y teatro");
		chckbxDramaA.setForeground(Color.WHITE);
		chckbxDramaA.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxDramaA.setBackground(new Color(240, 128, 128));
		
		chckbxPoesiaA = new JCheckBox("Poes\u00EDa");
		chckbxPoesiaA.setForeground(Color.WHITE);
		chckbxPoesiaA.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxPoesiaA.setBackground(new Color(240, 128, 128));
		
		chckbxNarrativaA = new JCheckBox("Narrativa");
		chckbxNarrativaA.setForeground(Color.WHITE);
		chckbxNarrativaA.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxNarrativaA.setBackground(new Color(240, 128, 128));
		
		ButtonGroup grupoAnadirGenero=new ButtonGroup();
		grupoAnadirGenero.add(chckbxNarrativaA);
		grupoAnadirGenero.add(chckbxPoesiaA);
		grupoAnadirGenero.add(chckbxDramaA);
		grupoAnadirGenero.add(chckbxFilosofiaA);
		grupoAnadirGenero.add(chckbxHistoricosA);
		grupoAnadirGenero.add(chckbxOtrosA);
		
		GroupLayout gl_panelGenerosA = new GroupLayout(panelGenerosA);
		gl_panelGenerosA.setHorizontalGroup(
			gl_panelGenerosA.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGenerosA.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelGenerosA.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxOtrosA)
						.addComponent(chckbxHistoricosA)
						.addComponent(chckbxFilosofiaA)
						.addComponent(chckbxDramaA)
						.addComponent(chckbxPoesiaA)
						.addComponent(chckbxNarrativaA)
						.addComponent(lblGenerosA))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panelGenerosA.setVerticalGroup(
			gl_panelGenerosA.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGenerosA.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGenerosA, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNarrativaA, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxPoesiaA, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxDramaA, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxFilosofiaA, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxHistoricosA, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxOtrosA)
					.addGap(18))
		);
		panelGenerosA.setLayout(gl_panelGenerosA);
		
		lblMensajeAnadirLibro = new JLabel("");
		lblMensajeAnadirLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeAnadirLibro.setForeground(new Color(220, 20, 60));
		lblMensajeAnadirLibro.setFont(new Font("Arial", Font.PLAIN, 11));
		lblMensajeAnadirLibro.setBounds(119, 293, 314, 14);
		panelAnadir.add(lblMensajeAnadirLibro);
		
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
		btnConfirmarCambios.setBounds(372, 284, 170, 31);
		panelEditar.add(btnConfirmarCambios);
		
		btnCancelarEditar = new JButton("Cancelar");
		btnCancelarEditar.setForeground(new Color(220, 20, 60));
		btnCancelarEditar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelarEditar.setBackground(new Color(255, 250, 240));
		btnCancelarEditar.setAlignmentX(1.0f);
		btnCancelarEditar.setBounds(10, 284, 99, 31);
		panelEditar.add(btnCancelarEditar);
		cb.addLayoutComponent(panelEditar, "3");
		
		panelGenerosE = new JPanel();
		panelGenerosE.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelGenerosE.setBackground(new Color(240, 128, 128));
		panelGenerosE.setBounds(407, 49, 135, 227);
		panelEditar.add(panelGenerosE);
		
		chckbxNarrativaE = new JCheckBox("Narrativa");
		chckbxNarrativaE.setForeground(Color.WHITE);
		chckbxNarrativaE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxNarrativaE.setBackground(new Color(240, 128, 128));
		
		chckbxPoesiaE = new JCheckBox("Poes\u00EDa");
		chckbxPoesiaE.setForeground(Color.WHITE);
		chckbxPoesiaE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxPoesiaE.setBackground(new Color(240, 128, 128));
		
		chckbxDramaE = new JCheckBox("Drama y teatro");
		chckbxDramaE.setForeground(Color.WHITE);
		chckbxDramaE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxDramaE.setBackground(new Color(240, 128, 128));
		
		chckbxFilosofiaE = new JCheckBox("Filosofia");
		chckbxFilosofiaE.setForeground(Color.WHITE);
		chckbxFilosofiaE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxFilosofiaE.setBackground(new Color(240, 128, 128));
		
		chckbxHistoricosE = new JCheckBox("Textos hist\u00F3ricos");
		chckbxHistoricosE.setForeground(Color.WHITE);
		chckbxHistoricosE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxHistoricosE.setBackground(new Color(240, 128, 128));
		
		chckbxOtrosE = new JCheckBox("Otros");
		chckbxOtrosE.setForeground(Color.WHITE);
		chckbxOtrosE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxOtrosE.setBackground(new Color(240, 128, 128));
		
		lblGenerosE = new JLabel("G\u00E9neros:");
		lblGenerosE.setForeground(new Color(220, 20, 60));
		lblGenerosE.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		ButtonGroup grupoEditarGenero=new ButtonGroup();
		grupoEditarGenero.add(chckbxNarrativaE);
		grupoEditarGenero.add(chckbxPoesiaE);
		grupoEditarGenero.add(chckbxDramaE);
		grupoEditarGenero.add(chckbxFilosofiaE);
		grupoEditarGenero.add(chckbxHistoricosE);
		grupoEditarGenero.add(chckbxOtrosE);
		
		GroupLayout gl_panelGenerosE = new GroupLayout(panelGenerosE);
		gl_panelGenerosE.setHorizontalGroup(
			gl_panelGenerosE.createParallelGroup(Alignment.LEADING)
				.addGap(0, 135, Short.MAX_VALUE)
				.addGroup(gl_panelGenerosE.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelGenerosE.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxOtrosE)
						.addComponent(chckbxHistoricosE)
						.addComponent(chckbxFilosofiaE)
						.addComponent(chckbxDramaE)
						.addComponent(chckbxPoesiaE)
						.addComponent(chckbxNarrativaE)
						.addComponent(lblGenerosE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panelGenerosE.setVerticalGroup(
			gl_panelGenerosE.createParallelGroup(Alignment.LEADING)
				.addGap(0, 227, Short.MAX_VALUE)
				.addGroup(gl_panelGenerosE.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGenerosE, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNarrativaE, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxPoesiaE, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxDramaE, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxFilosofiaE, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxHistoricosE, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxOtrosE)
					.addGap(18))
		);
		panelGenerosE.setLayout(gl_panelGenerosE);
		
		panelLibroE = new JPanel();
		panelLibroE.setBackground(new Color(255, 228, 196));
		panelLibroE.setBounds(10, 49, 387, 227);
		panelEditar.add(panelLibroE);
		panelLibroE.setLayout(null);
		
		lblTituloE = new JLabel("T\u00EDtulo:");
		lblTituloE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblTituloE.setBounds(28, 3, 30, 14);
		panelLibroE.add(lblTituloE);
		
		textFieldTituloE = new JTextField();
		textFieldTituloE.setColumns(10);
		textFieldTituloE.setBounds(62, 0, 321, 20);
		panelLibroE.add(textFieldTituloE);
		
		lblAutorE = new JLabel("Autor:");
		lblAutorE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblAutorE.setBounds(27, 27, 31, 14);
		panelLibroE.add(lblAutorE);
		
		textFieldAutorE = new JTextField();
		textFieldAutorE.setColumns(10);
		textFieldAutorE.setBounds(62, 24, 321, 20);
		panelLibroE.add(textFieldAutorE);
		
		lblCodigoE = new JLabel("C\u00F3digo:");
		lblCodigoE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblCodigoE.setBounds(21, 51, 37, 14);
		panelLibroE.add(lblCodigoE);
		
		textFieldCodigoE = new JTextField();
		textFieldCodigoE.setEditable(false);
		textFieldCodigoE.setColumns(10);
		textFieldCodigoE.setBounds(62, 48, 321, 20);
		panelLibroE.add(textFieldCodigoE);
		
		lblResumenE = new JLabel("Resumen:");
		lblResumenE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblResumenE.setBounds(10, 72, 48, 14);
		panelLibroE.add(lblResumenE);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 72, 321, 155);
		panelLibroE.add(scrollPane);
		
		textPaneE = new JTextPane();
		scrollPane.setViewportView(textPaneE);
		textPaneE.setBorder(null);
		
		chckbxMarcarComoDevuelto = new JCheckBox("Marcar como devuelto");
		chckbxMarcarComoDevuelto.setBackground(new Color(255, 228, 196));
		chckbxMarcarComoDevuelto.setForeground(new Color(220, 20, 60));
		chckbxMarcarComoDevuelto.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxMarcarComoDevuelto.setBounds(171, 288, 153, 23);
		panelEditar.add(chckbxMarcarComoDevuelto);
		
		/**
		 * PESTAÑA USUARIOS
		 */
		usuarios = new JPanel();
		usuarios.setBorder(new LineBorder(new Color(220, 20, 60), 3));
		usuarios.setBackground(new Color(255, 228, 196));
		tabbedPane.addTab("Usuarios", null, usuarios, null);
		cu=new CardLayout(0,0);
		usuarios.setLayout(cu);
		
		//PANEL BUSCAR
		panelBuscarU = new JPanel();
		panelBuscarU.setBackground(new Color(255, 228, 196));
		usuarios.add(panelBuscarU, "name_410186620729100");
		panelBuscarU.setLayout(null);
		
		lblFiltrosU = new JLabel("B\u00FAsqueda por: ");
		lblFiltrosU.setForeground(new Color(220, 20, 60));
		lblFiltrosU.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblFiltrosU.setBounds(10, 11, 108, 25);
		panelBuscarU.add(lblFiltrosU);
		
		panelFiltrosU = new JPanel();
		panelFiltrosU.setBackground(new Color(255, 228, 196));
		panelFiltrosU.setBounds(122, 11, 274, 24);
		panelBuscarU.add(panelFiltrosU);
		GridBagLayout gbl_panelFiltrosU = new GridBagLayout();
		gbl_panelFiltrosU.columnWidths = new int[]{68, 68, 68, 68, 0};
		gbl_panelFiltrosU.rowHeights = new int[]{24, 0};
		gbl_panelFiltrosU.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelFiltrosU.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelFiltrosU.setLayout(gbl_panelFiltrosU);
		
		rdbtnDni = new JRadioButton("DNI");
		rdbtnDni.setBackground(new Color(255, 228, 196));
		rdbtnDni.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GridBagConstraints gbc_rdbtnDni = new GridBagConstraints();
		gbc_rdbtnDni.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtnDni.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnDni.gridx = 0;
		gbc_rdbtnDni.gridy = 0;
		panelFiltrosU.add(rdbtnDni, gbc_rdbtnDni);
		
		rdbtnNombre = new JRadioButton("Nombre");
		rdbtnNombre.setBackground(new Color(255, 228, 196));
		rdbtnNombre.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GridBagConstraints gbc_rdbtnNombre = new GridBagConstraints();
		gbc_rdbtnNombre.fill = GridBagConstraints.BOTH;
		gbc_rdbtnNombre.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnNombre.gridx = 1;
		gbc_rdbtnNombre.gridy = 0;
		panelFiltrosU.add(rdbtnNombre, gbc_rdbtnNombre);
		
		rdbtnApellidos = new JRadioButton("Apellidos");
		rdbtnApellidos.setBackground(new Color(255, 228, 196));
		rdbtnApellidos.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GridBagConstraints gbc_rdbtnApellidos = new GridBagConstraints();
		gbc_rdbtnApellidos.fill = GridBagConstraints.BOTH;
		gbc_rdbtnApellidos.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnApellidos.gridx = 2;
		gbc_rdbtnApellidos.gridy = 0;
		panelFiltrosU.add(rdbtnApellidos, gbc_rdbtnApellidos);
		
		rdbtnCorreo = new JRadioButton("Correo");
		rdbtnCorreo.setSelected(true);
		rdbtnCorreo.setBackground(new Color(255, 228, 196));
		rdbtnCorreo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GridBagConstraints gbc_rdbtnCorreo = new GridBagConstraints();
		gbc_rdbtnCorreo.fill = GridBagConstraints.BOTH;
		gbc_rdbtnCorreo.gridx = 3;
		gbc_rdbtnCorreo.gridy = 0;
		panelFiltrosU.add(rdbtnCorreo, gbc_rdbtnCorreo);
		
		grupoU = new ButtonGroup();
		grupoU.add(rdbtnDni);
		grupoU.add(rdbtnNombre);
		grupoU.add(rdbtnApellidos);
		grupoU.add(rdbtnCorreo);
		
		
		textFieldBuscarU = new JTextField();
		textFieldBuscarU.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		textFieldBuscarU.setColumns(10);
		textFieldBuscarU.setBounds(10, 42, 304, 23);
		panelBuscarU.add(textFieldBuscarU);
		
		btnBuscarU = new JButton("Buscar");
		btnBuscarU.setForeground(new Color(220, 20, 60));
		btnBuscarU.setFont(new Font("Arial", Font.BOLD, 11));
		btnBuscarU.setBackground(Color.WHITE);
		btnBuscarU.setBounds(320, 42, 76, 23);
		panelBuscarU.add(btnBuscarU);
		
	
		
		panelBotonesU = new JPanel();
		panelBotonesU.setBackground(new Color(255, 228, 196));
		panelBotonesU.setBounds(399, 140, 156, 183);
		panelBuscarU.add(panelBotonesU);
		panelBotonesU.setLayout(new MigLayout("", "[100%]", "[20%][20%][20%][20%]"));
		
		btnAnadirU = new JButton("A\u00F1adir");
		btnAnadirU.setForeground(new Color(220, 20, 60));
		btnAnadirU.setFont(new Font("Arial", Font.BOLD, 11));
		btnAnadirU.setBackground(new Color(255, 255, 255));
		panelBotonesU.add(btnAnadirU, "cell 0 0,grow");
		
		btnEditarU = new JButton("Editar");
		btnEditarU.setForeground(new Color(220, 20, 60));
		btnEditarU.setFont(new Font("Arial", Font.BOLD, 11));
		btnEditarU.setBackground(new Color(255, 255, 255));
		panelBotonesU.add(btnEditarU, "cell 0 1,grow");
		
		btnBloquear = new JButton("Bloquear");
		btnBloquear.setForeground(new Color(220, 20, 60));
		btnBloquear.setFont(new Font("Arial", Font.BOLD, 11));
		btnBloquear.setBackground(new Color(255, 255, 255));
		panelBotonesU.add(btnBloquear, "cell 0 2,grow");
		
		btnEliminarU = new JButton("Eliminar");
		btnEliminarU.setForeground(new Color(220, 20, 60));
		btnEliminarU.setFont(new Font("Arial", Font.BOLD, 11));
		btnEliminarU.setBackground(new Color(255, 255, 255));
		panelBotonesU.add(btnEliminarU, "cell 0 3,grow");
		
		panelCheckBxU = new JPanel();
		panelCheckBxU.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelCheckBxU.setBackground(new Color(240, 128, 128));
		panelCheckBxU.setBounds(406, 11, 142, 129);
		panelBuscarU.add(panelCheckBxU);
		
		chckbxUsuariosBloqueados = new JCheckBox("Bloqueados");
		chckbxUsuariosBloqueados.setSelected(false);
		chckbxUsuariosBloqueados.setForeground(Color.WHITE);
		chckbxUsuariosBloqueados.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxUsuariosBloqueados.setBackground(new Color(240, 128, 128));
		
		chckbxAdministrador = new JCheckBox("Administradores");
		chckbxAdministrador.setSelected(false);
		chckbxAdministrador.setForeground(Color.WHITE);
		chckbxAdministrador.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxAdministrador.setBackground(new Color(240, 128, 128));
		
		grupoFiltroUsuario=new ButtonGroup();
		grupoFiltroUsuario.add(chckbxAdministrador);
		grupoFiltroUsuario.add(chckbxUsuariosBloqueados);
		
		lblFiltrarPorU = new JLabel("Filtrar por:");
		lblFiltrarPorU.setForeground(new Color(220, 20, 60));
		lblFiltrarPorU.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		GroupLayout gl_panelCheckBxU = new GroupLayout(panelCheckBxU);
		gl_panelCheckBxU.setHorizontalGroup(
			gl_panelCheckBxU.createParallelGroup(Alignment.LEADING)
				.addGap(0, 142, Short.MAX_VALUE)
				.addGroup(gl_panelCheckBxU.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCheckBxU.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxUsuariosBloqueados)
						.addComponent(chckbxAdministrador)
						.addComponent(lblFiltrarPorU, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panelCheckBxU.setVerticalGroup(
			gl_panelCheckBxU.createParallelGroup(Alignment.LEADING)
				.addGap(0, 129, Short.MAX_VALUE)
				.addGroup(gl_panelCheckBxU.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFiltrarPorU, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(chckbxUsuariosBloqueados)
					.addGap(18)
					.addComponent(chckbxAdministrador)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panelCheckBxU.setLayout(gl_panelCheckBxU);
		cu.addLayoutComponent(panelBuscarU, "1");
		
		panelBuscador = new JPanel();
		panelBuscador.setBounds(10, 70, 386, 239);
		panelBuscarU.add(panelBuscador);
		panelBuscador.setLayout(new BorderLayout(0,0));
		
		scrollPaneUsuarios = new JScrollPane();
		panelBuscador.add(scrollPaneUsuarios);
		
		tablaUsuarios = new JTable();
		tablaUsuarios.setFillsViewportHeight(true);
		tablaUsuarios.setModel(p.modelarTabla("SELECT DNI, CORREO, NOMBRE, APELLIDOS, BLOQUEO, ADMIN FROM USUARIO ORDER BY CORREO"));
		tablaUsuarios.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		preferenciasTamanoTablaUsuarios();
		
		scrollPaneUsuarios.setViewportView(tablaUsuarios);
		
		//PANEL AÑADIR
		panelAnadirU = new JPanel();
		panelAnadirU.setBackground(new Color(255, 228, 196));
		usuarios.add(panelAnadirU, "name_410425274078800");
		panelAnadirU.setLayout(null);
		
		lblAnadirUsuario = new JLabel("A\u00F1adir usuario");
		lblAnadirUsuario.setForeground(new Color(220, 20, 60));
		lblAnadirUsuario.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblAnadirUsuario.setBounds(10, 11, 165, 31);
		panelAnadirU.add(lblAnadirUsuario);
		
		btnConfirmarU = new JButton("Confirmar");
		btnConfirmarU.setForeground(new Color(220, 20, 60));
		btnConfirmarU.setFont(new Font("Arial", Font.BOLD, 13));
		btnConfirmarU.setBackground(new Color(255, 250, 240));
		btnConfirmarU.setAlignmentX(1.0f);
		btnConfirmarU.setBounds(438, 284, 104, 31);
		panelAnadirU.add(btnConfirmarU);
		
		btnCancelarAnadirU = new JButton("Cancelar");
		btnCancelarAnadirU.setForeground(new Color(220, 20, 60));
		btnCancelarAnadirU.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelarAnadirU.setBackground(new Color(255, 250, 240));
		btnCancelarAnadirU.setAlignmentX(1.0f);
		btnCancelarAnadirU.setBounds(10, 284, 99, 31);
		panelAnadirU.add(btnCancelarAnadirU);
		
		panelCrearUsuario = new JPanel();
		panelCrearUsuario.setBackground(new Color(255, 228, 196));
		panelCrearUsuario.setBounds(124, 85, 309, 189);
		panelAnadirU.add(panelCrearUsuario);
		panelCrearUsuario.setLayout(new MigLayout("", "[50%][50%]", "[16%][16%][16%][16%][16%][16%]"));
		
		lblNombreU = new JLabel("Nombre:");
		lblNombreU.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		panelCrearUsuario.add(lblNombreU, "cell 0 0");
		
		textFieldNombreU = new JTextField();
		panelCrearUsuario.add(textFieldNombreU, "cell 1 0,growx");
		textFieldNombreU.setColumns(10);
		
		lblApellidosU = new JLabel("Apellidos:");
		lblApellidosU.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		panelCrearUsuario.add(lblApellidosU, "cell 0 1");
		
		textFieldApellidosU = new JTextField();
		panelCrearUsuario.add(textFieldApellidosU, "cell 1 1,growx");
		textFieldApellidosU.setColumns(10);
		
		lblDniU = new JLabel("DNI:");
		lblDniU.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		panelCrearUsuario.add(lblDniU, "cell 0 2");
		
		textFieldDniU = new JTextField();
		panelCrearUsuario.add(textFieldDniU, "cell 1 2,growx");
		textFieldDniU.setColumns(10);
		
		lblCorreoU = new JLabel("Correo:");
		lblCorreoU.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		panelCrearUsuario.add(lblCorreoU, "cell 0 3");
		
		textFieldCorreoU = new JTextField();
		panelCrearUsuario.add(textFieldCorreoU, "cell 1 3,growx");
		textFieldCorreoU.setColumns(10);
		
		lblContrasenaU = new JLabel("Contrase\u00F1a:");
		lblContrasenaU.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		panelCrearUsuario.add(lblContrasenaU, "cell 0 4");
		
		passwordFieldContrasenaU = new JPasswordField();
		panelCrearUsuario.add(passwordFieldContrasenaU, "cell 1 4,growx");
		
		lblRepetirContrasena = new JLabel("Repetir contrase\u00F1a:");
		lblRepetirContrasena.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		panelCrearUsuario.add(lblRepetirContrasena, "cell 0 5");
		
		passwordFieldContrasena2U = new JPasswordField();
		panelCrearUsuario.add(passwordFieldContrasena2U, "cell 1 5,growx");
		
		JSeparator separatorU = new JSeparator();
		separatorU.setBounds(109, 79, 335, 2);
		panelAnadirU.add(separatorU);
		
		JLabel lblComplete = new JLabel("Complete los campos");
		lblComplete.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplete.setForeground(new Color(220, 20, 60));
		lblComplete.setFont(new Font("Arial", Font.PLAIN, 13));
		lblComplete.setBounds(124, 53, 309, 26);
		panelAnadirU.add(lblComplete);
		
		lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(new Color(220, 20, 60));
		lblMensaje.setFont(new Font("Arial", Font.PLAIN, 11));
		lblMensaje.setBounds(125, 276, 309, 20);
		panelAnadirU.add(lblMensaje);
		cu.addLayoutComponent(panelAnadirU, "2");
		
		//PANEL EDITAR
		panelEditarU = new JPanel();
		panelEditarU.setBackground(new Color(255, 228, 196));
		usuarios.add(panelEditarU, "name_410478697495100");
		panelEditarU.setLayout(null);
		
		lblEditarU = new JLabel("Editar credenciales de usuario");
		lblEditarU.setForeground(new Color(220, 20, 60));
		lblEditarU.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		lblEditarU.setBounds(10, 11, 368, 37);
		panelEditarU.add(lblEditarU);
		
		btnConfirmarCambiosU = new JButton("Confirmar cambios");
		btnConfirmarCambiosU.setForeground(new Color(220, 20, 60));
		btnConfirmarCambiosU.setFont(new Font("Arial", Font.BOLD, 13));
		btnConfirmarCambiosU.setBackground(new Color(255, 250, 240));
		btnConfirmarCambiosU.setAlignmentX(1.0f);
		btnConfirmarCambiosU.setBounds(378, 284, 164, 31);
		panelEditarU.add(btnConfirmarCambiosU);
		
		btnCancelarEditarU = new JButton("Cancelar");
		btnCancelarEditarU.setForeground(new Color(220, 20, 60));
		btnCancelarEditarU.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelarEditarU.setBackground(new Color(255, 250, 240));
		btnCancelarEditarU.setAlignmentX(1.0f);
		btnCancelarEditarU.setBounds(10, 284, 99, 31);
		panelEditarU.add(btnCancelarEditarU);
		
		panelE1 = new JPanel();
		panelE1.setBackground(new Color(255, 228, 196));
		panelE1.setBounds(10, 59, 258, 214);
		panelEditarU.add(panelE1);
		panelE1.setLayout(new MigLayout("", "[][grow]", "[20%][20%][20%][20%][20%]"));
		
		lblNombreE = new JLabel("Nombre:");
		lblNombreE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		panelE1.add(lblNombreE, "cell 0 0,alignx trailing");
		
		textFieldNombreNuevo = new JTextField();
		panelE1.add(textFieldNombreNuevo, "cell 1 0,growx");
		textFieldNombreNuevo.setColumns(10);
		
		lblApellidosE = new JLabel("Apellidos:");
		lblApellidosE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		panelE1.add(lblApellidosE, "cell 0 1,alignx trailing");
		
		textFieldApellidosNuevos = new JTextField();
		panelE1.add(textFieldApellidosNuevos, "cell 1 1,growx");
		textFieldApellidosNuevos.setColumns(10);
		
		lblCorreoE = new JLabel("Correo:");
		lblCorreoE.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		panelE1.add(lblCorreoE, "cell 0 2,alignx trailing");
		
		textFieldCorreoNuevo = new JTextField();
		panelE1.add(textFieldCorreoNuevo, "cell 1 2,growx");
		textFieldCorreoNuevo.setColumns(10);
		
		lblContraseaNueva_1 = new JLabel("Contrase\u00F1a:");
		panelE1.add(lblContraseaNueva_1, "cell 0 3,alignx right");
		lblContraseaNueva_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		
		passwordFieldContrasenaNueva = new JPasswordField();
		panelE1.add(passwordFieldContrasenaNueva, "cell 1 3,growx");
		
		lblRepetirContrasena_1 = new JLabel("Repetir contrasena:");
		panelE1.add(lblRepetirContrasena_1, "cell 0 4");
		lblRepetirContrasena_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		
		passwordFieldRepContrasenaNueva = new JPasswordField();
		panelE1.add(passwordFieldRepContrasenaNueva, "cell 1 4,growx");
		
		chckbxDerechosDeAdministrador = new JCheckBox("Derechos de administrador**");
		chckbxDerechosDeAdministrador.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxDerechosDeAdministrador.setBackground(new Color(255, 228, 196));
		chckbxDerechosDeAdministrador.setBounds(330, 140, 176, 23);
		panelEditarU.add(chckbxDerechosDeAdministrador);
		
		separator = new JSeparator();
		separator.setBounds(278, 181, 264, 1);
		panelEditarU.add(separator);
		
		txtpnParaGuardarLos = new JTextPane();
		txtpnParaGuardarLos.setText("Para guardar los cambios, inserte la contrase\u00F1a de administraci\u00F3n.");
		txtpnParaGuardarLos.setForeground(new Color(220, 20, 60));
		txtpnParaGuardarLos.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnParaGuardarLos.setBackground(new Color(255, 228, 196));
		txtpnParaGuardarLos.setBounds(278, 193, 264, 34);
		panelEditarU.add(txtpnParaGuardarLos);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblContrasea.setBounds(294, 240, 60, 14);
		panelEditarU.add(lblContrasea);
		
		lblNoSe = new JLabel("** no se recomienda esta acci\u00F3n");
		lblNoSe.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNoSe.setForeground(new Color(220, 20, 60));
		lblNoSe.setBounds(330, 160, 164, 14);
		panelEditarU.add(lblNoSe);
		cu.addLayoutComponent(panelEditarU, "3");
		
		passwordFieldContrasenaAdmin = new JPasswordField();
		passwordFieldContrasenaAdmin.setBounds(356, 238, 138, 20);
		panelEditarU.add(passwordFieldContrasenaAdmin);
		
		chckbxDesbloquear = new JCheckBox("Desbloquear*");
		chckbxDesbloquear.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		chckbxDesbloquear.setBackground(new Color(255, 228, 196));
		chckbxDesbloquear.setBounds(330, 73, 164, 23);
		panelEditarU.add(chckbxDesbloquear);
		
		txtpnSoloSi = new JTextPane();
		txtpnSoloSi.setBackground(new Color(255, 228, 196));
		txtpnSoloSi.setBorder(null);
		txtpnSoloSi.setEditable(false);
		txtpnSoloSi.setForeground(new Color(220, 20, 60));
		txtpnSoloSi.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnSoloSi.setText("* solo si el usuario se encuentra bloqueado actualmente");
		txtpnSoloSi.setBounds(330, 93, 164, 40);
		panelEditarU.add(txtpnSoloSi);
		
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
		btncontactanos.setBackground(new Color(240, 128, 128));
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
		
		btnEditarInfo = new JButton("Editar*");
		btnEditarInfo.setForeground(new Color(220, 20, 60));
		btnEditarInfo.setFont(new Font("Arial", Font.BOLD, 11));
		btnEditarInfo.setBackground(Color.WHITE);
		btnEditarInfo.setBounds(256, 281, 83, 28);
		panelInformacion.add(btnEditarInfo);
		co.addLayoutComponent(panelInformacion, "2");
		
		JTextPane txtpnLosCambiosSe = new JTextPane();
		txtpnLosCambiosSe.setForeground(new Color(220, 20, 60));
		txtpnLosCambiosSe.setFont(new Font("Arial", Font.PLAIN, 9));
		txtpnLosCambiosSe.setBackground(new Color(255, 228, 196));
		txtpnLosCambiosSe.setText("* Los cambios se guardan autom\u00E1ticamente");
		txtpnLosCambiosSe.setBounds(115, 281, 131, 39);
		panelInformacion.add(txtpnLosCambiosSe);
		

		
		frmLapacalee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrmLapacalee() {
		return frmLapacalee;
	}
	public JPanel getBiblioteca() {
		return biblioteca;
	}
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public JButton getBtnDetalles() {
		return btnDetalles;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public JButton getBtnAnadir() {
		return btnAnadir;
	}
	public JButton getBtnEditar() {
		return btnEditar;
	}
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}
	public JButton getBtnCancelarAnadir() {
		return btnCancelarAnadir;
	}
	public JButton getBtnConfirmarCambios() {
		return btnConfirmarCambios;
	}
	public JButton getBtnCancelarEditar() {
		return btnCancelarEditar;
	}
	public JPanel getOpciones() {
		return opciones;
	}
	public JButton getBtnInformacion() {
		return btnInformacion;
	}
	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JButton getBtncontactanos() {
		return btncontactanos;
	}
	public JButton getBtnAtras() {
		return btnAtras;
	}
	public JButton getBtnEditarInfo() {
		return btnEditarInfo;
	}
	public CardLayout getCb() {
		return cb;
	}
	public CardLayout getCo() {
		return co;
	}
	public JButton getBtnBuscarU() {
		return btnBuscarU;
	}
	public JButton getBtnAnadirU() {
		return btnAnadirU;
	}
	public JButton getBtnEditarU() {
		return btnEditarU;
	}
	public JButton getBtnBloquear() {
		return btnBloquear;
	}
	public JButton getBtnEliminarU() {
		return btnEliminarU;
	}
	public JButton getBtnConfirmarU() {
		return btnConfirmarU;
	}
	public JButton getBtnCancelarAnadirU() {
		return btnCancelarAnadirU;
	}
	public JButton getBtnConfirmarCambiosU() {
		return btnConfirmarCambiosU;
	}
	public JButton getBtnCancelarEditarU() {
		return btnCancelarEditarU;
	}
	public CardLayout getCu() {
		return cu;
	}
	public JPanel getUsuarios() {
		return usuarios;
	}
	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}
	public JTextField getTextFieldApellidos() {
		return textFieldApellidos;
	}
	public JTextField getTextFieldCorreo() {
		return textFieldCorreo;
	}
	public JTextField getTextFieldDNI() {
		return textFieldDNI;
	}
	public JTextPane getTxtpnLapacalee() {
		return txtpnLapacalee;
	}
	public JLabel getLblMensaje() {
		return lblMensaje;
	}
	public JTable getTablaLibros() {
		return tablaLibros;
	}
	public JTable getTablaUsuarios() {
		return tablaUsuarios;
	}
	public JLabel getLblMensajeAnadirLibro() {
		return lblMensajeAnadirLibro;
	}
	public JCheckBox getChckbxMarcarComoDevuelto() {
		return chckbxMarcarComoDevuelto;
	}
	public JPasswordField getPasswordFieldContrasenaAdmin() {
		return passwordFieldContrasenaAdmin;
	}
	public JCheckBox getChckbxDerechosDeAdministrador() {
		return chckbxDerechosDeAdministrador;
	}
	public JCheckBox getChckbxDesbloquear() {
		return chckbxDesbloquear;
	}
	public JTextField getTextFieldBuscar() {
		return textFieldBuscar;
	}
	public JTextField getTextFieldBuscarU() {
		return textFieldBuscarU;
	}
	public JCheckBox getChckbxDisponible() {
		return chckbxDisponible;
	}
	

}
