package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class InterfaceTableCountries extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAgregarFila;
	private JButton btnVerTablaCountries;
	private JButton btnActualizarFila;
	private JButton btnEliminarFila;
	private JButton btnBuscarFila;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceTableCountries frame = new InterfaceTableCountries();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceTableCountries() {
		setTitle("Mantenimiento tabla Countries");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 331, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnAgregarFila = new JButton("AGREGAR FILA");
			btnAgregarFila.addActionListener(this);
			btnAgregarFila.setBounds(98, 70, 140, 23);
			contentPane.add(btnAgregarFila);
		}
		{
			btnVerTablaCountries = new JButton("Ver Tabla \r\n");
			btnVerTablaCountries.addActionListener(this);
			btnVerTablaCountries.setBounds(98, 32, 140, 23);
			contentPane.add(btnVerTablaCountries);
		}
		{
			btnActualizarFila = new JButton("Actualizar fila");
			btnActualizarFila.addActionListener(this);
			btnActualizarFila.setBounds(98, 114, 140, 23);
			contentPane.add(btnActualizarFila);
		}
		{
			btnEliminarFila = new JButton("Eliminar fila");
			btnEliminarFila.addActionListener(this);
			btnEliminarFila.setBounds(98, 213, 140, 23);
			contentPane.add(btnEliminarFila);
		}
		{
			btnBuscarFila = new JButton("Buscar fila");
			btnBuscarFila.addActionListener(this);
			btnBuscarFila.setBounds(98, 162, 140, 23);
			contentPane.add(btnBuscarFila);
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminarFila) {
			do_btnEliminarFila_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnBuscarFila) {
			do_btnBuscarFila_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnActualizarFila) {
			do_btnActualizarFila_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAgregarFila) {
			do_btnAgregarFila_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnVerTablaCountries) {
			do_btnVerTablaCountries_actionPerformed(arg0);
		}
	}
	protected void do_btnVerTablaCountries_actionPerformed(ActionEvent arg0) {
	   
		VerTabla e = new VerTabla();
		e.setVisible(true);
		
	
	}
	protected void do_btnAgregarFila_actionPerformed(ActionEvent arg0) {
		Addfila e = new Addfila();
		e.setVisible(true);

	}
	protected void do_btnActualizarFila_actionPerformed(ActionEvent arg0) {
		UpdateFila e = new UpdateFila();
		e.setVisible(true);

	}
	protected void do_btnBuscarFila_actionPerformed(ActionEvent arg0) {
		BuscarFila e = new BuscarFila();
		e.setVisible(true);
	}
	protected void do_btnEliminarFila_actionPerformed(ActionEvent arg0) {
		Deletefila e = new Deletefila();
		e.setVisible(true);

	}
}
