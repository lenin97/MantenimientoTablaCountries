package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Countries;
import modelo.Operacion;
import modelo.Regions;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class BuscarFila extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblRegionid;
	private JButton btnBuscar;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox comboRegId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarFila frame = new BuscarFila();
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
	public BuscarFila() {
		setTitle("Buscar por Region_id\r\n\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 417, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblRegionid = new JLabel("Region_id:");
			lblRegionid.setBounds(104, 42, 79, 14);
			contentPane.add(lblRegionid);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(151, 70, 89, 23);
			contentPane.add(btnBuscar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 108, 381, 211);
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
				table.getColumnModel().getColumn(1).setPreferredWidth(91);
				scrollPane.setViewportView(table);
			}
		}
		{
			comboRegId = new JComboBox();
			comboRegId.setBounds(193, 39, 79, 20);
			contentPane.add(comboRegId);
		}
		cargaCombo();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
	}
	private void cargaCombo(){
		Operacion op= new Operacion();
		List lista= new ArrayList<Regions>();
		Regions reg= new Regions();
		
		try {
			lista= op.tableRegions();
			Iterator<Regions> it= lista.iterator();
			while (it.hasNext()) {
	    		reg= it.next();	    		
	    		comboRegId.addItem(reg.getRegion_id());
				//System.out.println(pais.toString());
				
			}			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//cargaCombo
	
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		int RegId = Integer.parseInt(comboRegId.getSelectedItem().toString());
		List lista = new ArrayList<Countries>();
		Operacion op = new Operacion();
		Countries pais= new Countries();
		
		DefaultTableModel tabla=(DefaultTableModel) table.getModel();
		tabla.setRowCount(0);
		try {
			
			lista = op.searchCountry(RegId);			
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
