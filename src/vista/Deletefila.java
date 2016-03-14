package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Countries;
import modelo.Operacion;
import modelo.Regions;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Deletefila extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCountryname;
	private JButton btnEliminar;
	private JComboBox comboCtrName;
	private JButton btnActualizzarLista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deletefila frame = new Deletefila();
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
	public Deletefila() {
		setTitle("Eliminar datos ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblCountryname = new JLabel("Country_name: ");
			lblCountryname.setBounds(21, 29, 91, 14);
			contentPane.add(lblCountryname);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(165, 68, 111, 23);
			contentPane.add(btnEliminar);
		}
		{
			comboCtrName = new JComboBox();
			comboCtrName.setBounds(122, 26, 122, 20);
			contentPane.add(comboCtrName);
		}
		{
			btnActualizzarLista = new JButton("Actualizar Lista");
			btnActualizzarLista.addActionListener(this);
			btnActualizzarLista.setBounds(260, 25, 136, 23);
			contentPane.add(btnActualizzarLista);
		}
		cargaCombo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizzarLista) {
			do_btnActualizzarLista_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
	}
	
	private void cargaCombo(){
		Operacion op= new Operacion();
		List lista= new ArrayList<Countries>();
		Countries ctr= new Countries();
		
		try {
			lista= op.tableCountries();
			Iterator<Countries> it= lista.iterator();
			while (it.hasNext()) {
	    		ctr= it.next();	    		
	    		comboCtrName.addItem(ctr.getCountryName());
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
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		String CtrName = comboCtrName.getSelectedItem().toString();
		
		Operacion op= new Operacion();
		try {
			op.deleteCountry(CtrName);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	protected void do_btnActualizzarLista_actionPerformed(ActionEvent e) {
		comboCtrName.removeAllItems();
		cargaCombo();
	}
}
