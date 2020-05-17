package vista;

import java.awt.*;
import javax.swing.*;

import model.Libro;
import net.miginfocom.swing.MigLayout;

public class PopUpInfo {

	private JDialog frmpopup;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private JLabel lblInfo;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblResumen;
	private JScrollPane scrollPane;
	private JTextPane textPane;
	private JLabel lblDisponible;
	
	/**
	 * Crea el popup
	 */
	public PopUpInfo() {
		initialize();
	}
	
	/**
	 * Función que rellena los campos del popup dependiendo del libro que se ha seleccionado
	 * @param libro libro seleccionado en la tabla
	 */
	public void rellenarDatos(Libro libro) {
		if (libro==null) {
			lblDisponible.setText("Error");
		}
		else {
			textFieldTitulo.setText(libro.getTitulo());
			textFieldAutor.setText(libro.getAutor());
			textPane.setText(libro.getResumen());
			if(libro.isPrestado()) {
				lblDisponible.setText("Este libro no está disponible");
			}
			else lblDisponible.setText("Este libro está disponible");
		}
	}

	/**
	 * Initializa los contenidos
	 */
	private void initialize() {
		Toolkit screen=Toolkit.getDefaultToolkit();
		Dimension dimension=screen.getScreenSize();
		frmpopup =new JDialog();
		frmpopup.getContentPane().setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		frmpopup.setTitle("LaPacaLee");
		frmpopup.setSize(dimension.width*1/4,dimension.height/2);
		frmpopup.setLocation(dimension.width*20/48,dimension.height/4);
		frmpopup.setVisible(false);
		frmpopup.setResizable(false);
		frmpopup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmpopup.setAlwaysOnTop(true);
		frmpopup.setIconImage(Toolkit.getDefaultToolkit().getImage("./library.png"));
		frmpopup.getContentPane().setBackground(new Color(255, 228, 196));
		frmpopup.getContentPane().setLayout(new MigLayout("", "[67.00][grow]", "[][][][230.00,grow][]"));
		
		lblInfo = new JLabel("Informaci\u00F3n de ejemplar");
		lblInfo.setForeground(new Color(220, 20, 60));
		lblInfo.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		frmpopup.getContentPane().add(lblInfo, "cell 0 0 2 1");
		
		lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		frmpopup.getContentPane().add(lblTitulo, "cell 0 1,alignx trailing");
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setEditable(false);
		frmpopup.getContentPane().add(textFieldTitulo, "cell 1 1,growx");
		textFieldTitulo.setColumns(10);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		frmpopup.getContentPane().add(lblAutor, "cell 0 2,alignx trailing");
		
		textFieldAutor = new JTextField();
		textFieldAutor.setEditable(false);
		frmpopup.getContentPane().add(textFieldAutor, "cell 1 2,growx");
		textFieldAutor.setColumns(10);
		
		lblResumen = new JLabel("Resumen");
		lblResumen.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		frmpopup.getContentPane().add(lblResumen, "cell 0 3,alignx right,aligny top");
		
		scrollPane = new JScrollPane();
		frmpopup.getContentPane().add(scrollPane, "cell 1 3,grow");
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		lblDisponible = new JLabel("");
		lblDisponible.setForeground(new Color(220, 20, 60));
		lblDisponible.setFont(new Font("Arial", Font.PLAIN, 11));
		frmpopup.getContentPane().add(lblDisponible, "cell 0 4 2 1,alignx center");
	}

	public JDialog getFrmpopup() {
		return frmpopup;
	}

	public void setFrmpopup(JDialog frmpopup) {
		this.frmpopup = frmpopup;
	}
	
	
}
