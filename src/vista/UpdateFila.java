package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Operacion;
import modelo.Regions;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class UpdateFila extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCountryname;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textName;
	private JTextField textCountryId;
	private JButton btnUpdateCountry;
	private JComboBox comboRegId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFila frame = new UpdateFila();
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
	public UpdateFila() {
		setTitle("Actualizar Country\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 356, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblCountryname = new JLabel("Country_name:");
			lblCountryname.setBounds(50, 42, 98, 14);
			contentPane.add(lblCountryname);
		}
		{
			lblNewLabel = new JLabel("Country_id:");
			lblNewLabel.setBounds(50, 83, 80, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Region_id:");
			lblNewLabel_1.setBounds(50, 130, 80, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			textName = new JTextField();
			textName.setBounds(170, 39, 86, 20);
			contentPane.add(textName);
			textName.setColumns(10);
		}
		{
			textCountryId = new JTextField();
			textCountryId.setBounds(170, 80, 86, 20);
			contentPane.add(textCountryId);
			textCountryId.setColumns(10);
		}
		{
			btnUpdateCountry = new JButton("Actualizar Country");
			btnUpdateCountry.addActionListener(this);
			btnUpdateCountry.setBounds(93, 193, 147, 23);
			contentPane.add(btnUpdateCountry);
		}
		{
			comboRegId = new JComboBox();
			comboRegId.setBounds(170, 127, 86, 20);
			contentPane.add(comboRegId);
		}
		cargaCombo();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdateCountry) {
			do_btnAddCountry_actionPerformed(e);
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
	protected void do_btnAddCountry_actionPerformed(ActionEvent e) {
		String CtrName= textName.getText();
		String CtrId  = textCountryId.getText();
		String  RegId = comboRegId.getSelectedItem().toString();
		
		Operacion op = new Operacion();
		String mss;
		try {
			mss = op.Compatibilidad(CtrId, CtrName, RegId);
			if (mss.length()==0) {
				try {
					op.actualizarByCountryName(CtrName, CtrId, RegId);
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, mss);
				
			}
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}	
		
		
	}
}
