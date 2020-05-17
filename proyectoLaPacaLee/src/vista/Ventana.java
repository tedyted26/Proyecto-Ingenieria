package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import accesoDB.AccesoDB;
import accesoDB.PersistenciaDatos;
import net.proteanit.sql.DbUtils;
import javax.swing.border.BevelBorder;

public class Ventana {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}
	

	JScrollPane scrollPane;
	PersistenciaDatos p;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		p=new PersistenciaDatos();
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		table.setModel(p.modelarTabla("SELECT * FROM LIBRO"));
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		scrollPane.setViewportView(table);
	}

}
