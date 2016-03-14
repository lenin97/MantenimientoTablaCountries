package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import modelo.Countries;
import modelo.Operacion;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class VerTabla extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnActualizar;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerTabla frame = new VerTabla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VerTabla() {
		setTitle("Tabla Countries\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnActualizar = new JButton("Actualizar");
			btnActualizar.addActionListener(this);
			btnActualizar.setBounds(165, 217, 110, 23);
			contentPane.add(btnActualizar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 190);
			contentPane.add(scrollPane);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Country_id", "Country_name", "Region_id"
					}
				));
				table.getColumnModel().getColumn(1).setPreferredWidth(93);
				scrollPane.setViewportView(table);
			}
		}
		do_btnActualizar_actionPerformed(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
	}
	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
		
		List lista = new ArrayList<Countries>();
		Operacion op = new Operacion();
		Countries pais= new Countries();
        DefaultTableModel tabla = (DefaultTableModel) table.getModel();

		tabla.setRowCount(0);
		try {
			
			lista = op.tableCountries();			
			Iterator<Countries> it= lista.iterator();
			
	    	while (it.hasNext()) {
	    		pais= it.next();
	    		Object[] pro={pais.getCountryID(),pais.getCountryName(),pais.getRegionID()};
	    		tabla.addRow(pro);
				//System.out.println(pais.toString());
				
			}
	    	
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
